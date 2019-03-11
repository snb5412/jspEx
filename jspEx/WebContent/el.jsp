<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var temp = 'test';
var str = `temp 변수 값 : \${temp}`;
console.log(str);
</script>
</head>
<body>
	${"Hello"} <br>
	<%="Hello"%> <br>
	<%out.println("Hello");%> <br>
	
	정수형 : ${10}<br>
	실수형 : ${5.6}<br>
	문자열형 : ${"성윤정"}<br>
	논리형 : ${true}<br>
	null : ${null}<br>
	\${표현식}<br>
	\${empty input} : ${empty input}<br>
	\${not empty input} : ${not empty input}<br>
	\${!empty input} : ${!empty input}<br>
</body>
</html>