package in.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.library.entity.BookInfo;
import in.library.util.DBConnectionUtil;

public class BookInfoDAOImplement implements BookInfoDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	@Override
	public List<BookInfo> get() {
		// Create reference variables
		List<BookInfo> list = null;
		BookInfo bookInfo = null;
		
		try {
			list = new ArrayList<BookInfo>();
			// Create a SQL query
			String sql = "SELECT * FROM books_info";
			// Get the database connection
			connection = DBConnectionUtil.openConnection();
			// Create a statement
			statement = connection.createStatement();
			// Execute the sql query
			resultSet = statement.executeQuery(sql);
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

}
