
package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administration implements User{
    
    private String username;
    private String password;
    private String email;
    private String usertype;
    private String userAdmin;
    private String userId;    
    boolean login;  
    boolean regist;
    Connection conectar = null;
    
    public Administration(){
    }
    
    public Administration(String username, String password){
        this.username = username;
        this.password = password;
        
    }
   
    public Administration(String username, String password, String email, String usertype, String userAdmin, String userId){
        this.username = username;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
        this.userAdmin = userAdmin;
        this.userId = userId;
    
    }
    
    @Override
     public void addUsers(){
     
          try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/practica8", "root", "");
            Statement stmt = conectar.createStatement();  
            
                          
         
           PreparedStatement prepared =conectar.prepareStatement("INSERT INTO user VALUES('"+ username +"','"+password +"', '"+email +"', '"+usertype +"')");
           prepared.executeUpdate();

           regist = true;
            
           } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            regist = false;
            
            } finally {
       
                      }
     
     
          try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/practica8", "root", "");
            Statement stmt = conectar.createStatement();  
                 
         
           PreparedStatement prepared =conectar.prepareStatement("INSERT INTO admin VALUES('"+ userAdmin +"','"+userId +"')");
           prepared.executeUpdate();

           regist = true;
            
           } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            regist = false;
            
            } finally {
       
                      }
     
     }
    @Override
    public boolean checkUsersList(){
  
       try{
        Class.forName("com.mysql.jdbc.Driver");
        conectar = DriverManager.getConnection("jdbc:mysql://localhost/practica8", "root", "");
        Statement stmt = conectar.createStatement();  
         
        
        String sql = "SELECT username, password FROM user";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
         
         String userv = rs.getString("username");
         String passwordv = rs.getString("password");
         
         if (username.equals(userv)){
              if(password.equals(passwordv)){
                    login = true;         
              }
              } else {
              login = false;
                 }
        } 
       
          } catch(SQLException e){
            System.out.println(e.getMessage());
            login = false;
        
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Administration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return login;
    }
}
