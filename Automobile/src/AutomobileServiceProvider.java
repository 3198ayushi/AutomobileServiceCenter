import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.http.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/AutomobileServiceProvider")
public class AutomobileServiceProvider extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
            res.setContentType("text/html");
			PrintWriter out =res.getWriter();
			
				  try{  
					  
			            Class.forName("com.mysql.cj.jdbc.Driver");  
			         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serviceprovider","root","Aayu@1268");  
				 
				 PreparedStatement ps=con.prepareStatement( "insert into Servicer values(?,?,?,?,?)");  
	                ps.setString(1,req.getParameter("username"));  
	                ps.setString(2,req.getParameter("email_id"));  
		            ps.setString(3,req.getParameter("contact_number"));  
		            ps.setString(4,req.getParameter("Service_location"));
		            ps.setString(5,req.getParameter("password"));
		              
	
	           int status=ps.executeUpdate();  
	           if(status>0) {
	        	   out.println("success");
	           }
	           else {
	        	   out.println("failure");
					}
				  }
				catch(Exception e) {
						out.println(e);
					} 
			out.close();


	}
	
}

		
