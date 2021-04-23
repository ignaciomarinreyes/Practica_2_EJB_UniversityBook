/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Rol;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserRol implements UserRolRemote {

    @EJB
    private UserBeanRemote userBean; 
    
    @Override
    public java.util.List<User> getUsersByRol(Rol rol) {
        List<User> users = new ArrayList<User>();
        for(User user:userBean.getUsers()){
            if(user.getRol().equals(rol)) users.add(user);
        }
        return users;
    }

    
}
