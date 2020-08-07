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
<body>
	<nav class="navbar mb-2" style="background-color: #1F3944;">
		<a class="navbar-brand text-light" href="#"> <i class="fa fa-book"
			aria-hidden="true"></i> Free Library
		</a>
		<div class="form-inline">
			<button class="btn btn-outline-light mr-sm-2" onclick="goBack();">Back To Book List</button>
		</div>
	</nav>
 	<div class="container">
		<form action="${pageContext.request.contextPath}/SearchController"
			method="GET" class="row">
			<div class="form-group col-3">
				<select class="form-control" id="searchBy" name="searchBy">
					<option value="author">Search by Author</option>
					<option value="publisher">Search by Publisher</option>
					<option value="genre">Search by Genre</option>
				</select>
			</div>
			<div class="form-group col-6">
				<input type="text" id="myInput" class="form-control" name="getInput">
			</div>
			<div class="form-group col">
				<button type="submit" class="btn btn-primary btn-block">Submit</button>
			</div>
		</form>
	</div>

	<!-- Card for display all book -->
	<div class="card container-fluid">
		<div class="card-body">
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
							<th>Action</th>
						</tr>
					</thead>
					<c:forEach items="${bookList}" var="book">
						<tr>
							<td>${book.name}</td>
							<td>${book.authorName}</td>
							<td>${book.genreName}</td>
							<td>${book.publisherName}</td>
							<td>${book.publicationDate}</td>
							<td>${book.pageCount}</td>
							<td>${book.isbn_13}</td>
							<td><a type="button" class="btn btn-outline-info btn-sm"
								href="${pageContext.request.contextPath}/SearchController?action=EDIT&id=${book.book_ID}">Edit</a>
								/ <a type="button" class="btn btn-outline-danger btn-sm"
								href="${pageContext.request.contextPath}/SearchController?action=DELETE&id=${book.book_ID}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
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
<script type="text/javascript">
	function goBack() {
		location.href = "${pageContext.request.contextPath}/BookInfoController?action=LIST";
	}
</script>
</html>