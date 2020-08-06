<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Context-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Add New Book</title>
</head>
<body>
	<nav class="navbar mb-2" style="background-color: #1F3944;">
		<a class="navbar-brand text-light" href="#" > <i class="fa fa-book"
			aria-hidden="true"></i> Free Library
		</a>
	</nav>
	<div class="container bg-light" style="padding: 15px;">
		<h3 class="text-center">Add New Book To Database</h3>
		<form action="${pageContext.request.contextPath}/BookController" method="POST">
			<div class="form-group">
				<label for="bookName">Name</label> 
				<input type="text" class="form-control" name="bookName"> 
			</div>
			<div class="form-group">
				<label for="authorName">Author Name</label> 
				<input type="text" class="form-control" name="authorName">
			</div>
 			<div class="form-group">
				<label for="genreName">Genre</label> 
				<input type="text" class="form-control" name="genreName">
			</div>
			<div class="form-group">
				<label for="publisherName">Publisher Name</label> 
				<input type="text" class="form-control" name="publisherName">
			</div>
			<div class="form-group">
				<label for="publicationDate">Publication Date</label> 
				<input type="text" class="form-control" name="publicationDate" placeholder="mm/dd/yyyy">
			</div>
			<div class="form-group">
				<label for="pageCount">Page Count</label> 
				<input type="number" class="form-control" name="pageCount">
			</div>
			<div class="form-group">
				<label for="isbn_13">ISBN-13</label> 
				<input type="number" class="form-control" name="isbn_13">
			</div>
			
			<button type="submit" class="btn btn-block text-light" style="background-color: #1F3944;">Submit</button>
		</form>
	</div>
</body>
</html>