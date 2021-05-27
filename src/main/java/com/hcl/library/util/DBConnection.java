package com.hcl.library.util;
import java.sql.*;
public class DBConnection
{

	private final static String url="jdbc:mysql://localhost:3306/library";
	private final static String username="root";
	private final static String password="gayatri";
	public DBConnection()
	{
		
	}
	
	private static Connection con=null;
	public static Connection getConnection()
	{
			try {
			if(con==null) 
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(url,username,password);
			}
			catch(Exception e)
			{ 
				System.out.println(e);
			}
	
		return con;
	}
	}
