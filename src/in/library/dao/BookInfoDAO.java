package in.library.dao;

import java.util.List;
import in.library.entity.BookInfo;
import in.library.entity.RentalInfo;


public interface BookInfoDAO {
	List<BookInfo> get();
	List<RentalInfo> getRentOutList();
	List<BookInfo> searchByAuthor(String name);
	List<BookInfo> searchByGenre(String name);
	List<BookInfo> searchByPublisher(String name);
	List<BookInfo> searchById(int Id);
	int getTotalBook();
	int getTotalRentOutBook();
}
