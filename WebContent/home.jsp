<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Your sucessfully logged in
	<!-- <a href="addbook.html">Add Book Details</a>
	<a href="updatebook.html">Update Book</a>
	<a href="deletebook.html">Delete Book</a> -->
	<table>
		<tr>
			<td>
				<div align="center" style="background-color: Tomato; width: 600px">

					<form method="post" action="SaveServlet">

						<h1 style="color: white;">Add Book Details</h1>
						<table>
							<tr>
								<td style="color: white;">Name</td>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Price</td>
								<td><input type="number" name="price"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Published Date</td>
								<td><input type="date" name="publishedDate"></td>
							</tr>
							<tr>
								<td>Author</td>
								<td><input type="number" name="authorId"></td>
							</tr>
							<!-- <select name="authorId">
							<c:forEach var="author" items="${AUTHORS}">
							<option value="${author.id}">${author.id}</option>
							</c:forEach>
							</select> -->
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">ADD</button>
								</td>
							</tr>
						</table>

					</form>
				</div>
			</td>
			<td>
				<div align="center" style="background-color: Tomato; width: 600px">

					<form method="post" action="UpdateServlet">

						<h1 style="color: white;">Update Book</h1>
						<table>
							<tr>
								<td style="color: white;">Book Id</td>
								<td><input type="text" name="bookid"></td>
							</tr>
							<tr>
								<td style="color: white;">Name</td>
								<td><input type="text" name="name" required></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Price</td>
								<td><input type="number" name="price"></td>
							</tr>
							<tr>
								<td></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Update</button>
								</td>
							</tr>
						</table>

					</form>
				</div>
			</td>
		</tr>
		<tr align="center">
			<td>
				<div align="center" style="background-color: Tomato; width: 600px">

					<form method="post" action="DeleteServlet">

						<h1 style="color: white;">Delete Book</h1>
						<table>
							<tr>
								<td style="color: white;">Book Id</td>
								<td><input type="text" name="bookid"></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Delete</button>
								</td>
							</tr>
						</table>

					</form>
				</div>
			</td>
			<td>
				<div align="center" style="background-color: Tomato; width: 600px">

					<form method="post" action="SeaechByIdServlet">

						<h1 style="color: white;">Search by Book Id</h1>
						<table>
							<tr>
								<td style="color: white;">Book Id</td>
								<td><input type="text" name="bookid"></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Search</button>
								</td>
							</tr>
						</table>

					</form>
				</div>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<a href="login.html">Logout</a>

</body>
</html>