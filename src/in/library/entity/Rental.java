package in.library.entity;

public class Rental {
	private int rent_Id;
	private String book_Id;
	private String customer_Id;
	private String outDate;
	private String returnDate;
	public int getRent_Id() {
		return rent_Id;
	}
	public void setRent_Id(int rent_Id) {
		this.rent_Id = rent_Id;
	}
	public String getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(String book_Id) {
		this.book_Id = book_Id;
	}
	public String getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
