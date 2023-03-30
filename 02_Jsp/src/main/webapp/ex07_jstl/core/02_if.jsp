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

	<%--
		<c:if></c:if>
		1. if문을 대체하는 태그이다.
		2. else문이 지원되지 않는다.
		3. 형식
			<c:if test="조건식">
				실행문
			</c:if>
	 --%>
	 
	 <c:set var="age" value="30" scope="page" />
	 <c:if test="${age le 100 }">
	 	<h1>Alive!</h1>
	 </c:if>
	 <c:if test="${age gt 100 }">
	 	<h1>Dead!</h1>
	 </c:if>
	 
	 <c:set var="score" value="100" scope="page" />
	 <c:if test="${score le 100 and score ge 90 }">
	 	<h1>A</h1>
	 </c:if>
	 <c:if test="${score lt 90 and score ge 80 }">
	 	<h1>B</h1>
	 </c:if>
	 <c:if test="${score lt 80 and score ge 70 }">
	 	<h1>C</h1>
	 </c:if>
	 <c:if test="${score lt 70 and score ge 60 }">
	 	<h1>D</h1>
	 </c:if>
	 <c:if test="${score lt 60 and score ge 0 }">
	 	<h1>F</h1>
	 </c:if>

</body>
</html>