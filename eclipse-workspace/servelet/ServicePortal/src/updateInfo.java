import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editDetails")
public class updateInfo extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse rep) {
		String fname = req.getParameter("first_name");
		String lname = req.getParameter("last_name");
		String email = req.getParameter("email");
		String add1 = req.getParameter("add1");
		String add2 = req.getParameter("add2");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		int zipcode = Integer.parseInt(req.getParameter("zipcode"));
		String cntry = req.getParameter("cntry");
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceportal","root","cb-surendra");
			
			String query = "insert into loginT(FirstName, LastName, Address1, Address2, City, State, Zip, Country) "
					+ "values(?,?,?,?,?,?,?);";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setString(3, add1);
			preparedStatement.setString(4, add2);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, state);
			preparedStatement.setInt(7, zipcode);
			preparedStatement.setString(8, cntry);
            
            if(preparedStatement.execute()) {
            	System.out.println("Login successfull");
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
