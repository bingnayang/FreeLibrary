package in.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.library.entity.Rental;
import in.library.util.DBConnectionUtil;

public class RentalDAOImplement implements RentalDAO{
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	

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
	@Override
	public boolean updateStatus(int statusId,int bookId) {
		String sql = "UPDATE books SET books.status_Id = ? WHERE books.book_Id = ?";

		try {
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,statusId);
			preparedStatement.setInt(2,bookId);
			preparedStatement.executeUpdate();
			return true;

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;	
	}
	@Override
	public boolean addRentBook(Rental rent) {
		
		return false;
		
	}
	@Override
	public int getCustomerID(String name, String email) {
		// Create reference variables
		int customerID = 0;
		try {
			String sql = "SELECT customer_Id FROM customers WHERE customers.customerName = ? AND customers.email = ?";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,email);
			ResultSet resultSet = preparedStatement.executeQuery();
			customerID = resultSet.getInt("customer_Id");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			customerID = -1;
		}
		return customerID;
	}

}
