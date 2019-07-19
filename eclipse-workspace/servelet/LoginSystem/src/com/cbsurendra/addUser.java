package com.cbsurendra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class addUser extends HttpServlet{
	private static final String SQL_INSERT = "insert into UserDetails"
			+ "(FirstName, LastName, Email, Password) values (?,?,?,?)";
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		//add two number fetch from the html file
		
		String firstname = req.getParameter("first_name");
		String lastname = req.getParameter("last_name");
		String email = req.getParameter("email");
		String conf_email = req.getParameter("confirm_email");
		String password = req.getParameter("password");
		String conf_password = req.getParameter("confirm_password");
				
		try{
			
			System.out.println(firstname + " " + lastname + " "+email +" "+password);
			if( email.equals(conf_email) && password.equals(conf_password) )
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginSystem","root","cb-surendra");
			    
			    PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
			    preparedStatement.setString(1, firstname);
			    preparedStatement.setString(2, lastname);
			    preparedStatement.setString(3, email);
			    preparedStatement.setString(4, password);
			    
			    if( preparedStatement.executeUpdate() > 0) {
			    	res.getWriter().println("Data inserted");
			    }
			    con.close();
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
