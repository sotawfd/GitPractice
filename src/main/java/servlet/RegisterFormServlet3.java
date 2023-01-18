package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Account1DAO;
import dto.Account3;

/**
 * Servlet implementation class RegisterFormServlet3
 */
@WebServlet("/RegisterFormServlet3")
public class RegisterFormServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFormServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
				request.setCharacterEncoding("UTF-8");
				
				// フォーム入力内容の取得
				String Mail = request.getParameter("mail");
				// 入力された情報を元にインスタンスを生成
				Account3 st = new Account3(Mail);
				
				// SQL実行
				int result = Account1DAO.deleteAccount(st);
				
				if(result == 1) {
					String view = "WEB-INF/view/kadai3result.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				} else {
					String view = "WEB-INF/view/fail.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
