
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




@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
      
       Cookie []cookie;
       if(request.getCookies()!=null){
       cookie=request.getCookies();
       }else {
       cookie=null;
       }

       
       String cookieid="cookieid";
       if(cookie!=null){
       cookieid =cookie[0].getValue();
       response.addCookie(cookie[0]);
       }

      String sessionid=session.getId();
      
       
      String userId= request.getParameter("uid");
      String userIdKey= request.getParameter("uidk");
       
              
       if(cookie != null){
            if(userId.equals((String)session.getAttribute("userid"))){
                if(userIdKey.equals((String)session.getAttribute("useridkey"))){
                    if(sessionid.equals(cookieid)){
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Signed in</title>");   
        out.println("<meta charset=\"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>");
        out.println("Wellcome!c:");
        out.println("</h1>");
        out.println("<form action = \"/Practica5y6/WellcomeServlet\") method=\"post\">");
        out.println("<input type=\"submit\" value = \"Click me c:\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
                    }
                }
         else{
       
       PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Error</title>");   
       out.println("<meta charset=\"UTF-8\">");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>");
       out.println("Incorrect UserIdKey!:c");
       out.println("</h1>");
       out.println("<form action = \"/Practica5y6/LoginServlet\") method=\"post\">");
       out.println("UserId: ");
       out.println("<input type=\"text\" name = \"uid\">");
       out.println("UserIdKey: ");
       out.println("<input type=\"text\" name = \"uidk\">");
       out.println("<input type=\"submit\" value = \"Submit\">");
       out.println("</form>");
       out.println("</body>");
       out.println("</html>");
       
       }
            }
       
       else{
       
       PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Error</title>");   
       out.println("<meta charset=\"UTF-8\">");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>");
       out.println("Incorrect UserId!:c");
       out.println("</h1>");
       out.println("<form action = \"/Practica5y6/LoginServlet\") method=\"post\">");
       out.println("UserId: ");
       out.println("<input type=\"text\" name = \"uid\">");
       out.println("UserIdKey: ");
       out.println("<input type=\"text\" name = \"uidk\">");
       out.println("<input type=\"submit\" value = \"Submit\">");
       out.println("</form>");
       out.println("</body>");
       out.println("</html>");
       
       }
    
    } else if(cookie == null){
    
        PrintWriter out = response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title></title>");   
       out.println("<meta charset=\"UTF-8\">");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>");
       out.println("User doesn't exist");
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
}
