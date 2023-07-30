package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
        System.out.println("-------------in LoginController.....------------");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.checkLogin(id, password);
		dao.closeJDBCCOnnection();
		
		HttpSession session = request.getSession(false);

		// 체크인 실패하면
		if(dto == null) {
			System.out.println("--LoginController---------login 실패--------------");
			session.removeAttribute("mp_user_id");
			session.removeAttribute("mp_isLogin");
			session.removeAttribute("mp_user_name");
			session.removeAttribute("mp_isAdmin");
		} else { // 성공하면 session check 하고 index page로 return
			System.out.println("--LoginController---------login 성공  set session -------------");
			session.setAttribute("mp_user_id", dto.getId());
			session.setAttribute("mp_isLogin", "login_state");
			session.setAttribute("mp_user_name", dto.getName());
			if(dto.isIsadmin()) session.setAttribute("mp_isAmdin", "admin");
			else session.setAttribute("mp_isAmdin", "general");
		}
		
		String urlTo = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
		dispatcher.forward(request, response);	
	}

}
