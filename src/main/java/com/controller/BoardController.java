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
			System.out.println("------list.board  in doGet BoardController------");	
			BoardDAO dao = new BoardDAO();
			Vector<BoardDTO> vBoard = dao.selectAllBoard();
			System.out.println("============ vBoard size =" + vBoard.size() + "--------");
			request.setAttribute("boards", vBoard);
			String urlTo = "/board/list_board.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
			dispatcher.forward(request, response);
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
		//System.out.println("------------- command in DispMember Servlet : " + command + "--------------");

		if(command.equals("/read.board")){
			System.out.println("--------create.board  in doPost BoardController---------");
		} else if(command.equals("/create.board")){
			System.out.println("--------create.board  in doPost BoardController---------");
			request.setCharacterEncoding("UTF-8");
			String content = request.getParameter("content");
			String user_id = (String) request.getSession().getAttribute("mp_user_id");
			BoardDAO dao = new BoardDAO();
			int line = dao.createBoard(user_id, content);
			dao=new BoardDAO();
			Vector<BoardDTO> vBoard = dao.selectAllBoard();
			System.out.println("============ vBoard size =" + vBoard.size() + "--------");
			request.setAttribute("boards", vBoard);
			request.setAttribute("created_line", line);	
			request.setAttribute("boards", vBoard);
			String urlTo = "/board/list_board.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
			dispatcher.forward(request, response);
		} else if(command.equals("/update.board")){
			System.out.println("--------update.board  in doPost BoardController---------");
		} else if(command.equals("/delete.board")) {
			System.out.println("------- delete.board  in doPost BoardController----------");
		}
	}

}
