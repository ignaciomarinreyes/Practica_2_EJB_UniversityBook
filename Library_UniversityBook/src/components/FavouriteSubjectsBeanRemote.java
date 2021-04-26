package components;

import entities.Subject;
import entities.User;
import java.util.HashSet;
import javax.ejb.Remote;

@Remote
public interface FavouriteSubjectsBeanRemote {

    void addFavouriteSubject(Subject subject);

    HashSet<Subject> getFavouritesSubjects();

    void setUser(User user);

    User getUser();

    void remove();

}
