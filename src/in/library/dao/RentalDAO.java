package in.library.dao;

import in.library.entity.BookInfo;

public interface RentalDAO {
	BookInfo searchById(int Id);
	boolean searchCustomer(String name, String email);
	boolean addCustomer(String name, String email);
	
}
