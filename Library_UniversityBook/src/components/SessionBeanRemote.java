package components;

import entities.User;
import javax.ejb.Remote;

@Remote
public interface SessionBeanRemote {

    User login(String nickName, String password);

    int getNumberUserLoggedNow();

    void remove(User user);

}
