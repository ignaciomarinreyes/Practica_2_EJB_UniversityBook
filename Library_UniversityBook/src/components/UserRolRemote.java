/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Rol;
import entities.User;
import javax.ejb.Remote;

/**
 *
 * @author ignacio
 */
@Remote
public interface UserRolRemote {

    java.util.List<User> getUsersByRol(Rol rol);
    
}
