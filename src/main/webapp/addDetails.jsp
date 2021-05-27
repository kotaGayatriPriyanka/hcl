<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="addBook" method="get">
 <h3 align="center">Add Book Details</h3>
<table align="center" border="2" style="background-color:skyblue;">
		<tr><td>Enter Id:</td><td style="text-align:center;"><input type="text" name="id" placeholder="Enter id" size="10"/></td></tr>
		<tr><td>Enter title:</td><td><input type="text" name="title" placeholder="Enter title" size="50"/></td></tr>
		<tr><td>Enter Author:</td><td><input type="text" name="author" placeholder="Enter Auhor" size="50"/></td></tr>
		<tr><td>Enter Price:</td><td style="text-align:center;"><input type="text" name="price" placeholder="Enter Price" size="10"/></td></tr>
		<tr><td align="center" colspan="2"><form></form><input type=submit value="save"></td></tr></form>
</table>
</form>

<div align="center"><% if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message") %>
<%} %></div>
</body>
</html>