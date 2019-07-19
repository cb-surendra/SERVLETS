package com.cbsurendra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addAddress")
public class EditAddress extends HttpServlet{
	
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		//add two number fetch from the html file
		String address = req.getParameter("add_address");
				
		try{
			Cookie cookies[] = req.getCookies();
			String email = "";
			for(Cookie c : cookies) {
				
				System.out.println(c.getName() + " " + c.getValue());
				
				if( c.getName().equals("Email")) {
					email = c.getValue();
				}
			}
			System.out.println(email);
			
			String SQL_INSERT = "update UserDetails set "
					+ "Address = \"" + address + "\" "
					+ "where Email = \"" + email + "\" ";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginSystem","root","cb-surendra");
		    
		    PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT);
		    /*preparedStatement.setString(1, firstname);
		    preparedStatement.setString(2, lastname);
		    preparedStatement.setString(3, address);
		    preparedStatement.setString(4, email);
		    */
		    if( preparedStatement.execute()) {
		    	res.getWriter().println("Information Edited");
		    }
		    con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
