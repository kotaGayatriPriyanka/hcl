<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-color:skyblue;">
<h1 align="center">Welcome To Library Management System</h1>
<table align="center">
	<tr><td><a href="addDetails.jsp"><button>Add Book</button></a></td>
	
	<td><form action=displayBookDetails method="get"><button>Display Details</button></a></tr></td>
</table>
</form>
<div align="center"><% if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message") %>
<%} %></div>
</body>
</html>