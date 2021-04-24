/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Subject;
import entities.User;
import java.util.HashSet;
import javax.ejb.Remote;

/**
 *
 * @author ignacio
 */
@Remote
public interface FavouriteSubjectsBeanRemote {

    void addFavouriteSubject(Subject subject);

    HashSet<Subject> getFavouritesSubjects();

    void setUser(User user);

    User getUser();

    void remove();
    
}
