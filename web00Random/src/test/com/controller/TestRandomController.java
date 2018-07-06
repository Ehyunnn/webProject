package test.com.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.TestNames;
import test.com.model.TestNamesRandom;
import test.com.model.TestNamesRandomImpl;

/**
 * Servlet implementation class TestRandomController
 */
@WebServlet({"/random.do","/randomPro.do"})
public class TestRandomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestRandomController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()....");
		
		if (request.getServletPath().compareTo("/random.do") == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("random.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()....");
		request.setCharacterEncoding("UTF-8");
		if (request.getServletPath().compareTo("/randomPro.do") == 0) {
			String[] names = new String[] { 
					request.getParameter("n01"),
					request.getParameter("n02"),
					request.getParameter("n03"),
					request.getParameter("n04"),
					request.getParameter("n05"),
					request.getParameter("n06"),
					request.getParameter("n07"),
					request.getParameter("n08"),
					request.getParameter("n09"),
					request.getParameter("n10"),
					request.getParameter("n11"),
					request.getParameter("n12"),
					request.getParameter("n13")
					};

			TestNamesRandom tnr = new TestNamesRandomImpl();
			TestNames tn = new TestNames();
			tn.setNames(names);
			String name = tnr.getRandomName(tn);
			System.out.println("name:"+name);
			
			name = URLEncoder.encode(name,"UTF-8");
			
			response.sendRedirect("random.do?name="+name);
		}
	}

}
