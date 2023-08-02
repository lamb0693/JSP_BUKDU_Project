package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String strRefer = (String) request.getHeader("Referer");
		if(strRefer==null || (!strRefer.contains("localhost:8080"))) {
			System.out.println("--------외부로부터의 직접적인 조회 입니다-----origin : " + strRefer);
			request.setAttribute("result", "외부로 부터 주소열을 조작하면 안됨");
			String urlTo = "/sendToHomeWithResult.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
			dispatcher.forward(request, response);	
		} else {			
			HttpSession session = request.getSession();
			session.removeAttribute("mp_user_id");
			session.removeAttribute("mp_user_name");
			session.removeAttribute("mp_isAmdin");
			session.removeAttribute("mp_isLogin");
			
			System.out.println("-----LogoutController@doGet---remove session");	
			
			// index page로 이동
			String urlTo = "/index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
			dispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String strRefer = (String) request.getHeader("Referer");
		if(strRefer==null || (!strRefer.contains("localhost:8080"))) {
			System.out.println("--------외부로부터의 직접적인 조회 입니다-----origin : " + strRefer);
			request.setAttribute("result", "외부로 부터 주소열을 조작하면 안됨");
			String urlTo = "/sendToHomeWithResult.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
			dispatcher.forward(request, response);	
		}
//		String strRefer = (String) request.getHeader("");
//		System.out.println("---------Referer : " + strRefer);
		
		HttpSession session = request.getSession();
		session.removeAttribute("mp_user_id");
		session.removeAttribute("mp_user_name");
		session.removeAttribute("mp_isAmdin");
		session.removeAttribute("mp_isLogin");
		
		System.out.println("-----LogoutController@doPost---remove session");
		
		// index page로 이동
		String urlTo = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
		dispatcher.forward(request, response);	
	}

}
