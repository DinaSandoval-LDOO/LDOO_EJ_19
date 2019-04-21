
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserLogin extends HttpServlet {

    
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
        
        try {
            if(dbc.verificar()){
                
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Signed In! </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>");
                out.println("Wellcome!C:");
                out.println("</h1>");
                out.println("</body>");
                out.println("</html>");
                
                
                
                
            } else{
                
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Signed In! </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>");
                out.println("Incorrect password!:C");
                out.println("</h1>");
                out.println("<a href = login.html>");
                out.println("Try again");
                out.println("</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
