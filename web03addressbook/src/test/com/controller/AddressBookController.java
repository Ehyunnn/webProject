package test.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import test.com.model.AddressBookVO;
import test.com.service.AddressBookService;
import test.com.service.AddressBookServiceImpl;

/**
 * Servlet implementation class AddressBookController
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", "/selectAll.do", "/json_selectAll.do", "/selectOne.do",
		"/json_selectOne.do", "/updateOK.do", "/deleteOK.do", "/login.do", "/loginOK.do", "/json_loginOK.do",
		"/logout.do" })
public class AddressBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AddressBookService abservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressBookController() {
		super();
		System.out.println("AddressBookController()...");
		abservice = new AddressBookServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insertOK.do")) {
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			System.out.println(name);
			System.out.println(tel);
			System.out.println(address);

			AddressBookVO vo = new AddressBookVO();
			vo.setName(name);
			vo.setTel(tel);
			vo.setAddress(address);

			int flag = abservice.insert(vo);
			System.out.println("insert flag:" + flag);
			if (flag == 1) {
				System.out.println("insert successed...");
				response.sendRedirect("selectAll.do");
			} else {
				System.out.println("insert failed...");
				response.sendRedirect("insert.do");
			}
		} else if (sPath.equals("/selectAll.do")) {
			HttpSession session = request.getSession();
			System.out.println(session.getAttribute("num"));

			if (session.getAttribute("num") != null) {
				List<AddressBookVO> list = abservice.selectAll();
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("selectAll.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("login.do");
			}

		} else if (sPath.equals("/selectOne.do")) {
			String num = request.getParameter("num");

			AddressBookVO vo = new AddressBookVO();
			vo.setNum(Integer.parseInt(num));

			AddressBookVO vo2 = abservice.selectOne(vo);
			System.out.println(vo2.getNum());
			System.out.println(vo2.getName());
			System.out.println(vo2.getTel());
			System.out.println(vo2.getAddress());
			System.out.println(vo2.getWdate());
			request.setAttribute("vo2", vo2);

			RequestDispatcher rd = request.getRequestDispatcher("selectOne.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/updateOK.do")) {
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			System.out.println(num);
			System.out.println(name);
			System.out.println(tel);
			System.out.println(address);

			AddressBookVO vo = new AddressBookVO();
			vo.setNum(Integer.parseInt(num));
			vo.setName(name);
			vo.setTel(tel);
			vo.setAddress(address);

			int flag = abservice.update(vo);
			System.out.println("update flag:" + flag);
			if (flag == 1) {
				System.out.println("update successed...");
				response.sendRedirect("selectAll.do");
			} else {
				System.out.println("update failed...");
				response.sendRedirect("selectOne.do?num=" + num);
			}
		} else if (sPath.equals("/deleteOK.do")) {
			String num = request.getParameter("num");
			System.out.println(num);

			AddressBookVO vo = new AddressBookVO();
			vo.setNum(Integer.parseInt(num));

			int flag = abservice.delete(vo);
			System.out.println("delete flag:" + flag);
			if (flag == 1) {
				System.out.println("delete successed...");
				response.sendRedirect("selectAll.do");
			} else {
				System.out.println("delete failed...");
				response.sendRedirect("selectOne.do?num=" + num);
			}
		} else if (sPath.equals("/login.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/loginOK.do")) {
			String num = request.getParameter("num");
			String tel = request.getParameter("tel");
			System.out.println(num);
			System.out.println(tel);
			AddressBookVO vo = new AddressBookVO();
			vo.setNum(Integer.parseInt(num));
			vo.setTel(tel);
			int flag = abservice.loginOK(vo);
			if (flag == 1) {
				System.out.println("loginOK successed...");
				HttpSession session = request.getSession();
				session.setAttribute("num", num);
				session.setMaxInactiveInterval(300);// 5minute
				response.sendRedirect("selectAll.do");
			} else {
				System.out.println("loginOK failed...");
				response.sendRedirect("login.do?msg=loginfail");
			}
		} else if (sPath.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("num");
			response.sendRedirect("index.do");
		} else if (sPath.equals("/json_selectAll.do")) {
			PrintWriter out = response.getWriter();
			List<AddressBookVO> list = abservice.selectAll();
			JSONArray array = new JSONArray(list);

			out.print(array.toString());
		} else if (sPath.equals("/json_selectOne.do")) {
			String num = request.getParameter("num");

			AddressBookVO vo = new AddressBookVO();
			vo.setNum(Integer.parseInt(num));

			AddressBookVO vo2 = abservice.selectOne(vo);
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject(vo2);
			out.print(obj.toString());
		} else if (sPath.equals("/json_loginOK.do")) {
			String num = request.getParameter("num");
			String tel = request.getParameter("tel");
			System.out.println(num);
			System.out.println(tel);
			AddressBookVO vo = new AddressBookVO();
			vo.setNum(Integer.parseInt(num));
			vo.setTel(tel);
			int flag = abservice.loginOK(vo);
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("flag", flag);
			out.print(obj.toString());
		}

		else {

		}
	}

}
