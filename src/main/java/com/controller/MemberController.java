package com.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.util.MyPasswordEncoder;

/**
 * Servlet implementation class DispMember
 */
@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public boolean checkSession(HttpServletRequest request) {
		javax.servlet.http.HttpSession session = request.getSession();
		if(session.getAttribute("mp_user_id") == null) {
			System.out.println("--checkSession@BoardControiller--session  = false - ----");
			return false;
		}
		
		return true;
	}
	
	public void dispatchTo(String urlTo, HttpServletRequest request, HttpServletResponse response ) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String command = uri.substring( uri.lastIndexOf("/"));
		//System.out.println("------------- command in DispMember Servlet : " + command + "--------------");

		if(command.equals("/read.member")){
			System.out.println("------list.member  in doGet DispMember------");	
			
			MemberDAO dao = new MemberDAO();
			Vector<MemberDTO> vMembers = dao.selectAllMember();
			dao.closeJDBCCOnnection();
			
			System.out.println("============ vMember size =" + vMembers.size() + "--------");
			request.setAttribute("members", vMembers);
			
			String urlTo = "/member/list_member.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
			dispatcher.forward(request, response);
		} else if(command.equals("/create.member")){
			System.out.println("--------create.member  in doGet DispMember---------");
		} else if(command.equals("/update.member")){
			System.out.println("--------update.member  in doGet DispMember---------");
		} else if(command.equals("/delete.member")) {
			System.out.println("-------delete.member  in doGet DispMember----------");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String uri = request.getRequestURI();
		String command = uri.substring( uri.lastIndexOf("/"));
		//System.out.println("------------- command in DispMember Servlet : " + command + "--------------");
		
		if(command.equals("/read.member")){
			System.out.println("--------read.member  in doPost DispMember---------");
		} else if(command.equals("/create.member")){
			System.out.println("--------create.member  in doPost DispMember---------");
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String password = request.getParameter("password");
			String hashedPassword = MyPasswordEncoder.hashPassword(password);
			// System.out.println("hashedPassword : " + hashedPassword);
			
			MemberDAO dao = new MemberDAO();
			String result = dao.createMember(id, hashedPassword, name, tel);
			dao.closeJDBCCOnnection(); 
			
			request.setAttribute("result", result);
			dispatchTo("sendToHomeWithResult.jsp", request, response);	
		} else if(command.equals("/update.member")){
			System.out.println("--------update.member  in doPost DispMember---------");
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String password = request.getParameter("password");
			
			MemberDAO dao = new MemberDAO();
			String hashedPassword = MyPasswordEncoder.hashPassword(password);
			String result = dao.updateMember(id, hashedPassword, name, tel);
			dao.closeJDBCCOnnection(); 
			
			request.setAttribute("result", result);
			dispatchTo("member/sendToLogoutAfterUpdate.jsp", request, response);
			
		} else if(command.equals("/delete.member")) {
			System.out.println("-------delete.member  in doPost DispMember----------");
		}
	}

}
