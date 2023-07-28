package com.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.dto.BoardDTO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	
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
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uri = request.getRequestURI();
		String command = uri.substring( uri.lastIndexOf("/"));
		//System.out.println("------------- command in DispMember Servlet : " + command + "--------------");

		if(command.equals("/read.board")){
			// session check
			if(checkSession(request)) {
				System.out.println("session login");
				System.out.println("------list.board  in doGet BoardController------");	
				
				BoardDAO dao = new BoardDAO();
				Vector<BoardDTO> vBoard = dao.selectAllBoard();
				
				System.out.println("============ vBoard size =" + vBoard.size() + "--------");
				request.setAttribute("boards", vBoard);
				dispatchTo("/board/list_board.jsp", request, response);
			}
			else {
				System.out.println("session logout");
				dispatchTo("index.jsp", request, response);
			}
				
		} else if(command.equals("/create.board")){
			System.out.println("--------create.board  in doGet BoardController---------");
		} else if(command.equals("/update.board")){
			System.out.println("--------update.board  in doGet BoardController---------");
		} else if(command.equals("/delete.board")) {
			System.out.println("-------delete.board  in doGet BoardController----------");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String uri = request.getRequestURI();
		String command = uri.substring( uri.lastIndexOf("/"));
		System.out.println("------------- command in DispMember Servlet : " + command + "--------------");
		
		//session check
		
		
		if(command.equals("/read.board")){
			System.out.println("--------create.board  in doPost BoardController---------");
		} else if(command.equals("/create.board")){
			System.out.println("--------create.board  in doPost BoardController---------");
			
			// login 상태 확인
			if(checkSession(request)) {
				// 새로운 Board생성
				request.setCharacterEncoding("UTF-8");
				String content = request.getParameter("content");
				String user_id = (String) request.getSession().getAttribute("mp_user_id");
				BoardDAO dao = new BoardDAO();
				int line = dao.createBoard(user_id, content);
				
				// 전체 만든 후 list page로 보내기
				dao=new BoardDAO();
				Vector<BoardDTO> vBoard = dao.selectAllBoard();
				System.out.println("============ vBoard size =" + vBoard.size() + "--------");
				request.setAttribute("boards", vBoard);
				request.setAttribute("created_line", line);	
				
				dispatchTo("/board/list_board.jsp", request, response);
			}
			else {
				System.out.println("session logout");
				dispatchTo("index.jsp", request, response);
			}			
		} else if(command.equals("/update.board")){
			System.out.println("--------update.board  in doPost BoardController---------");
		} else if(command.equals("/delete.board")) {
			System.out.println("------- delete.board  in doPost BoardController----------");
		}
	}

}
