<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Free Library</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-primary">
		<a class="navbar-brand" href="#"> 
			<i class="fa fa-book" aria-hidden="true"></i>
			Free Library
		</a>
	</nav>
	<nav class="nav bg-light text-dark">
		<button type="button" class="btn btn-outline-primary" style="margin: 5px;">Add New Book</button> 
		<button type="button" class="btn btn-outline-primary" style="margin: 5px;">Search Books by Author</button> 
		<button type="button" class="btn btn-outline-primary" style="margin: 5px;">Search Books by Publisher</button> 
	</nav>
	<div class="container-fluid" style="margin-top: 2em;">
		<table class="table">
			<thead>
				<tr>
					<th>Book Name</th>
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