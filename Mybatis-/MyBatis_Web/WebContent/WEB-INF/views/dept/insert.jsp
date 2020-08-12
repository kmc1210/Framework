<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 부서 등록</title>
</head>
<body>

<form action="/dept/insert" method="post">


<ul>
<li>부서번호  :<input type="text"  name="deptno" id="deptno" min="0" max="99"/></li>
<li>부서명 :<input type="text" name="dname" id="dname"></li>
<li>위치: <input type="text" name="loc" id="loc"/></li>
</ul>
<button> 전송하기 </button>
</form>




</body>
</html>