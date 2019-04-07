package servlet;

import java.sql.*;

public class DBConnection {

    boolean login;    
    Connection conectar = null;
    Statement stmt = null;
    String userdb;
    String passworddb;

    public DBConnection(String user, String password) {
        this.userdb = user;
        this.passworddb = password;

    }

    public Statement conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/practica8", "root", "");
            stmt = conectar.createStatement();
            return stmt;

//            String sql = "INSERT INTO usuarios "
//                    + "VALUES ('user2', 'password2')";
//            stmt.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
       
            try {
                if (stmt != null) {
                    conectar.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conectar != null) {
                    conectar.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try

            return stmt;

        }
    }
    
    public boolean verificar(){
      try{
          
        conexion();
        Statement statement = conexion();
    
        
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
