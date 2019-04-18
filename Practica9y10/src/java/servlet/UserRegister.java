
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String usertype = request.getParameter("suscribertype");
        String adminequals = "admin";
        String normalequals = "normal";
        String guestequals = "guest";
        
        Factory user = Factory.getInstance();
               
        if("admin".equals(usertype)){
        String userAdmin = request.getParameter("username");
        String userId = request.getParameter("userid");
        User admin = user.creatUser(usertype);
        admin = new Administration(username, password, email, usertype, userAdmin, userId);
        admin.addUsers();
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
         out.println("<a href = loginAdmin.html>");
         out.println("Sign in");
         out.println("</a>");
         out.println("</body>");
         out.println("</html>");
        }
        
        if("normal".equals(usertype)){
        
        String userNormal = request.getParameter("username");
        String name = request.getParameter("name");
        String subscribeType = request.getParameter("subscribetype");
        String address = request.getParameter("address");
        User normal = user.creatUser(usertype);
        normal = new Normal(username, password, email, usertype, userNormal, name, subscribeType, address);
        normal.addUsers();
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
         out.println("<a href = loginNormal.html>");
         out.println("Sign in");
         out.println("</a>");
         out.println("</body>");
         out.println("</html>");      
        
        }
        
        if ("guest".equals(usertype)){
        
        String userGuest = request.getParameter("username");
        String name = request.getParameter("name");
        String subscribeDate = request.getParameter("subscribedate");
        User guest = user.creatUser(usertype);
        guest = new Guest(username, password, email, usertype, userGuest, name, subscribeDate);
        guest.addUsers();
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
         out.println("<a href = loginGuest.html>");
         out.println("Sign in");
         out.println("</a>");
         out.println("</body>");
         out.println("</html>");   
        
        }
    }

    
    

}
