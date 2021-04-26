package components;

import entities.Rol;
import entities.User;
import javax.ejb.Remote;

@Remote
public interface UserRolRemote {

    java.util.List<User> getUsersByRol(Rol rol);

}
