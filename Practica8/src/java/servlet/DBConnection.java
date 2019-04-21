package servlet;

import java.sql.*;

public class DBConnection {

    boolean login; 
    boolean regist;
    Statement stmt = null;
    Connection conectar = null;
    String userdb;
    String passworddb;

    public DBConnection(String user, String password) {
        this.userdb = user;
        this.passworddb = password;

    }

    public boolean conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/practica8", "root", "");
            stmt = conectar.createStatement();  
                 
         
           PreparedStatement prepared =conectar.prepareStatement("INSERT INTO USUARIOS VALUES('"+ userdb +"','"+ passworddb +"')");
           prepared.executeUpdate();

           regist = true;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            regist = false;
        } finally {
       
            try {
                if (stmt != null) {
                    conectar.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conectar != null) {
                    conectar.close();
                }
            } catch (SQLException se) {
                
            }

          }
             return regist;
    }
    
    public boolean verificar() throws ClassNotFoundException{
      try{
        Class.forName("com.mysql.jdbc.Driver");
        conectar = DriverManager.getConnection("jdbc:mysql://localhost/practica8", "root", "");
        stmt = conectar.createStatement();  
               
        String sql = "SELECT user, password FROM usuarios";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
         
         String user = rs.getString("user");
         String password = rs.getString("password");
         
         if (userdb.equals(user)){
              if(passworddb.equals(password)){
                    login = true;         
              }
              } else {
              login = false;
                 }
            
        } 
       
    } catch(SQLException e){
        
        
        
    }        
       return login;
    }


}
