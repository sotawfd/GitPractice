package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Account1;
import dto.Account2;
import dto.Account3;
import dto.Account4;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class Account1DAO {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerAccount(Account1 account) {
		String sql = "INSERT INTO account1 VALUES(?, ?, ?, ?, ?, ?, ? ,current_timestamp)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setInt(2, account.getAge());
			pstmt.setString(3, account.getGender());
			pstmt.setString(4, account.getNumber());
			pstmt.setString(5, account.getMail());
			pstmt.setString(6, salt);
			pstmt.setString(7, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	// 本のデータを全件取得する
				public static List<Account2> selectAllaccount() {
					// 返却用変数
					List<Account2> result = new ArrayList<>();

					String sql = "SELECT * FROM account1";
					
					try (
							Connection con = getConnection();
							PreparedStatement pstmt = con.prepareStatement(sql);
							){
						try (ResultSet rs = pstmt.executeQuery()){
							while(rs.next()) {
								String name=rs.getString("name");
								int age = rs.getInt("age");
								String gender = rs.getString("gender");
								String number = rs.getString("number");
								String mail = rs.getString("mail");

								Account2 A = new Account2(name,age, gender,number,mail);
								
								result.add(A);
							}
						}
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					return result;
	
}
				// 引数の名前を元にデータを1件 DELETE するメソッド
				public static int deleteAccount(Account3 A) {
					String sql = "DELETE FROM account1 WHERE mail = ?";
					int result = 0;

					try (
							Connection con = getConnection();	// DB接続
							PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
							){
						
						pstmt.setString(1,A.getMail());
					
						result = pstmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					} finally {
						System.out.println(result + "件削除しました。");
					}
					return result ;
				}				
				// ログイン処理
				public static Account4 login1(String mail, String hashedPw) {
					String sql = "SELECT * FROM account1 WHERE mail = ? AND password = ?";
					
					try (
							Connection con = getConnection();
							PreparedStatement pstmt = con.prepareStatement(sql);
							){
						pstmt.setString(1, mail);
						pstmt.setString(2, hashedPw);

						try (ResultSet rs = pstmt.executeQuery()){
							
							if(rs.next()) {
								String name = rs.getString("name");
								String salt = rs.getString("salt");
								String createdAt = rs.getString("created_at");
								
								return new Account4( name, mail, salt, null, null);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
					return null;
				}
				// メールアドレスを元にソルトを取得
				public static String getSalt(String mail) {
					String sql = "SELECT salt FROM account1 WHERE mail = ?";
					
					try (
							Connection con = getConnection();
							PreparedStatement pstmt = con.prepareStatement(sql);
							){
						pstmt.setString(1, mail);

						try (ResultSet rs = pstmt.executeQuery()){
							
							if(rs.next()) {
								String salt = rs.getString("salt");
								return salt;
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
					return null;
				}
}
				