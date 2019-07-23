<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*,javax.servlet.*" %>
	<%
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceportal","root","cb-surendra");
			
			String query = "select * from phoneDirectory;";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
	       
			ResultSet rs = preparedStatement.executeQuery(query);
		      
		    // iterate through the java resultset
		    
		    String  result = "<center><h3>Contacts</h3></center>";
		    result += "<table border=1 color:red align=\"center\" style=\"width:50%\">";
		    result += "<tr><td>FirstName</td><td>LastName</td><td colspan=\"2\">Address1</td>"+
		    		"<td>City</td><td>State</td><td>ZipCode</td><td>Phone(WORK)</td><td>Phone(HOME)</td><td>Phone (MOBILE)</td>"+
		    		"<td>Country</td></tr>";
		    while (rs.next()){
		    	result += "<tr>";
		    	String Fname = rs.getString("FirstName");
		    	result += "<td>" + Fname + "</td>";
		    	
		    	String Lname = rs.getString("LastName");
		    	result += "<td>" + Lname + "</td>";
		    	
		    	String Add1 = rs.getString("Add1");
		    	result += "<td>" + Add1 + "</td>";
		    	
				String Add2 = rs.getString("Add2");
				result += "<td>" + Add2 + "</td>";
				
				String City = rs.getString("City");
				result += "<td>" + City + "</td>";
				
				String State = rs.getString("State");
				result += "<td>" + State + "</td>";
				
				int ZipCode = Integer.parseInt(rs.getString("ZipCode"));
				result += "<td>" + ZipCode + "</td>";
				
				String phWork = rs.getString("PhoneWork");
				result += "<td>" + phWork + "</td>";
				
				String phHome = rs.getString("PhoneHome");
				result += "<td>" + phHome + "</td>";
				
				String phMobile = rs.getString("PhoneMobile");
				result += "<td>" + phMobile + "</td>";
				
				String Country = rs.getString("Country");
				result += "<td>" + Country + "</td>";
				
				result += "</tr>";
				System.out.print( Fname+" " + Lname + " "+ Add1 + " "+ Add2);
				System.out.println(" " + City+ " " + State + " "+ ZipCode + " " + phWork + " "+phHome + " "+phMobile+" "+Country);
		    }	    
		    result += "</table>";
		    
		    out.println( result );
	        con.close();
		}catch(Exception e){
			System.out.println(e);
		}
	%>
</body>
</html>