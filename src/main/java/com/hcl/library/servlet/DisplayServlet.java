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

@WebServlet("/displayBookDetails")
public class DisplayServlet extends HttpServlet{
	public void init() throws ServletException {
        // Do required initialization
        System.out.println("servelt method intialized");
     }
	
public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException 
{    
	   BookDetailsImpl bd=new BookDetailsImpl();
       response.setContentType("text/html");
       List<Book> list=new ArrayList<Book>();
       list=bd.display();
       RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
       request.setAttribute("list", list);
       rd.forward(request, response);
         
}
	 public void destroy() {
         System.out.println("servlet is destroyed"); 
       }

}

