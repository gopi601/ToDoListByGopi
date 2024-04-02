<%@page import="java.util.Base64"%>
<%@page import="dto.javabeanuser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%javabeanuser j=(javabeanuser)request.getSession().getAttribute("userr"); %>
<h2>welcome :: <%=j.getUsername() %></h2>
<h2>email :: <%=j.getUseremail() %></h2>
<%String image=new String(Base64.getEncoder().encode(j.getUserimage())); %>
<img alt="" src="data:image/jpeg;base64, <%= image %>" width="150" height="200">
</body>
</html>