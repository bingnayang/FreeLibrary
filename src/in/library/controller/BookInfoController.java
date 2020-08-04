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
		// Call DAO method to get list of booksInfo
		List<BookInfo> allBookList = bookInfoDAO.get();		
		// Add the book to request object
		request.setAttribute("allBookList",allBookList);
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/book-list.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String book_Name = request.getParameter("bookName");
//		String author_Name = request.getParameter("authorName");
//		String genre_Name = request.getParameter("genreName");
//		String publisher_Name = request.getParameter("publisherName");
//		String publication_Date = request.getParameter("publicationDate");
//		int pageCount = Integer.parseInt(request.getParameter("pageCount"));
//		long isbn_13 = Long.parseLong(request.getParameter("isbn_13"));
//
//		int authorID = bookInfoDAO.searchAuthorId("author_Name");
//		int genreID = bookInfoDAO.searchGenreId("genre_Name");
//		int publisherID = bookInfoDAO.searchPublisherId("publication_Name");
//			
//		if(authorID == -1) {
//			bookInfoDAO.insertNewAuthor(author_Name);
//		}
//		if(genreID == -1) {
//			bookInfoDAO.insertNewGenre(genre_Name);
//		}
//		if(publisherID == -1) {
//			bookInfoDAO.insertNewPublisher(publisher_Name);
//		}		
//		// test
//		System.out.println("Book name: " + book_Name);
//		System.out.println("Author name: " + author_Name);
//		System.out.println("Genre: " + genre_Name);
//		System.out.println("Publisher: " + publisher_Name + " | Publication Date: " + publication_Date);
//		System.out.println("Page Count: " + pageCount);
//		System.out.println("ISBN-13: " + isbn_13);
//		System.out.println("=======================================");
//	}

}
