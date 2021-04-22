/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.User;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author ignacio
 */
@Remote
public interface UserBeanRemote {

    User getUser(String nickName, String password);

    ArrayList<User> getUsers();
    
}
