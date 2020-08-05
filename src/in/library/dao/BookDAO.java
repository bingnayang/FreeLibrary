package in.library.dao;

import in.library.entity.Books;

public interface BookDAO {
	boolean save(Books book);
	boolean insertNewAuthor(String name);
	boolean insertNewGenre(String name);
	boolean insertNewPublisher(String name);
	int searchAuthorId(String name);
	int searchGenreId(String name);
	int searchPublisherId(String name);
}
