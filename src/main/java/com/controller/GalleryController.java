package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.dao.UploadFileDAO;
import com.dto.UploadFileDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class GalleryController
 */
@WebServlet("*.gallery")
public class GalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public boolean checkSession(HttpServletRequest request) {
		javax.servlet.http.HttpSession session = request.getSession();
		if (session.getAttribute("mp_user_id") == null) {
			System.out.println("--checkSession@BoardControiller--session  = false - ----");
			return false;
		}

		return true;
	}

	public void dispatchTo(String urlTo, HttpServletRequest request, HttpServletResponse response) {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		// System.out.println("------------- command in DispMember Servlet : " + command
		// + "--------------");

		if (command.equals("/read.gallery")) {
			// session check
			if (checkSession(request)) {
				System.out.println("session login state");
				System.out.println("------read.gallery  in doGet GalleryController------");

				String strMax = request.getParameter("max");
				String strOff = request.getParameter("off");
				int nMax, nOff;
				if (strMax == null) {
					nMax = -1;
				} else {
					nMax = Integer.parseInt(strMax);
				}
				if (strOff == null) {
					nOff = -1;
				} else {
					nOff = Integer.parseInt(strOff);
				}

				// Gallery dap
				UploadFileDAO dao = new UploadFileDAO();

				Vector<UploadFileDTO> vBoard = dao.selectAllFiles(nMax, nOff);
				dao.closeJDBCCOnnection();

				System.out.println("============ vBoard size =" + vBoard.size() + "--------");
				request.setAttribute("boards", vBoard);
				dispatchTo("/upload/gallery.jsp", request, response);
			} else {
				System.out.println("session logout");
				dispatchTo("/index.jsp", request, response);
			}

		} else if (command.equals("/create.gallery")) {
			System.out.println("--------create.gallery  in doGet GalleryController---------");
		} else if (command.equals("/update.gallery")) {
			System.out.println("--------update.gallery  in doGet GalleryController---------");
		} else if (command.equals("/delete.gallery")) {
			System.out.println("-------delete.gallery  in doGet GalleryController----------");		
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		// System.out.println("------------- command in DispMember Servlet : " + command
		// + "--------------");

		if (command.equals("/read.gallery")) {
			System.out.println("--------read.gallery in  doPost GalleryController---------");			
		} else if (command.equals("/create.gallery")) {
			System.out.println("--------create.gallery  in doPost GalleryController---------");
			
			if (checkSession(request)) {
				
				String upPath = "C:\\ldw\\JSP_WORKSPACE\\MyProject\\src\\main\\webapp\\UploadedFiles";
				//String upPath = "C:\\ldw\\upload";
				int maxSize = 1024 * 1024 * 10; //10Mb
				
				//upload 해보기
				try{
					MultipartRequest multi = new MultipartRequest(
							request, upPath, maxSize, "utf-8", new DefaultFileRenamePolicy());	
					
					Enumeration<?> inputFileElements = multi.getFileNames(); // <input type="file">인 모든 파라메타를 반환	
							
					// input type=file의 갯수에따라
					while( inputFileElements.hasMoreElements() ){
						String element = (String) inputFileElements.nextElement(); // <input type="file" name="aaa"> 에서 aaa의 내용
						System.out.println("--upload file --" + element + "<BR>");
						
						// 짐작할 만 한 내용
						String filesystemName = multi.getFilesystemName(element);  //서버에 업로드된 파일 이름
						String originalFileName = multi.getOriginalFileName(element); 
						String contentType = multi.getContentType(element);
						File file = multi.getFile(element);  // upload 된 file이 return 됨
						String filePath = file.getPath();
						
						long length = file.length(); 
						
						System.out.println( "------file uplad " + filesystemName + ", " + originalFileName +  ", " +  contentType +  ", " 
							 + filePath + ", " + length);
						
						
						// upload 되면 db에 올리기
						request.setCharacterEncoding("UTF-8");
						String user_id = (String) request.getSession().getAttribute("mp_user_id");
						UploadFileDAO dao = new UploadFileDAO();
						int createdLine = dao.createFileBoard(originalFileName, filesystemName, user_id, length );
						if(createdLine==1) {
							request.setAttribute("result", "1개의 파일이 upload 되었습니다");
						}else {
							request.setAttribute("result", "Error ... .");
						}
						
						dao.closeJDBCCOnnection();
					}
					
				}
				catch(IOException e){
					e.printStackTrace();
					System.out.println("---------upload file  -저장과정에서 오류가 발생하였어요");
				}
				
				// 디스패치
				dispatchTo("sendToGalleryWithResult.jsp", request, response);
			} else {
				System.out.println("session logout");
				dispatchTo("index.jsp", request, response);
			}

			
		} else if (command.equals("/update.gallery")) {
			System.out.println("--------update.gallery  in doPost GalleryController---------");
		} else if (command.equals("/delete.gallery")) {
			System.out.println("-------delete.gallery  in doPost GalleryController----------");		
		}	
	}

}
