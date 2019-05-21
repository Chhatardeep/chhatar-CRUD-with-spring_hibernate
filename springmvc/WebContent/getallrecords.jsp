<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Employees</title>
</head>
<body>

<table>
<c:forEach items="${display}" var="employes">
<tr>
<th>${employes.aemp}</th>
<th>${employes.aname}</th>
</tr>
</c:forEach>
</table>
</body>
</html>