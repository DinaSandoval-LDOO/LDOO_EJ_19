
package user;

public class User {
    
    private String name;
    private String userid;
    private String useridkey;

    public User(String name, String userid, String useridkey){
    this.name = name;
    this.userid = userid;
    this.useridkey = useridkey;
    
    }
   
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

   
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

   
    public String getUseridkey() {
        return useridkey;
    }

    public void setUseridkey(String useridkey) {
        this.useridkey = useridkey;
    }
   
    
}
