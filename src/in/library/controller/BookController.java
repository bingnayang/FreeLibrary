package in.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.library.dao.BookInfoDAO;
import in.library.dao.BookInfoDAOImplement;
import in.library.entity.BookInfo;


public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Create a reference variable for bookInfo DAO
	BookInfoDAO bookInfoDAO = null;
	// Create constructor and initaize bookInfo DAO
	public BookController() {
		bookInfoDAO = new BookInfoDAOImplement();
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Call DAO method to get list of booksInfo
		List<BookInfo> list = bookInfoDAO.get();		
		// Add the book to request object
		request.setAttribute("list",list);
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
