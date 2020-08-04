package in.library.dao;


public interface BookDAO {
	boolean save();
	boolean insertNewAuthor(String name);
	boolean insertNewGenre(String name);
	boolean insertNewPublisher(String name);
	int searchAuthorId(String name);
	int searchGenreId(String name);
	int searchPublisherId(String name);
}
