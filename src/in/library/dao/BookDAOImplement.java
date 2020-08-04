package in.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.library.util.DBConnectionUtil;

public class BookDAOImplement implements BookDAO{
	
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
	public boolean save() {
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
			preparedStatement.setString(1,"Penguin Young Readers Group");
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
	public boolean insertNewAuthor(String name) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO authors (authorName) VALUES ('"+name+"')";
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
	public boolean insertNewGenre(String name) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO genres (genreName) VALUES ('"+name+"')";
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
	public boolean insertNewPublisher(String name) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO publishers (publisherName) VALUES ('"+name+"')";
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
