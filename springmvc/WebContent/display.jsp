<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${result}
<c:if test="${result eq null}">
This emp id is not available
</c:if>
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