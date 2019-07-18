package com.cbsurendra;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//add two number fetch from the html file
		
		int username = Integer.parseInt(req.getParameter("username"));
		String password = req.getParameter("password");
		
		try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","cb-surendra");
            
            //here login is database name, root is username and password        
            String query = "select * from loginDetails";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rset = preparedStatement.executeQuery();
            
            boolean flag = false;
            while( rset.next() ){
            	
                if(rset.getInt(1)== username &&  rset.getString(2).compareTo(password) == 0 ) {
                	flag = true;
                	break;
                }
            }
            if(flag) {
            	res.getWriter().println("Connection Successfull");
            }
            else{
            	res.getWriter().println("Connection failed");
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
