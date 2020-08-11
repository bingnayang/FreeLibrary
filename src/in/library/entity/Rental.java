package in.library.entity;

import java.time.LocalDate;

public class Rental {
	private int rent_Id;
	private int book_Id;
	private int customer_Id;
	private LocalDate outDate;
	private String returnDate;
	public int getRent_Id() {
		return rent_Id;
	}
	public void setRent_Id(int rent_Id) {
		this.rent_Id = rent_Id;
	}
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public LocalDate getOutDate() {
		return outDate;
	}
	public void setOutDate(LocalDate outDate) {
		this.outDate = outDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	
	
	
}
