
package Controlador;

import Modelo.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class controlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
            String nombre = request.getParameter("Nombre");
            String correo = request.getParameter("Correo");
            String contrasena = request.getParameter("Contrasena");
            String fechanacimiento = request.getParameter("Fecha");
            
            Modelo modelo = new Modelo (nombre, correo, contrasena, fechanacimiento);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hi!c:</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Wellcome!</h1>");
            out.println("<p>Have a nice day!c:</p>");
            out.println("<p>Name: " + nombre + "</p");
            out.println("<p>Email: " + correo + "</p");
            out.println("<p>Password: " + contrasena + "</p");
            out.println("<p>Birthday: " + fechanacimiento + "</p");
            out.println("</body>");
            out.println("</html>");
        }
    }

   

}
