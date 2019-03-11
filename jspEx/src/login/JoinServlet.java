package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.domain.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/joinForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = map(request);
		System.out.println(member);
		
		//회원 가입을 위한 유효성 검사 실패로 가정
		request.setAttribute("member", member);
		request.setAttribute("error", "입력하신 정보를 다시 확인해주시기 바랍니다.");
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/joinForm.jsp");
		dispatcher.forward(request, response);
	}

	private Member map(HttpServletRequest request) {
		Member member = Member.builder().userId(request.getParameter("userId"))
										.password(request.getParameter("password"))
										.name(request.getParameter("name"))
										.email(request.getParameter("email"))
										.phone(request.getParameter("phone"))
										.gender(request.getParameter("gender"))
										.build();			
		return member;
	}
}
