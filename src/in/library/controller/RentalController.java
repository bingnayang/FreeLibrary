package in.library.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.library.dao.RentalDAO;
import in.library.dao.RentalDAOImplement;


public class RentalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RentalDAO rentalInfoDAO = null;   
	
    public RentalController() {
    	rentalInfoDAO = new RentalDAOImplement();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customerName = req.getParameter("customerName");
		String customerEmail = req.getParameter("customerEmail");
		int bookID = Integer.parseInt(req.getParameter("book_Id"));
		LocalDate todayDate = LocalDate.now();
		// Testing
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
		
		resp.sendRedirect("BookInfoController");
	}

	
}