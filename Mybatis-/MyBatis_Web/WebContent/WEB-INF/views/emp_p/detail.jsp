<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세 정보</title>
</head>
<body>

<h1>사원 상세 정보</h1>
<hr>

<ul>
<li>${result.empno }</li>
<li>${result.ename }</li>
<li>${result.job	}</li>
</ul>

<button type="button" onclick="location.href='/emp/delete?empno=${result.empno}'">사원 삭제</button>



</body>
</html>