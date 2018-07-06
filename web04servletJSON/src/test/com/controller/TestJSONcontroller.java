package test.com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import test.com.model.TestVO;

/**
 * Servlet implementation class TestJSONcontroller
 */
@WebServlet({ "/text.do", "/jsonObject.do", "/jsonArray.do", "/json_selectAll.do", "/json_selectOne.do",
		"/json_loginOK.do" })
public class TestJSONcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestJSONcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/text.do")) {
			PrintWriter out = response.getWriter();
			out.append("{");
			out.append("\"name\":\"kim\"");
			out.append("}");
		} else if (request.getServletPath().equals("/jsonObject.do")) {
			PrintWriter out = response.getWriter();

			TestVO vo = new TestVO();
			vo.setNum(99);
			vo.setName("yang");
			JSONObject obj = new JSONObject(vo);
			out.print(obj.toString());
		} else if (request.getServletPath().equals("/jsonArray.do")) {
			PrintWriter out = response.getWriter();

			ArrayList<TestVO> list = new ArrayList<TestVO>();
			TestVO vo = new TestVO();
			vo.setNum(99);
			vo.setName("yang");
			list.add(vo);
			list.add(vo);
			list.add(vo);
			JSONArray array = new JSONArray(list);

			out.write(array.toString());
		} else if (request.getServletPath().equals("/json_selectAll.do")) {
			try {
				String address = "http://localhost:8090/web03addressbook/json_selectAll.do";
				URL url = new URL(address);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				System.out.println("conn.getResponseCode():" + conn.getResponseCode());
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				StringBuilder data = new StringBuilder();
				String str = "";
				while ((str = br.readLine()) != null) {
					data.append(str);
				}
				System.out.println(data.toString());
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				JSONArray array = new JSONArray(data.toString());
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj = array.getJSONObject(i);
					out.print(obj.getInt("num") + " ");
					out.print(obj.getString("name") + " ");
					out.print(obj.getString("tel") + " ");
					out.print(obj.getString("address") + " ");
					out.print(obj.getString("wdate") + "<br>");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (request.getServletPath().equals("/json_selectOne.do")) {
			try {
				String address = "http://localhost:8090/web03addressbook/json_selectOne.do?num=24";
				URL url = new URL(address);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				System.out.println("conn.getResponseCode():" + conn.getResponseCode());
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				StringBuilder data = new StringBuilder();
				String str = "";
				while ((str = br.readLine()) != null) {
					data.append(str);
				}
				System.out.println(data.toString());
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				JSONObject obj = new JSONObject(data.toString());
				out.print(obj.getInt("num") + " ");
				out.print(obj.getString("name") + " ");
				out.print(obj.getString("tel") + " ");
				out.print(obj.getString("address") + " ");
				out.print(obj.getString("wdate") );
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (request.getServletPath().equals("/json_loginOK.do")) {
			try {
				String address = "http://localhost:8090/web03addressbook/json_loginOK.do?num=24&tel=010";
				URL url = new URL(address);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				System.out.println("conn.getResponseCode():" + conn.getResponseCode());
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				StringBuilder data = new StringBuilder();
				String str = "";
				while ((str = br.readLine()) != null) {
					data.append(str);
				}
				System.out.println(data.toString());
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				JSONObject obj = new JSONObject(data.toString());
				out.print(obj.getInt("flag"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
