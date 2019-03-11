<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="pagination pagination-md justify-content-center">
		<c:forEach var="p" begin="1" end="${pi.totalPage}" varStatus="status">
			<c:if test="${pi.page == p}">
				<li class="page-item active"><a class="page-link" href="#">${p}</a></li>
			</c:if>
			<c:if test="${pi.page != p}">
				<li class="page-item"><a class="page-link" href="?page=${p}">${p}</a></li>
			</c:if>
		</c:forEach>
</ul>