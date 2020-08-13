package in.library.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.library.dao.RentalDAO;
import in.library.dao.RentalDAOImplement;
import in.library.entity.Rental;


public class RentalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RentalDAO rentalInfoDAO = null;   
	
    public RentalController() {
    	rentalInfoDAO = new RentalDAOImplement();
    }


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String action = req.getParameter("action");

		switch(action) {
			case "Rent":
				rentBook(req,resp);
				break;
			case "Return":
				returnBook(req,resp);
				break;
		}
		
	}
	public void returnBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate todayDate = LocalDate.now();
		String rentalID = req.getParameter("rent_Id");
		System.out.println("Rental Id: "+rentalID);
		
		Rental rent = new Rental();
		rent.setRent_Id(Integer.parseInt(rentalID));
		rent.setReturnDate(todayDate);
		
		boolean bookReturn = rentalInfoDAO.rentalUpdate(rent);
		if(bookReturn) {
			int bookID = rentalInfoDAO.getBookID(rent);
			rentalInfoDAO.updateStatus(1,bookID);
		}
		
		resp.sendRedirect("BookInfoController");
	}
	public void rentBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customerName = req.getParameter("customerName");
		String customerEmail = req.getParameter("customerEmail");
		int bookID = Integer.parseInt(req.getParameter("book_Id"));
		LocalDate todayDate = LocalDate.now();
		// Testing
		System.out.println("==============================");
		System.out.println("Name: "+customerName);
		System.out.println("Email: "+customerEmail);
		System.out.println("Book Id: "+bookID);
		System.out.println("Today Date: "+todayDate);
		
		boolean customerCheck = rentalInfoDAO.searchCustomer(customerName,customerEmail);
		System.out.println("Customer In File: "+customerCheck);
		if(customerCheck == false) {
			System.out.println("Add new customer to file");
			rentalInfoDAO.addCustomer(customerName, customerEmail);
		}
		int customerID = rentalInfoDAO.getCustomerID(customerName,customerEmail);
		System.out.println("Search for customer Id");
		System.out.println("Customer Id: "+customerID);

		Rental rent = new Rental();
		rent.setBook_Id(bookID);
		rent.setCustomer_Id(customerID);
		rent.setOutDate(todayDate);
		
		if(rentalInfoDAO.addRentBook(rent)) {
			rentalInfoDAO.updateStatus(2,bookID);
		}else {
			System.out.println("Rent Book fail");
		}
		System.out.println("==============================");
		
		resp.sendRedirect("BookInfoController");
	}
}
