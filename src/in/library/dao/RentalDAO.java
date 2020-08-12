package in.library.dao;

import in.library.entity.Rental;

public interface RentalDAO {
	boolean searchCustomer(String name, String email);
	boolean addCustomer(String name, String email);
	boolean updateStatus(int statusId,int bookId);
	boolean addRentBook(Rental rent);
	int getCustomerID(String name, String email);
	boolean rentalUpdate(Rental rent);
	int getBookID(Rental rent);
}
