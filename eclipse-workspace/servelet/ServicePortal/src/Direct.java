import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class Direct extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse rep) throws IOException {
		rep.sendRedirect("Register.html");
	}
}
