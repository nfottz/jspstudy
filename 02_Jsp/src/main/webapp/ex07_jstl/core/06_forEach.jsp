<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
		<c:forEach>
		1. 반복문을 처리하는 태그이다.
		2. 배열이나 리스트의 요소를 처리하는 향상 for문의 역할도 수행한다.
		3. 형식
			1) 일반 for문
				<c:forEach var="변수" begin="시작값" end="종료값" step="증가값">
					반복실행문
				</c:forEach>
			2) 향상 for문
				<c:forEach var="요소" items="배열 또는 리스트">
					반복실행문
				</c:forEach>
	 --%>
	 
	<%-- 1 ~ 5 출력 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		<span>${n }</span>
	</c:forEach>
	
	<hr>
	
	<%-- 5 ~ 1 출력 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		<span>${6-n }</span>
	</c:forEach>
	
	<hr>
	
	<%-- 배열 --%>
	<%
		String[] seasons = {"봄", "여름", "가을", "겨울"};
		pageContext.setAttribute("seasons", seasons);	// EL 사용을 위해서 pageContext에 저장한다.
	%>
	<c:forEach var="season" items="${seasons }" varStatus="vs">
		<div>인덱스 : ${vs.index }, 순번 : ${vs.count }, 요소 : ${season }</div>
	</c:forEach>
	
	<hr>
	
	<%-- 리스트 --%>
	<%
		List<String> jobs = Arrays.asList("개발자", "기획자", "PM", "퍼블리셔");
		pageContext.setAttribute("jobs", jobs);
	%>
	<c:forEach var="job" items="${jobs }" varStatus="k">
		<div>인덱스 : ${k.index }, 순번 : ${k.count }, 요소 : ${job }</div>
	</c:forEach>
	
</body>
</html>