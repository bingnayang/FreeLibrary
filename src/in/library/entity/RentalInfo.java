package in.library.entity;

public class RentalInfo {
	private int rent_Id;
	private String bookName;
	private String authorName;
	private String customerName;
	private String outDate;
	private String returnDate;
	public int getRent_Id() {
		return rent_Id;
	}
	public void setRent_Id(int rent_Id) {
		this.rent_Id = rent_Id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
