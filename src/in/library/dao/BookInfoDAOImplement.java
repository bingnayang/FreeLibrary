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
	private static final String QUERY_AUTHOR_ID = 
			"SELECT authors.author_Id FROM authors WHERE authors.authorName = ?";
	private static final String QUERY_GENRE_ID = 
			"SELECT genres.genres_Id FROM genres WHERE genres.genreName = ?";
	private static final String QUERY_PUBLISHER_ID = 
			"SELECT publishers.publishers_Id FROM publishers WHERE publishers.publishersName = ?";
	
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

	@Override
	public int searchAuthorId(String name) throws Exception{

		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(QUERY_AUTHOR_ID);
		preparedStatement.setString(1,"Sam");
		ResultSet resultSet = preparedStatement.executeQuery();
		int authorID = resultSet.getInt(1);
		System.out.println("Author Id: "+authorID);
		return authorID;
	}

	@Override
	public int searchGenreId(String name) throws Exception{
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(QUERY_GENRE_ID);
		preparedStatement.setString(1,"Novel");
		ResultSet resultSet = preparedStatement.executeQuery();
		int genreID = resultSet.getInt(1);
		System.out.println("Genre Id: "+genreID);
		return genreID;
	}

	@Override
	public int searchPublisherId(String name) throws Exception{
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(QUERY_PUBLISHER_ID);
		preparedStatement.setString(1,"Novel");
		ResultSet resultSet = preparedStatement.executeQuery();
		int publisherID = resultSet.getInt(1);
		System.out.println("Publisher Id: "+publisherID);
		return publisherID;
	}







}
