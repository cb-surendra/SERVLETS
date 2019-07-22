import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse rep) {
		String username = req.getParameter("user_name");
		String password = req.getParameter("user_pass");
		
		try{
			
		    
			System.out.println(username + " " + password);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceportal","root","cb-surendra");
		    
			String query = "select * from loginT";
			PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rset = preparedStatement.executeQuery();
            
            boolean flag = false;
            
            while( rset.next() ){
            	
                if(rset.getString(1).equals(username)  &&  rset.getString(2).equals(password)){
                	System.out.println("Success");
                	flag = true;
                	break;
                }
                
            }
            if(flag) {
            	System.out.println("Login successfull");
            	rep.sendRedirect("AfterLogin.html");
            }
            else {
            	System.out.println("Login Failed");
            }
            con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
