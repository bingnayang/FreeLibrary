package in.library.dao;

import java.util.List;
import in.library.entity.BookInfo;

public interface BookInfoDAO {
	List<BookInfo> get();
	boolean save(BookInfo bookInfo);
	boolean insertNewAuthor();
	boolean insertNewGenre();
	boolean insertNewPublisher();
	int searchAuthorId(String name);
	int searchGenreId(String name);
	int searchPublisherId(String name);
	
}
