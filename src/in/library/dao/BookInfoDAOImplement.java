package in.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.library.entity.BookInfo;
import in.library.entity.RentalInfo;
import in.library.util.DBConnectionUtil;

public class BookInfoDAOImplement implements BookInfoDAO {
	// Create SQL query
	private static final String QUERY_ALL_BOOK = 
			"SELECT * FROM books_info";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<BookInfo> get() {
		// Create reference variables
		List<BookInfo> list = null;
		BookInfo bookInfo = null;
		
		try {
			list = new ArrayList<BookInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(QUERY_ALL_BOOK);
			// Process the resultSet
			while(resultSet.next()) {
				bookInfo = new BookInfo();
				bookInfo.setBook_ID(resultSet.getInt("book_Id"));
				bookInfo.setName(resultSet.getString("name"));
				bookInfo.setGenreName(resultSet.getString("genreName"));
				bookInfo.setAuthorName(resultSet.getString("authorName"));
				bookInfo.setPublisherName(resultSet.getString("publisherName"));
				bookInfo.setPublicationDate(resultSet.getString("publicationDate"));
				bookInfo.setPageCount(resultSet.getInt("pageCount"));
				bookInfo.setIsbn_13(resultSet.getLong("isbn_13"));
				bookInfo.setStatusName(resultSet.getString("statusName"));
				// Add book to list
				list.add(bookInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookInfo> searchByAuthor(String name) {
		// Create reference variables
		List<BookInfo> list = null;
		BookInfo bookInfo = null;
		try {
			String sql = "SELECT * FROM books_info WHERE books_info.authorName = '"+name+"'";
			list = new ArrayList<BookInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			// Process the resultSet
			while(resultSet.next()) {
				bookInfo = new BookInfo();
				bookInfo.setBook_ID(resultSet.getInt("book_Id"));
				bookInfo.setName(resultSet.getString("name"));
				bookInfo.setGenreName(resultSet.getString("genreName"));
				bookInfo.setAuthorName(resultSet.getString("authorName"));
				bookInfo.setPublisherName(resultSet.getString("publisherName"));
				bookInfo.setPublicationDate(resultSet.getString("publicationDate"));
				bookInfo.setPageCount(resultSet.getInt("pageCount"));
				bookInfo.setIsbn_13(resultSet.getLong("isbn_13"));
				// Add book to list
				list.add(bookInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookInfo> searchByGenre(String name) {
		// Create reference variables
		List<BookInfo> list = null;
		BookInfo bookInfo = null;
		try {
			String sql = "SELECT * FROM books_info WHERE books_info.genreName = '"+name+"'";
			list = new ArrayList<BookInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			// Process the resultSet
			while(resultSet.next()) {
				bookInfo = new BookInfo();
				bookInfo.setBook_ID(resultSet.getInt("book_Id"));
				bookInfo.setName(resultSet.getString("name"));
				bookInfo.setGenreName(resultSet.getString("genreName"));
				bookInfo.setAuthorName(resultSet.getString("authorName"));
				bookInfo.setPublisherName(resultSet.getString("publisherName"));
				bookInfo.setPublicationDate(resultSet.getString("publicationDate"));
				bookInfo.setPageCount(resultSet.getInt("pageCount"));
				bookInfo.setIsbn_13(resultSet.getLong("isbn_13"));
				// Add book to list
				list.add(bookInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookInfo> searchByPublisher(String name) {
		// Create reference variables
		List<BookInfo> list = null;
		BookInfo bookInfo = null;
		try {
			String sql = "SELECT * FROM books_info WHERE books_info.publisherName = '"+name+"'";
			list = new ArrayList<BookInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			// Process the resultSet
			while(resultSet.next()) {
				bookInfo = new BookInfo();
				bookInfo.setBook_ID(resultSet.getInt("book_Id"));
				bookInfo.setName(resultSet.getString("name"));
				bookInfo.setGenreName(resultSet.getString("genreName"));
				bookInfo.setAuthorName(resultSet.getString("authorName"));
				bookInfo.setPublisherName(resultSet.getString("publisherName"));
				bookInfo.setPublicationDate(resultSet.getString("publicationDate"));
				bookInfo.setPageCount(resultSet.getInt("pageCount"));
				bookInfo.setIsbn_13(resultSet.getLong("isbn_13"));
				// Add book to list
				list.add(bookInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalBook() {
		int total  = 0;
		String sql = "SELECT COUNT(books_info.name) FROM books_info";
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			total = resultSet.getInt(1);
//			System.out.println("SQL: "+sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public List<RentalInfo> getRentOutList() {
		// Create reference variables
		List<RentalInfo> list = null;
		RentalInfo rentInfo = null;
		String sql = "SELECT * FROM rentals_info WHERE returnDate IS NULL";
		try {
			list = new ArrayList<RentalInfo>();
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			// Process the resultSet
			while(resultSet.next()) {
				rentInfo = new RentalInfo();
				rentInfo.setRent_Id(resultSet.getInt("rental_Id"));
				rentInfo.setBookName(resultSet.getString("name"));
				rentInfo.setAuthorName(resultSet.getString("authorName"));
				rentInfo.setCustomerName(resultSet.getString("customerName"));
				rentInfo.setOutDate(resultSet.getString("rentOutDate"));
				rentInfo.setReturnDate(resultSet.getString("returnDate"));
				// Add book to list
				list.add(rentInfo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalRentOutBook() {
		int total  = 0;
		String sql = "SELECT COUNT(rentals_info.name) FROM rentals_info WHERE returnDate IS NULL";
		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			total = resultSet.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public BookInfo searchBookById(int Id) {
		// Create reference variables
		BookInfo bookInfo = null;
		try {
			String sql = "SELECT * FROM books_info WHERE books_info.book_Id = "+Id;
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			// Process the resultSet
			while(resultSet.next()) {
				bookInfo = new BookInfo();
				bookInfo.setBook_ID(resultSet.getInt("book_Id"));
				bookInfo.setName(resultSet.getString("name"));
				bookInfo.setGenreName(resultSet.getString("genreName"));
				bookInfo.setAuthorName(resultSet.getString("authorName"));
				bookInfo.setPublisherName(resultSet.getString("publisherName"));
				bookInfo.setPublicationDate(resultSet.getString("publicationDate"));
				bookInfo.setPageCount(resultSet.getInt("pageCount"));
				bookInfo.setIsbn_13(resultSet.getLong("isbn_13"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bookInfo;		
	}

}

