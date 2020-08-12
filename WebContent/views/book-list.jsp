<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Free Library</title>
</head>
<body class="bg-light">
	<nav class="navbar mb-2" style="background-color: #1F3944;">
		<a class="navbar-brand text-light" href="#"> <i class="fa fa-book"
			aria-hidden="true"></i> Free Library
		</a>
	</nav>
	<!-- Display all function buttons-->
	<div class="card text-center container-fluid mb-2">
		<div class="card-header text-light" style="background-color: #1F3944;">
			<h4>Welcome to Free Library</h4>
		</div>
		<div class="card-body">
			<h5 class="card-title"></h5>
			<h5 class="card-text">Total Book in library database: ${totalBook}</h5>
			<h5 class="card-text">Total Book out for rent: ${totalRentBook}</h5>
			<a href="#" class="btn btn-outline-info"
				onclick="window.location.href='views/book-add.jsp'">Add New Book</a>
			<a href="#" class="btn btn-outline-info"
				onclick="window.location.href='views/search.jsp'">Search Book</a>
		</div>
	</div>
	<!-- Display all book in database-->
	
	<div class="container-fluid">
		<h4 class="text-center text-light" style="background-color: #1F3944; padding: 5px;">All Book in Library Database</h4>
		<!-- 	Table that display all book in database-->
		<div class="table-responsive">
			<table class="table table-striped">
				<thead class="text-light" style="background-color: #1F3944;">
					<tr>
						<th>Book Name</th>
						<th>Author Name</th>
						<th>Genre</th>
						<th>Publisher</th>
						<th>Publication Date</th>
						<th>Page Count</th>
						<th>ISBN-13</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach items="${allBookList}" var="book">
					<tr>
						<td>${book.name}</td>
						<td>${book.authorName}</td>
						<td>${book.genreName}</td>
						<td>${book.publisherName}</td>
						<td>${book.publicationDate}</td>
						<td>${book.pageCount}</td>
						<td>${book.isbn_13}</td>
						<td>${book.statusName}</td>
						<td>
							<c:set var="inputDisplay" value="${book.statusName}" />
							<c:choose>
							    <c:when test="${book.statusName == 'In-Library'}">
							    	<button type="button" class="btn btn-outline-info btn-sm" 
									onclick="window.location.href='${pageContext.request.contextPath}/BookInfoController?action=RENT&id=${book.book_ID}'">Rent</button>
							    </c:when>
							    <c:otherwise>
							        <button type="button" class="btn btn-outline-danger btn-sm"
									onclick="window.location.href='${pageContext.request.contextPath}/BookInfoController?action=RENT&id=${book.book_ID}'" 
									disabled="disabled">Out</button>
							    </c:otherwise>      
							</c:choose>							
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- Display all book are currently rent out -->
	<div class="container-fluid">
		<h4 class="text-center text-light" style="background-color: #1F3944; padding: 5px;">Book Out for Rent</h4>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead class="text-light" style="background-color: #1F3944;">
					<tr>
						<th>Book Name</th>
						<th>Author Name</th>
						<th>Date Rent Start</th>
						<th>Customer Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach items="${allRentOutBookList}" var="rent">
					<tr>
						<td>${rent.bookName}</td>
						<td>${rent.authorName}</td>
						<td>${rent.outDate}</td>	
						<td>${rent.customerName}</td>		
						<td>
						<form action="${pageContext.request.contextPath}/RentalController?action=Return" method="POST">
							<input type="hidden" class="form-control" name="rent_Id" value="${rent.rent_Id}">
							<button type="submit" class="btn btn-outline-info btn-sm">Book Return</button>
						</form>
						</td>									
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>