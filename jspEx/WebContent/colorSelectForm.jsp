<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="colorSelect.jsp">
		<label for="color">색상을 선택하세요.</label><br>
		<select id="color" name="color">
			<option value="1">빨강</option>
			<option value="2">초록</option>
			<option value="3">파랑</option>
		</select>
		<input type="submit" value="전송">
	</form>
</body>
</html>