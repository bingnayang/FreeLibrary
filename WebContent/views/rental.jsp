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
		<div class="form-inline">
			<button class="btn btn-outline-light mr-sm-2" onclick="goBack();">Back
				To Book List</button>
		</div>
	</nav>
	
	<div class="container" style="margin-bottom: 10px;">
		<div class="card">
			<h5 class="card-header">Rental Book Information</h5>
			<div class="card-body">	
				<h5 class="card-title">${bookInfo.name}</h5>
				<p class="card-text">Author: ${bookInfo.authorName}</p>			
				<p class="card-text">Genre: ${bookInfo.genreName}</p>	
				<p class="card-text">Publisher: ${bookInfo.publisherName}</p>	
				<p class="card-text">ISBN-13: ${bookInfo.isbn_13}</p>
			</div>
		</div>	
	</div>

	<div class="container">
		<div class="card">
			<h5 class="card-header">Customer Contact Information</h5>
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/RentalController" method="POST">
					<div class="form-group">
						<label for="customerName">Name</label> 
						<input type="text" class="form-control" id="customerName" name="customerName" required="required">
					</div>
					<div class="form-group">
						<label for="customerEmail">Email</label> 
						<input type="email" class="form-control" id="customerEmail" name="customerEmail" required="required">
					</div>
					<div class="form-group">
					<input type="hidden" class="form-control" name="book_Id" value="${bookInfo.book_ID}">
					</div>
					<button type="submit" class="btn btn-primary btn-block">Rent the Book</button>
				</form>	
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function goBack() {
		location.href = "${pageContext.request.contextPath}/BookInfoController?action=LIST";
	}
</script>
</html>