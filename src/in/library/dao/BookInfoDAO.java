package in.library.dao;

import java.util.List;
import in.library.entity.BookInfo;

public interface BookInfoDAO {
	List<BookInfo> get();
	
	boolean save(BookInfo bookInfo);
}
