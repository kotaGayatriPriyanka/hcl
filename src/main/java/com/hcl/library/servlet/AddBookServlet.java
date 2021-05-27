package com.hcl.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.library.beans.Book;
import com.hcl.library.services.BookDetailsImpl;
import com.hcl.library.util.UserDefinedException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet{
	public void init() throws ServletException {
        // Do required initialization
        System.out.println("servelt method intialized");
     }
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
	   String id=request.getParameter("id");
       String title=request.getParameter("title");
       String author=request.getParameter("author");
       String price=request.getParameter("price");
       Book b=new Book();
       b.setId(Integer.parseInt(id));
       b.setTitle(title);
       b.setAuthor(author);
       b.setPrice(Integer.parseInt(price));  
       response.setContentType("text/html");
       BookDetailsImpl bd=new BookDetailsImpl();
       try {
           bd.addDetails(b);
           List<Book> list=new ArrayList<Book>();
			
			 // list=bd.display(); 
			  RequestDispatcher
			  rd=request.getRequestDispatcher("index.jsp"); 
			  request.setAttribute("list",list);
			  request.setAttribute("message","Book added successfully.");
			  rd.forward(request, response);
			 
       } catch (UserDefinedException e1) {
    	   RequestDispatcher rd=request.getRequestDispatcher("addDetails.jsp");
    	   request.setAttribute("message","Book Id already exsits.");
    	   rd.forward(request, response);
       }
   
          }
	 public void destroy() {
         System.out.println("servlet is destroyed"); 
       }

}
