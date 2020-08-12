<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DynamicQuery</title>
<style type="text/css">

	table {
		
		border: 2px solid black;
	}
	th, td {
		border: 2px solid black;
	}

</style>
</head>
<body>

<table>
<c:forEach items="${list}" var="list">
<tr>
<th>NO</th>
<td>${list.NO }</td>
<th>ID</th>
<td>${list.ID }</td>
<th>PW</th>
<td>${list.PW }</td>
</tr>
</c:forEach>


</table>


</body>
</html>