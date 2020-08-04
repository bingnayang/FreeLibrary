package in.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.library.dao.BookDAO;
import in.library.dao.BookDAOImplement;


public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	BookDAO bookDAO = null;

	// Create constructor and initaize book DAO
	public BookController() {
		bookDAO = new BookDAOImplement();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_Name = request.getParameter("bookName");
		String author_Name = request.getParameter("authorName");
		String genre_Name = request.getParameter("genreName");
		String publisher_Name = request.getParameter("publisherName");
		String publication_Date = request.getParameter("publicationDate");
		int pageCount = Integer.parseInt(request.getParameter("pageCount"));
		long isbn_13 = Long.parseLong(request.getParameter("isbn_13"));

		int authorID = bookDAO.searchAuthorId("author_Name");
		int genreID = bookDAO.searchGenreId("genre_Name");
		int publisherID = bookDAO.searchPublisherId("publication_Name");

//		if (authorID == -1) {
//			bookDAO.insertNewAuthor(author_Name);
//		}
//		if (genreID == -1) {
//			bookDAO.insertNewGenre(genre_Name);
//		}
//		if (publisherID == -1) {
//			bookDAO.insertNewPublisher(publisher_Name);
//		}
		// test
		System.out.println("Book name: " + book_Name);
		System.out.println("Author name: " + author_Name);
		System.out.println("Genre: " + genre_Name);
		System.out.println("Publisher: " + publisher_Name + " | Publication Date: " + publication_Date);
		System.out.println("Page Count: " + pageCount);
		System.out.println("ISBN-13: " + isbn_13);
		System.out.println("=======================================");
		
		response.sendRedirect("BookInfoController");
	}

}
