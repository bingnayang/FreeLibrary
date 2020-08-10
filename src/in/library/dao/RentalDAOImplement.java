package in.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.library.entity.BookInfo;
import in.library.util.DBConnectionUtil;

public class RentalDAOImplement implements RentalDAO{
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	public BookInfo searchById(int Id) {
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
	@Override
	public boolean searchCustomer(String name, String email) {
		// Create reference variables

		try {
			String sql = "SELECT * FROM customers WHERE customers.customerName = '"+name+"' AND customers.email = '"+email+"'";
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the query
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL: "+sql);
			// Process the resultSet
			if(resultSet.next()) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;	
	}
	@Override
	public boolean addCustomer(String name, String email) {
		String sql = "INSERT INTO customers (customerName,email) VALUES(?,?)";

		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,email);
			preparedStatement.executeUpdate();
			return true;

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;	
	}

}
