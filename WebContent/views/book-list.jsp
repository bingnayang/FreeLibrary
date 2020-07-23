<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Free Library</title>
</head>
<body>
	<div class="container-fluid">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Author Name</th>
					<th>Genre</th>
					<th>Publisher</th>
					<th>Publication Date</th>
					<th>Page Count</th>
					<th>ISBN-13</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.authorName}</td>
					<td>${book.genreName}</td>
					<td>${book.publisherName}</td>
					<td>${book.publicationDate}</td>
					<td>${book.pageCount}</td>
					<td>${book.isbn_13}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>