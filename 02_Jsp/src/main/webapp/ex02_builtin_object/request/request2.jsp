<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String model = request.getParameter("model");
		Optional<String> opt = Optional.ofNullable(request.getParameter("price"));		// Null만 처리 가능, 빈문자열은 처리 불가
		int price = Integer.parseInt(opt.orElse("0"));
	%>
	
	<h1>모델 : <%=model %></h1>
	<h1>가격 : <%=price %></h1>
	
</body>
</html>