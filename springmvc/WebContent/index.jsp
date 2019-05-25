<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Employee Detail</title>


<style>
table, th, td {
	border: 2px solid black;
	margin: auto;
	padding: auto;
	border-collapse: collapse;
	background-color: orange;
	align: center;
}
</style>
</head>
<body>
	<div
		style="border: 2px solidNAMEblack; margin: auto; padding: auto; background-color: #3ef192">
		<h1>${insert1}</h1>
		<h2 style="text-align: center;">Employee Detail</h2>
	</div>
	<div
		style="border: 2px solidblack; margin: auto; padding: auto; background-color: #e46d78">
		<table style="color: #C20884;">
			<tr>
				<th>EmployeeID</th>
				<th>Name</th>
				<th>Action</th>

			</tr>
			<tr>
				<form action=add method="post">
					<td>ID: <input type="number" name="aemp">${insert2}</td>
					<td>NAME: <input type="text" name="aname"></td>
					<td><input type="submit" value="INSERT" OnClick="add()" /></td>
				</form>
			</tr>
			<tr>

				<form action=update method="post">
					<td>ID:<input type="number" name="aemp"></td>
					<td>NAME: <input type="text"
						placeholder="enter the updated name" name="aname"></td>
					<td><input type="submit" value="UPDATE" /></td>
				</form>
			</tr>

			<tr>
				<form action="delete" method="post">
					<td>ID:<input type="number" name="y1"
						placeholder="Enter the ID want to delete"></td>
					<td></td>
					<td><input type="submit" value="Delete" OnClick="delete()" /></td>
				</form>
			</tr>
			<tr>

				<form action="find" method="post">
					<td>ID:<input type="number" name="aemp"
						placeholder="Enter the Id "></td>
					<td></td>
					<td><input type="submit" value="Search" /></td>
				</form>
			</tr>

			<tr>
				<form action=get method="post">
					<td></td>
					<td></td>
					<td><input type="submit" value="List of employees" /></td>
				</form>
			</tr>
		</table>
	</div>

	<div
		style="border: 2px solidblack; margin: auto; padding: auto; background-color: grey">
	
		<table>
			<thead>
				<tr>
					<th scope="col">EmployeeID</th>
					<th scope="col">Name</th>
				</tr>
				<tr>
					<th>${chhatar.aemp}</th>
					<th>${chhatar.aname}</th>
				</tr>
				<tr>
					<th>${result1.aemp}</th>
					<th>${result1.aname}</th>
				</tr>
				<tr>
					<th>${insert.aemp}</th>
					<th>${insert.aname}</th>
				</tr>
				<tr>
					<c:forEach items="${employes}" var="employess">
						<tr>
							<th>${employess.aemp}</th>
							<th>${employess.aname}</th>
						</tr>
					</c:forEach>
				</tr>


			</thead>
		</table>
	</div>
</body>
</html>