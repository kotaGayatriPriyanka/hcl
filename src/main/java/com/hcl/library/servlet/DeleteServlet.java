package com.hcl.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.library.services.BookDetailsImpl;
import com.hcl.library.util.UserDefinedException;

 
@WebServlet("/deleteBook")
public class DeleteServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public void init() throws ServletException{
        System.out.println("Servlet initialised");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        //String title = req.getParameter("title" );
        String id=req.getParameter("id");
        int x = Integer.parseInt(id);
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        try {
        	BookDetailsImpl bd=new BookDetailsImpl();
            bd.deleteBook(x);
            RequestDispatcher rd = req.getRequestDispatcher("displayBookDetails");
            req.setAttribute("message","Deleted Successfully" );
            rd.include(req, res);
        } catch (UserDefinedException e2) {
            // TODO Auto-generated catch block
            RequestDispatcher rd = req.getRequestDispatcher("displayBookDetails");
            req.setAttribute("message","Book id doesnot exists" );
            rd.forward(req, res);
            e2.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        doGet(req,res);
    }
    public void destroy() {
        System.out.println("servlet destroyed");
    }
}