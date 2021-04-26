package components;

import entities.User;
import java.util.ArrayList;
import javax.ejb.Remote;

@Remote
public interface UserBeanRemote {

    User getUser(String nickName, String password);

    ArrayList<User> getUsers();

}
