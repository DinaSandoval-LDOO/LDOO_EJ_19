
package servlet;


public class Factory {
    
    private static Factory instance = new Factory();
    
    private Factory(){}
    
    public static Factory getInstance(){
        
        return instance;
    }
    
    
    public User creatUser(String usertype){
   
       if ("admin".equals(usertype)){
       
       return new Administration();
       
                                    }
       
       if (usertype.equals("normal")){
       
       return new Normal();
       
                                    }
       
       if (usertype.equals("guest")){
       
       return new Guest();
       
                                    }
       
       return null;
   
   }
}
