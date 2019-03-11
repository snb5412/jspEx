package login.member;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.domain.Member;
import login.domain.PageInfo;
import login.service.MemberService;
import login.service.MemberServiceImpl;
import login.util.ParseUtil;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        service = MemberServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		////////////Controller 파트는 아래와 같이 3파트로 나뉨///////////////////
		//1. 요청으로부터 VO 객체 얻기위한 정보 파싱
		int page = ParseUtil.parseInt(request.getParameter("page"));
		
		//2. 정보를 서비스의 입력으로 제공하여 VO객체 얻어오기
		PageInfo<Member> pi = service.getPage(page);
		request.setAttribute("pi", pi);
		
		//3. view 페이지로 이동
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/member/list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
