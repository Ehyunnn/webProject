package test.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.Test01DAO;
import test.com.model.Test01DAOimpl;
import test.com.model.Test01VO;
import test.com.service.Test01Service;
import test.com.service.Test01ServiceImpl;

/**
 * Servlet implementation class Test01Controller
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", 
	"/selectAll.do","/selectOne.do","/updateOK.do","/deleteOK.do" })
public class Test01Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Test01Service service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test01Controller() {
        super();
        System.out.println("Test01Controller()...");
        service = new Test01ServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletPath());
		String sPath = request.getServletPath();
		if(sPath.equals("/index.do")) {
			RequestDispatcher rd = 
				request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			RequestDispatcher rd = 
					request.getRequestDispatcher("test/insert.jsp");
				rd.forward(request, response);
		}else if(sPath.equals("/insertOK.do")) {
			String column2 = request.getParameter("column2");
			String column3 = request.getParameter("column3");
			String column4 = request.getParameter("column4");
			String column5 = request.getParameter("column5");
			String column6 = request.getParameter("column6");
			System.out.println("column2:" + column2);
			System.out.println("column3:" + column3);
			System.out.println("column4:" + column4);
			System.out.println("column5:" + column5);
			System.out.println("column6:" + column6);

			Test01VO vo = new Test01VO();
			vo.setColumn2(column2);
			vo.setColumn3(column3);
			vo.setColumn4(column4);
			vo.setColumn5(column5);
			vo.setColumn6(column6);

			
			int result = service.insert(vo);
			if(result==1){
				System.out.println("insert successed...");
				response.sendRedirect("selectAll.do");
			}else{
				System.out.println("insert failed...");
			}
		}else if(sPath.equals("/selectAll.do")) {
			
			ArrayList<Test01VO> list = service.selectAll();
			request.setAttribute("list", list);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("test/selectAll.jsp");
				rd.forward(request, response);
		}else if(sPath.equals("/selectOne.do")) {
			String column1 = request.getParameter("column1");
			System.out.println(column1);
			Test01VO vo = new Test01VO();
			vo.setColumn1(Integer.parseInt(column1));
			
			Test01VO vo2 = service.selectOne(vo);
			System.out.println(vo2.getColumn1());
			System.out.println(vo2.getColumn2());
			System.out.println(vo2.getColumn3());
			System.out.println(vo2.getColumn4());
			System.out.println(vo2.getColumn5());
			System.out.println(vo2.getColumn6());
			request.setAttribute("vo2", vo2);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("test/selectOne.jsp");
				rd.forward(request, response);
		}else if(sPath.equals("/updateOK.do")) {
			String column1 = request.getParameter("column1");
			String column2 = request.getParameter("column2");
			String column3 = request.getParameter("column3");
			String column4 = request.getParameter("column4");
			String column5 = request.getParameter("column5");
			String column6 = request.getParameter("column6");
			System.out.println("column1:" + column1);
			System.out.println("column2:" + column2);
			System.out.println("column3:" + column3);
			System.out.println("column4:" + column4);
			System.out.println("column5:" + column5);
			System.out.println("column6:" + column6);

			Test01VO vo = new Test01VO();
			vo.setColumn1(Integer.parseInt(column1));
			vo.setColumn2(column2);
			vo.setColumn3(column3);
			vo.setColumn4(column4);
			vo.setColumn5(column5);
			vo.setColumn6(column6);

			
			int result = service.update(vo);
			if(result>0){
				System.out.println("update successed...");
				response.sendRedirect("selectAll.do");
			}else{
				System.out.println("update failed...");
			}
		}else if(sPath.equals("/deleteOK.do")) {
			String column1 = request.getParameter("column1");
			System.out.println("column1:" + column1);

			Test01VO vo = new Test01VO();
			vo.setColumn1(Integer.parseInt(column1));

			
			int result = service.delete(vo);
			if(result>0){
				System.out.println("delete successed...");
				response.sendRedirect("selectAll.do");
			}else{
				System.out.println("delete failed...");
			}
		}
	}

}
