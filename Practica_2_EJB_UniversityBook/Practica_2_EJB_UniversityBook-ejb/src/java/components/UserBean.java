
package components;

import data.Data;
import entities.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class UserBean implements UserBeanRemote {
    private ArrayList<User> users;
    
    @PostConstruct
    public void init(){
        users = new ArrayList<User>();
        users.addAll(Data.getUsers());
    }

    @Override
    public User getUser(String nickName, String password) {
        for(User user: users){
            if(user.getNickname().equals(nickName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }
    
}
