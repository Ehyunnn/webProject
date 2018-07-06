package test.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
@WebServlet({"/recipe04.do","/recipe04html.do"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/recipe04.do")) {
			String name = "";
			PrintWriter out = response.getWriter();
			if(request.getParameter("name")==null){
				out.print("sorry");
			}else{
				name = request.getParameter("name");
				System.out.println(name);
				if(name.equals("1")){
					out.print("aaaa");
				}else if(name.equals("2")){
					out.print("bbbb");
				}else if(name.equals("3")){
					out.print("cccc");
				}else {
					out.print("dddd");
				}
			}
		}else if(request.getServletPath().equals("/recipe04html.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher(
							"chapter13_XMLHttpRequest/recipe4_onclick.html");
			rd.forward(request, response);
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
