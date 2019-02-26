<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>
	<div align="center">
		<form method="post">
			<h3 style="color: white">Order Summary</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse; color: white">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Order
							No</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Product</th>

						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Order
							Date</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Customer
						</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="orders" items="${ORDERS}">
						<tr>

							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${orders.orderNo}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${orders.productId.product}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${orders.quantity}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${orders.orderedDate}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${orders.registerId.username}</td>

						</tr>
					</c:forEach>
				</tbody>
				
				</table>
				<table>
		<tbody>
		<tr>
					<td></td>
					<td>
						<button style="width: 60px;" type="submit">back</button>
					</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
					<td><a href="login.html">Logout</a></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>