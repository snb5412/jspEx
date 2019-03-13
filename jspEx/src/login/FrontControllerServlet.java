package login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.controller.Controller;
import login.controller.IndexController;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Map<String, Controller> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();
        map = new HashMap<>();
        
        //요청 PATH별 Controller 등록
        map.put("/index.do", new IndexController());
    }
    
    private String getUri(HttpServletRequest request) {
    	String uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = uri.substring(ctxPath.length());
    	
    	return path;
    }

    protected void move(HttpServletRequest request, HttpServletResponse response, String target) 
    				throws ServletException, IOException {
    	if(target.startsWith("redirect:")) {
	    	target = target.substring("redirect:".length());
	    	if(target.startsWith("/")) {
	    		target = request.getContextPath() + target;
	    	}
	    	response.sendRedirect(target);
    	} else {
    		target += ".jsp";
    		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
    		dispatcher.forward(request, response);
    	}
    	
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = getUri(request);
		Controller controller = map.get(uri);
		
		if(controller != null) {
			String target;
			if(request.getMethod().equalsIgnoreCase("GET")) {
				target = controller.doGet(request, response);
			} else {
				target = controller.doPost(request, response);
			}
			move(request, response, target);
		} else {
			response.sendError(404, uri + " 경로가 없습니다.");
		}
	}

}
