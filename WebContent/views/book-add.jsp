<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<title>Add New Book</title>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/BookInfoController" method="POST">
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
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>