import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
@WebServlet("/AutomobileServiceProviderLogin")
public class AutomobileServiceProviderLogin extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       request.getRequestDispatcher("LoginServiceProvider.html").include(request, response);  
          
        String email=request.getParameter("email_id");  
        String pass=request.getParameter("password");  
          
        if(pass!=("password")){  
        //out.print("Welcome, "+email);  
        HttpSession session=request.getSession();  
        session.setAttribute("email_id",email);  
        request.getRequestDispatcher("login1.html").include(request, response);  
        
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("RegisterServiceProvider.html").include(request, response);  
        }  
        out.close();  
    }  
}  


