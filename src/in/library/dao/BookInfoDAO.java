package in.library.dao;

import java.util.List;
import in.library.entity.BookInfo;

public interface BookInfoDAO {
	List<BookInfo> get();
	boolean save(BookInfo bookInfo);
	int searchAuthorId(String name)throws Exception;
	int searchGenreId(String name)throws Exception;
	int searchPublisherId(String name)throws Exception;
}
