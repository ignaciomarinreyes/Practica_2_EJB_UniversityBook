package components;

import entities.DonationRecognition;
import entities.Post;
import entities.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.ejb.Remote;

@Remote
public interface PostUserBeanRemote {

    void addPost(String title, User user, LocalDateTime date, String content, String pathImage, int idSubject, String donation);

    void addDefaultMyPosts(User user);

    ArrayList<Post> getMyPosts();

    void remove();

    void setUser(User user);

    User getUser();

    void programPost(int miliseconds, String title, User user, LocalDateTime date, String content, String pathImage, int idSubject, String donation);

    void addPost(Post post);

    int recognizedDonation(LocalDateTime date);

    void calculateRecognitions();

    public void addDonationRecognition(DonationRecognition donationRecognition);

    int getDonationTotal();

}
