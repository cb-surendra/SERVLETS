package com.cbsurendra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addUserServlet extends HttpServlet{
	private static final String SQL_INSERT = "insert into loginDetails(user_name, password) values (?,?)";
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		//add two number fetch from the html file
		
		int username = Integer.parseInt(req.getParameter("username"));
		String password = req.getParameter("password");
		System.out.println(password);		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","cb-surendra");
		                 
		    PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
		    preparedStatement.setInt(1, username);
		    preparedStatement.setString(2, password);
		    
		    if( preparedStatement.executeUpdate() > 0) {
		    	res.getWriter().println("Data inserted");
		    }
		    con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
