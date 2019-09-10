import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.http.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
            res.setContentType("text/html");
			PrintWriter out =res.getWriter();
			
				  try{  
					  
			            Class.forName("com.mysql.cj.jdbc.Driver");  
			         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Automobile","root","Aayu@1268");  
				 
				 PreparedStatement ps=con.prepareStatement( "update AutomobileOwner set password=?,"+"contact_number=? where email_id=?");  
	                ps.setString(1,req.getParameter("password"));  
	                ps.setString(2,req.getParameter("contact_number"));  
		            ps.setString(3,req.getParameter("email_id"));  
		            //ps.setString(4,req.getParameter("user_address"));
		           // ps.setString(5,req.getParameter("password"));
		              
	
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

//			}
//			
//res.setContentType("text/html");
//		PrintWriter out=res.getWriter();
//		
//		
//		String username;
//		String n=req.getParameter("username");
//		String p=req.getParameter("email_id");
//		String q=req.getParameter("contact_number");
//		String x=req.getParameter("useraddress");
//		String y=req.getParameter("password");
//		
//		if(p.contentEquals("email_id"))
//		{
//			RequestDispatcher rd=req.getRequestDispatcher("RegisterAutomobile.html");
//			rd.forward(req, res);
//			out.print("successful");
//		
//		}
//		
//		else {
//			out.print("Sorry Invalid Entry");
//			RequestDispatcher rd=req.getRequestDispatcher("/RegisterAutomobile.html");
//			rd.include(req, res);
//		}
	}
	
}

		
