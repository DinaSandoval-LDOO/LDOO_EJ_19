
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Cookie;


@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            String name = request.getParameter("name");
            String userid = request.getParameter("userid");
            String useridkey = request.getParameter("useridkey");
        
            
    
            HttpSession session = request.getSession(true);            
            
            session.setAttribute("userid", userid);
            session.setAttribute("useridkey", useridkey);
            
            Cookie cookie = new Cookie("cookie", session.getId());
            response.addCookie(cookie);
    
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<tittle>");
            out.println("Signed up!");
            out.println("</tittle>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            out.println("You are in!C:");
            out.println("</h1>");
            out.println("<a href = Login.html>");
            out.println("Sign in");
            out.println("</a>");
            out.println("</body>");
            out.println("</html>");
            
    }

}
