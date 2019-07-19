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

@WebServlet("/login")
public class userLogin extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		//add two number fetch from the html file
		String email = req.getParameter("login_email");
		String password = req.getParameter("login_password");
				
		try{
			
		    
			System.out.println(email + " " + password);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginSystem","root","cb-surendra");
		    
			String query = "select * from UserDetails";
			PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rset = preparedStatement.executeQuery();
            
            boolean flag = false;
            while( rset.next() ){
            	
                if(rset.getString(3).equals(email)  &&  rset.getString(4).equals(password)){
                	Cookie ck=new Cookie("Email", email);//creating cookie object  
        		    res.addCookie(ck);
                	flag = true;
                	break;
                }
                
            }
            if(flag) {
            	res.getWriter().println(
            			"<html><body>"+
            					"<form action= \"add.html\">\n" + 
            					"	<input type=\"submit\" value =\"AddDetails\">\n" + 
            					"</form><br>" + 
            					"<form action=\"edit.html\">\n" + 
            					"	<input type=\"submit\" value=\"EditDetails\">\n" + 
            					"</form>"+
            			"</body></html>"
            			);
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
