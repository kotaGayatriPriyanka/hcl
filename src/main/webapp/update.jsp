<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hcl.library.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Update</h3>
<%List<Book> list=(ArrayList<Book>)request.getAttribute("list"); %>
<%for(Book b:list){ %>
<form action="updateBook" method="get">
<table align="center" border="2" style="background-color:skyblue;">
		<tr><td>Enter Id:</td><td style="text-align:center;"><input readonly type="text" name="id" placeholder="Enter id" value="<%=b.getId()%>"size="10"/></td></tr>
        <tr><td>Enter title:</td><td><input  type="text" name="title" value="<%=b.getTitle()%>" size="50"/></td></tr>
        <tr><td>Enter Author:</td><td><input  type="text" name="author" value="<%=b.getAuthor()%>" size="50"/></td></tr>
        <tr><td>Enter Price:</td><td style="text-align:center;"><input type="text" name="price" value="<%=b.getPrice() %>" size="10"/></td></tr>
    	<tr><td align="center" colspan="2"><form></form><input type=submit value="Update"></td></tr></form>
</table>
</form>
<%} %>
</body>
</html>