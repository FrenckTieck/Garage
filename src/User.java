import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class User {

    int id;
    String username;
    Boolean admin;
    Boolean approved;
    private Encryption password;

    public User(int i, String u, String p) {
        id = i;
        username = u;
        password = new Encryption(p);
        admin = false;
        approved = false;
    }

    public User(int i, String u, String p, Boolean a){
        id = i;
        username = u;
        password = new Encryption(p);
        admin = a;
        approved = true;
    }

    public Boolean getApproved() {
        return approved;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Encryption getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdmin() {
        this.admin = true;
    }

    public void approve() {
        this.approved = true;
    }

    public void deAdmin(){
        this.admin = false;
    }

    public void deapprove(){
        this.approved = false;
    }

    public void setPassword(String p) {
        password.setText(p);
    }

    public User login(String u, String p){
        if(username.equals(u)){
            if(password.decrypt().equals(p)){
                return this;
            }
        }
        return null;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o== null || getClass() != o.getClass()){
            return false;
        }
        User u = (User) o;
        return id == u.getId() && username.equals(u.getUsername()) && admin == u.getAdmin() && approved == u.getApproved() && password.decrypt().equals(u.getPassword().decrypt());
    }
}
