<%-- 
    Document   : newjsp
    Created on : 4/03/2019, 11:39:50 PM
    Author     : Armando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Practica3</h1>
        <%
            String Name = request.getParameter("Nombre");
            String Email = request.getParameter("Correo");
            String Password = request.getParameter("Contrasena");
            String Birthday = request.getParameter("Fecha");
            
            out.println("Tu nombre es: " + Name);
            out.println("Tu correo es: " + Email);
            out.println("Tu contraseña es : " + Password);
            out.println("Tu feha de nacimiento es: " + Birthday);
         %>   
          
    </body>
</html>
