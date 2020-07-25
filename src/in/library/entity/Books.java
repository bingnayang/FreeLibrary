package in.library.entity;

public class Books {
	// Define the fields
	private int book_ID;
	private String name;
	private int pageCount;
	private int author_Id;
	private int genres_Id;
	private long isbn_13;
	private int publisher_Id;
	private String publicationDate;
	
	// Setters and Getters
	public int getBook_ID() {
		return book_ID;
	}
	public void setBook_ID(int book_ID) {
		this.book_ID = book_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getAuthor_Id() {
		return author_Id;
	}
	public void setAuthor_Id(int author_Id) {
		this.author_Id = author_Id;
	}
	public int getGenres_Id() {
		return genres_Id;
	}
	public void setGenres_Id(int genres_Id) {
		this.genres_Id = genres_Id;
	}
	public long getIsbn_13() {
		return isbn_13;
	}
	public void setIsbn_13(long isbn_13) {
		this.isbn_13 = isbn_13;
	}
	public int getPublisher_Id() {
		return publisher_Id;
	}
	public void setPublisher_Id(int publisher_Id) {
		this.publisher_Id = publisher_Id;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	
}
