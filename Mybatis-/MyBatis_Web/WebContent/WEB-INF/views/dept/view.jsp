<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript"
 src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<style type="text/css">
#dept{
	border: 3px double black;
}

/* th { */
/* border: 1px solid black;	 */
/* } */
/* td { */
/* border: 1px solid black;	 */
/* } */
th, td {
border: 1px solid black;	
}

</style>
</head>
<body>

<h2>부서 정보</h2>
<hr>
<table id="dept">
<thead>
<tr>
	<th>부서번호</th>
	<th>부서이름</th>
	<th>주소</th>
</tr>
</thead>

<tbody>
<tr>
	<td style="text-align: center">${view.deptno }</td>
	<td>${view.dname }</td>
	<td>${view.loc }</td>
</tr>
</tbody>

</table>

<button type="button" onclick="location.href='/dept/list' ">목록</button>
<button type="button" onclick="location.href='/dept/delete?deptno=${view.deptno}' ">삭제</button>
<!-- <button id="btnDelete" class="btn btn-danger pull-right" onclick="alert('삭제되었습니다.');">삭제</button> -->

</body>
</html>