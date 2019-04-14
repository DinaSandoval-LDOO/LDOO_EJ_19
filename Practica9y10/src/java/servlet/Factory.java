

package servlet;


public class Factory {
    
    private static Factory instance = new Factory();
    
    private Factory(){}
    
    public static Factory getInstance(){
        
        return instance;
    }
    
    
    public User creatUser(String usertype, String username, String password, String email, String userAdmin, String userId, String userNormal, String name, String subscribeType, String address, String subscribeDate, String userGuest){
   
       if (usertype.equals("admin")){
       
       return new Administration(username, password, email, usertype, userAdmin, userId);
       
                                    }
       
       if (usertype.equals("normal")){
       
       return new Normal(username, password, email,  usertype, userNormal,  name, subscribeType, address);
       
                                    }
       
       if (usertype.equals("guest")){
       
       return new Guest(username, password, email, usertype, userGuest, name, subscribeDate);
       
                                    }
       
       return null;
   
   }
}
