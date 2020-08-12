<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department List</title>
</head>
<body>

<h1>부서 정보 목록</h1>


<hr>
<table>

<thead>
<tr>
	<th>부서번호</th>
	<th>부서이름</th>
	<th>위치</th>
</tr>
</thead>


<tbody>
<c:forEach items="${deptList }" var="dept">
<tr>
	<td style="text-align: center">${dept.deptno }</td>
	<td><a href="/dept/view?deptno=${dept.deptno }">${dept.dname }</a></td>
	<td>${dept.loc }</td>

</tr>

</c:forEach>
</tbody>


</table>

<button type="button" onclick="location.href='/dept/insert' ">새로운 부서 등록</button>

</body>
</html>