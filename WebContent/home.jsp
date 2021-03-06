<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background: url("wallpaper.png");
	text-align: center;
	padding-top: 50px;
}

form {
	display: inline-block;
}
</style>
<body
	style="color: white; font-family: Times New Roman; font-size: 19px">

	<div align="left" style="width: 600px; color: white;">
		Your sucessfully logged in <a href="login.html">Logout</a>
	</div>
	<table>



		<tr>
			<td>
				<div align="center" style="width: 600px">



					<form method="post" action="AddCategoryServlet">

						<h2 style="color: white;">Add Category</h2>
						<table>
							<tr>
								<td style="color: white;">Name :</td>
								<td><input type="text" name="categoryName"></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Add</button>
								</td>
							</tr>
						</table>

					</form>




				</div>
			</td>
			<td>
				<div align="center" style="width: 600px">

					<form method="post" action="AddProductServlet">

						<h2 style="color: white;">Add Product</h2>
						<table>
							<tr>
								<td style="color: white;">Category :</td>
								<td><select name="category">
										<c:forEach var="category" items="${CATEGORY}">
											<option value="${category.id}">${category.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Product :</td>
								<td><input type="text" name="product"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Description :</td>
								<td><input type="text" name="description"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Quantity :</td>
								<td><input type="number" name="quantity"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Price :</td>
								<td><input type="number" name="price"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Expiration Date :</td>
								<td><input type="date" name="expiration_date"></td>
							</tr>
							<tr>
								<td style="color: white;">Status :</td>
								<td><input type="radio" name="status" value="available"
									checked>Available <input type="radio" name="status"
									value="not_available" checked>Not Available</td>
							</tr>
							<!-- <tr>
								<td style="color: white;">Author</td>
								<td><input type="number" name="authorId"></td>
							</tr> -->
							<!-- <select name="authorId">
							<c:forEach var="author" items="${AUTHORS}">
							<option value="${author.id}">${author.id}</option>
							</c:forEach>
							</select> -->
							<tr>
								<td></td>
							</tr>
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
		</tr>
	</table>
	<br>
	<br>
	<table align="center">
		<tr>
			<td>
				<form method="post" action="UpdateServlet">
					<button type="submit">Product Update/Delete</button>
				</form>
			</td>
			<td>
				<form method="post" action="UpdatePlaceOrderServlet">
					<button type="submit">Place Order</button>
				</form>
			</td>
		</tr>
	</table>


</body>
</html>