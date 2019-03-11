package login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
					request.getRequestDispatcher("loginForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "pinksung";
		String pwd = "1234";
		String name = "성윤정";
		
		request.setCharacterEncoding("UTF-8");
		
		String target = request.getParameter("target");
		
		if(id.equals(request.getParameter("id")) &&
				pwd.equals(request.getParameter("pwd"))) {
				//로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				
				//target 이 있다면 target으로 이동 없다면 Main으로 이동
				if(target.isEmpty()) {
					response.sendRedirect("loginMain.jsp");
				} else {
					response.sendRedirect(target);
				}
		} else {
			request.setAttribute("error", "id 또는 비밀번호가 일치하지 않습니다.");
			request.setAttribute("target", target);
			doGet(request, response);
		}
	}

}
