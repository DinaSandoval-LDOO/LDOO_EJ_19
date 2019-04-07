
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
        
        
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        DBConnection dbc = new DBConnection(user, password);
        dbc.conexion();
        
        
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

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
