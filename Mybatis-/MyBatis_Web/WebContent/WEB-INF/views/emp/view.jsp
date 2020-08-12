<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세 정보</title>
<style type="text/css">



</style>

</head>
<body>

<table id="emp">
<thead>
<tr>
	<td>사원번호</td>
	<td>이름</td>
	<td>직무</td>
	<td>매니저</td>
	<td>입사일</td>
	<td>급여</td>
	<td>상여금</td>
	<td>부서번호</td>
</tr>
</thead>

<tbody>
	<tr>
		<td>${view.empno  }</td>
		<td>${view.ename }</td>
		<td>${view.job }</td>
		<td>${view.mgr }</td>
		<td><fmt:formatDate value="${view.hiredate }" pattern="yyyyMMdd"/><br></td>
		<td>${view.sal }</td>
		<td>${view.comm }</td>
		<td>${view.deptno }</td>
	</tr>
</tbody>

</table>


</body>
</html>