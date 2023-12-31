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
import com.dao.UploadFileDAO;
import com.dto.BoardDTOJoin;
import com.dto.UploadFileDTO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();

		Vector<BoardDTOJoin> vBoard = dao.selectAllBoard(9, 0);

		dao.closeJDBCCOnnection();

		System.out.println("============ vBoard size =" + vBoard.size() + "--------");
		request.setAttribute("boards", vBoard);
		
		UploadFileDAO imageDao = new UploadFileDAO();	
		Vector<UploadFileDTO> vImage = imageDao.selectAllFiles(3, 0);
		request.setAttribute("images", vImage);
		imageDao.closeJDBCCOnnection();
		
		String urlTo = "/home.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(urlTo);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
