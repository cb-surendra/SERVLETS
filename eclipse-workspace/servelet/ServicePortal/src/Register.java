
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse rep) {
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String conf_email = req.getParameter("email_conf");
		String password = req.getParameter("pass");
		String conf_pass = req.getParameter("conf_pass");
		
		System.out.println( fname + " " + lname + " " + email + " " + conf_email + " " + password + " " + conf_pass);
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceportal","root","cb-surendra");
			
			String query = "insert into loginT(FirstName, LastName, Email, Password)"
					+ "values(?,?,?,?);";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			
			if( email.equals(conf_email) && password.equals(conf_pass)) {
				preparedStatement.setString(1, fname);
				preparedStatement.setString(2, lname);
				preparedStatement.setString(3, email);
				preparedStatement.setString(4, password);
	            
	            if(preparedStatement.execute()) {
	            	System.out.println("Login successfull");
	            }
	            else {
	            	System.out.println("Login Failed");
	            }
	            con.close();
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
