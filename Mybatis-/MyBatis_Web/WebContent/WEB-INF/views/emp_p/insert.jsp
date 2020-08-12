<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Insert</title>
</head>
<body>

	<h1>사원 등록</h1>

<form action="/emp/insert_p" method="post">


	<label>사원번호 : <input type="text" name="empno"></label>
	<br>
	<label>사원이름 : <input type="text" name="ename"></label>
	<br>
	<label>직무 : <input type="text"  name="job"></label>

	<button>전송</button>

</form>


</body>
</html>