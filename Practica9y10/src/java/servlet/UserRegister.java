
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserRegister extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String usertype = request.getParameter("usertype");
        
        
        Factory user = Factory.getInstance();
        if(usertype.equals("admin")){
        
        String userAdmin = request.getParameter("username");
        String userId = request.getParameter("userid");
        User admin = user.creatUser(usertype, username, password, email, userAdmin, userId, null, null, null, null, null, null);
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
         out.println("<a href = login.html>");
         out.println("Sign in");
         out.println("</a>");
         out.println("</body>");
         out.println("</html>");
    }
        if(usertype.equals("normal")){
        
        String userNormal = request.getParameter("username");
        String name = request.getParameter("name");
        String subscribeType = request.getParameter("subscribetype");
        String address = request.getParameter("address");
        User normal = user.creatUser(usertype, username, password, email, null, null, userNormal, name, subscribeType, address, null, null);
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
         out.println("<a href = login.html>");
         out.println("Sign in");
         out.println("</a>");
         out.println("</body>");
         out.println("</html>");      
        
        }
        
        if (usertype.equals("guest")){
        
        String userGuest = request.getParameter("username");
        String name = request.getParameter("name");
        String subscribeDate = request.getParameter("subscribedate");
        User guest = user.creatUser(usertype, username, password, email, null, null, null, name, null, null, subscribeDate, userGuest);
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
         out.println("<a href = login.html>");
         out.println("Sign in");
         out.println("</a>");
         out.println("</body>");
         out.println("</html>");   
        
        }
        

   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
