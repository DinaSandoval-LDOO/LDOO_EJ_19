
package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Normal implements User {
    
    private String username;
    private String password;
    private String email;
    private String usertype;    
    private String userNormal;
    private String name;
    private String subscribeType;
    private String address;
    boolean login;  
    boolean regist;
    Connection conectar = null;
    
    public Normal(){}
    
    public Normal(String username, String password){
        this.username = username;
        this.password = password;    
    
    }
    
    public Normal(String username, String password, String email, String usertype, String userNormal, String name, String subscribeType, String address){
        this.username = username;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
        this.userNormal = userNormal;
        this.name = name;
        this.subscribeType = subscribeType;
        this.address = address;
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
                 
         
           PreparedStatement prepared =conectar.prepareStatement("INSERT INTO normal VALUES('"+ userNormal +"','"+name +"', '"+subscribeType +"', '"+address +"')");
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
