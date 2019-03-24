
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


@WebServlet(name = "WellcomeServlet", urlPatterns = {"/WellcomeServlet"})
public class WellcomeServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true); 
        
        Cookie cookie[]= request.getCookies();        
        cookie[0].setMaxAge(0);
        response.addCookie(cookie[0]);
        
       PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title></title>");   
       out.println("<meta charset=\"UTF-8\">");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>");
       out.println("Your cookie has expired c:");
       out.println("</h1>");
       out.println("<form action = \"/Practica5y6/RegisterServlet\") method=\"post\">");
       out.println("Name: ");
       out.println("<input type=\"text\" name = \"name\">");
       out.println("UserId: ");
       out.println("<input type=\"text\" name = \"userid\">");
       out.println("UserIdKey: ");
       out.println("<input type=\"text\" name = \"useridekey\">");
       out.println("<input type=\"submit\" value = \"Submit\">");
       out.println("</form>");
       out.println("</body>");
       out.println("</html>");
        
        
        
        }

    }

   



