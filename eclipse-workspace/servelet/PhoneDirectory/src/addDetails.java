import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class addDetails extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse rep) {
		
		String Fname = req.getParameter("fname");
		String Lname = req.getParameter("lname");
		String Add1 = req.getParameter("add1");
		String Add2 = req.getParameter("add2");
		String City = req.getParameter("city");
		String State = req.getParameter("state");
		int ZipCode = Integer.parseInt(req.getParameter("zipcode"));
		int phone_work = Integer.parseInt(req.getParameter("phone_work"));
		int phone_home = Integer.parseInt(req.getParameter("phone_home"));
		int phone_mobile = Integer.parseInt(req.getParameter("phone_mobile"));
		String Country = req.getParameter("cntry");
		
		System.out.println(Fname + " " + Lname + " "+Add1 + Add2);
		System.out.println(City+" "+State + " "+ZipCode + " "+Country);
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceportal","root","cb-surendra");
			
			String query = "insert into PhoneDirectory(FirstName, LastName, Add1, Add2, City, State, ZipCode, PhoneWork, PhoneHome, "
					+ "PhoneMobile, Country) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?);";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, Fname);
			preparedStatement.setString(2, Lname);
			preparedStatement.setString(3, Add1);
			preparedStatement.setString(4, Add2);
			preparedStatement.setString(5, City);
			preparedStatement.setString(6, State);
			preparedStatement.setInt(7, ZipCode);
			preparedStatement.setInt(8, phone_work);
			preparedStatement.setInt(9, phone_home);
			preparedStatement.setInt(10, phone_mobile);
			preparedStatement.setString(11, Country);
            
            if(preparedStatement.execute()) {
            	System.out.println("Data is not inserted");
            }
            else {
            	System.out.println("Data Inserted Successfully");
            }
            con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
