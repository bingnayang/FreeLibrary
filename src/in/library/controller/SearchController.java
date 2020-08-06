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


public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	// Create a reference variable for bookInfo DAO
	BookInfoDAO bookInfoDAO = null;
	
	// Create constructor and initaize bookInfo DAO
	public SearchController() {
		bookInfoDAO = new BookInfoDAOImplement();
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookInfo> authorBookList = null;
		
		String getSearchInput = request.getParameter("getInput");
		String getSearchBy = request.getParameter("searchBy");
		
		System.out.println("==================================");
		System.out.println("Search By "+getSearchBy);
		System.out.println("Author Name: "+getSearchInput);
		
		switch(getSearchBy) {
		case "author":
			authorBookList = bookInfoDAO.searchByAuthor(getSearchInput);
			break;
		case "genre":
			authorBookList = bookInfoDAO.searchByGenre(getSearchInput);
			break;
		case "publisher":
			authorBookList = bookInfoDAO.searchByPublisher(getSearchInput);
			break;
		}
				
        for(BookInfo model : authorBookList) {
            System.out.println(model.getName());
        }
		System.out.println("==================================");
		
		// Add the book to request object
		request.setAttribute("bookList",authorBookList);
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/search.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}

}
