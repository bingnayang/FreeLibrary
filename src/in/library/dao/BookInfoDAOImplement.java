package in.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.library.entity.BookInfo;
import in.library.util.DBConnectionUtil;

public class BookInfoDAOImplement implements BookInfoDAO {
	// Create SQL query
	private static final String QUERY_ALL_BOOK = 
			"SELECT * FROM books_info";
	
	private static final String QUERY_BOOK_BY_AUTHOR = 
			"SELECT * FROM books_info WHERE authorName = ?";
	private static final String QUERY_BOOK_BY_GENRE = 
			"SELECT * FROM books_info WHERE books_info.genreName = ?";
	private static final String QUERY_BOOK_BY_PUBLISHER = 
			"SELECT * FROM books_info WHERE books_info.publisherName = ?";

	
	private static final String QUERY_AUTHOR_ID = "";
	private static final String QUERY_GENRE_ID = "";
	private static final String QUERY_PUBLISHER_ID = "";
	
	private static final String INSERT_AUTHOR = "";
	private static final String INSERT_GENRE = "";
	private static final String INSERT_PUBLISHER = "";
	
	
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
	public boolean save(BookInfo bookInfo) {
		boolean flag = false;
		try {
			String sql = "";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

}
