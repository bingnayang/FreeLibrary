package in.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			"SELECT genres.genre_Id FROM genres WHERE genres.genreName = ?";
	private static final String QUERY_PUBLISHER_ID = 
			"SELECT publishers.publisher_Id FROM publishers WHERE publishers.publisherName = ?";
	
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
			String sql = "INSERT INTO books (name,pageCount,author_Id,genres_Id,isbn_13,publisher_Id,publicationDate) VALUES ()";
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
	public int searchAuthorId(String name){
		int authorID = 0;
		try {
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(QUERY_AUTHOR_ID);
		preparedStatement.setString(1,"Suzanne Collins");
		ResultSet resultSet = preparedStatement.executeQuery();
		authorID = resultSet.getInt(1);
		System.out.println("Author Id: "+authorID);
		
		}catch (SQLException e) {
			// TODO: handle exception
			authorID = -1;
			System.out.println("Author Id: "+authorID);
		}
		return authorID;
	}

	@Override
	public int searchGenreId(String name){
		int genreID = 0;
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(QUERY_GENRE_ID);
			preparedStatement.setString(1,"Novel");
			ResultSet resultSet = preparedStatement.executeQuery();
			genreID = resultSet.getInt(1);
			System.out.println("Genre Id: "+genreID);

		}catch (Exception e) {
			// TODO: handle exception
			genreID = -1;
			System.out.println("Genre Id: "+genreID);
		}
		return genreID;
	}

	@Override
	public int searchPublisherId(String name){
		int publisherID = 0;
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(QUERY_PUBLISHER_ID);
			preparedStatement.setString(1,"Penguin Young Readers");
			ResultSet resultSet = preparedStatement.executeQuery();
			publisherID = resultSet.getInt(1);
			System.out.println("Publisher Id: "+publisherID);
		}catch (Exception e) {
			// TODO: handle exception
			publisherID = -1;
			System.out.println("Publisher Id: "+publisherID);
		}
		return publisherID;
	}

	@Override
	public boolean insertNewAuthor() {
		boolean flag = false;
		try {
			String sql = "INSERT INTO authors (name) VALUES ()";
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
	public boolean insertNewGenre() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewPublisher() {
		// TODO Auto-generated method stub
		return false;
	}



}
