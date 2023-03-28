<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	request.setCharacterEncoding("UTF-8");
	Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
	String title = opt.orElse("환영합니다!");
%>
<title><%=title %></title>
<%-- request.getContextPath() == /02_Jsp --%>
<link rel="styleSheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css">
<script src="<%=request.getContextPath() %>/resources/js/webapp/jquery-3.6.4.min.js"></script>
</head>
<body>

	<nav>
		<ul>
			<% for(int i = 1; i <= 3; i++) { %>
					<li><a href="body<%=i %>.jsp">body<%=i %></a></li>
			<% } %>
			
<!--		<li><a href="body1.jsp">body1</a></li>
			<li><a href="body2.jsp">body2</a></li>
			<li><a href="body3.jsp">body3</a></li>
  -->
		</ul>
	</nav>
	
	<hr>
