<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
		\${now} : ${now}
		<fmt:formatDate value="${now}"></fmt:formatDate>
		date : <fmt:formatDate value="${now}" type="date"></fmt:formatDate>
		time : <fmt:formatDate value="${now}" type="time"></fmt:formatDate>
		both : <fmt:formatDate value="${now}" type="both"></fmt:formatDate>
		default : <fmt:formatDate value="${now}" type="both"
			dateStyle="default" timeStyle="default"></fmt:formatDate>
		short : <fmt:formatDate value="${now}" type="both"
			dateStyle="short" timeStyle="short"></fmt:formatDate>
		medium : <fmt:formatDate value="${now}" type="both"
			dateStyle="medium" timeStyle="medium"></fmt:formatDate>
		long : <fmt:formatDate value="${now}" type="both"
			dateStyle="long" timeStyle="long"></fmt:formatDate>
		full : <fmt:formatDate value="${now}" type="both"
			dateStyle="full" timeStyle="full"></fmt:formatDate>
		pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" :
			<fmt:formatDate value="${now}"
					pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>
	</pre>
</body>
</html>