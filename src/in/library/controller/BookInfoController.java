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

public class BookInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Create a reference variable for bookInfo DAO
	BookInfoDAO bookInfoDAO = null;
	
	// Create constructor and initaize bookInfo DAO
	public BookInfoController() {
		bookInfoDAO = new BookInfoDAOImplement();
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = bookInfoDAO.getTotalBook();
		request.setAttribute("totalBook",total);
		
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		switch(action) {
		case "LIST":
			listAllBook(request,response);
			break;
		}
        
	}
	public void listAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// Call DAO method to get list of booksInfo
		List<BookInfo> allBookList = bookInfoDAO.get();		
		// Add the book to request object
		request.setAttribute("allBookList",allBookList);
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}

}
