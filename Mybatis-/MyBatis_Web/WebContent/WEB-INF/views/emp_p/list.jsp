<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>

<h1>사원 목록</h1>
<hr>

<table>

<c:forEach items="${empList}" var="emp">
<tbody>
<tr>
	<td>${emp.empno }</td>
	<td><a href="/emp/detail?empno=${emp.empno }" >${emp.ename }</a></td>		
	<td>${emp.job }</td>
</tr>
</tbody>
</c:forEach>


</table>

<button type="button"  onclick="location.href='/emp/insert_p'">사원등록</button>


</body>
</html>