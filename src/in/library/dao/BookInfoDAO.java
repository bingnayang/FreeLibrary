package in.library.dao;

import java.util.List;
import in.library.entity.BookInfo;


public interface BookInfoDAO {
	List<BookInfo> get();
	List<BookInfo> searchByAuthor(String name);
}
