import java.util.ArrayList;

public class Users {

    ArrayList<User> users;
    int id;

    public Users(){
        users = new ArrayList<>();
        id = 0;
    }

    public Users(ArrayList<User> u){
        users = u;
        id = u.size();
    }

    public boolean addUser(String u, String p){
        boolean exist = false;
        for(int i = 0; i < id; i++){
            if(users.get(i).getUsername().equals(u)){
                exist = true;
            }
        }
        if(!exist){
            id++;
            User user = new User(id, u, p);
            users.add(user);
            return true;
        } else {
            return false;
        }

    }

    public boolean addAdmin(String u, String p){
        boolean exist = false;
        for(int i = 0; i < id; i++){
            if(users.get(i).getUsername().equals(u)){
                exist = true;
            }
        }
        if(!exist){
            id++;
            User user = new User(id, u, p, true);
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public int howManyUsers(){
        return id;
    }

    public User login(String u, String p){
        for (int i = 0; i < id; i++){
            User temp = users.get(i).login(u, p);
            if(temp != null){
                return temp;
            }
        }
        return null;
    }

    public User getUser(int i){
        if(i >=0 && i < id){
            return users.get(i);
        }
        return null;
    }

    public boolean changeUsername(int i, String u){
        if(i >= 0 && i < id){
            boolean exist = false;
            for(int a = 0; a < id; a++){
                if(users.get(i).getUsername().equals(u)){
                    exist = true;
                }
            }
            if(!exist){
                users.get(i).setUsername(u);
                return true;
            }
        }
        return false;
    }

    public void changePassword(int i, String p){
        users.get(i).setPassword(p);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        id = users.size();
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o== null || getClass() != o.getClass()){
            return false;
        }
        Users u = (Users) o;
        return id == u.howManyUsers() && users.equals(u.getUsers());
    }
}
