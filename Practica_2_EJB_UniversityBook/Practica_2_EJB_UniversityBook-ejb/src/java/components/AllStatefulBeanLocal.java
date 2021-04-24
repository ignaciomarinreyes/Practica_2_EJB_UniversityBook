/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import entities.User;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ignacio
 */
@Local
public interface AllStatefulBeanLocal {

    void addPostUserBean(PostUserBean postUserBean);
    
    ArrayList<Post> getPostsFollowedSubjectByUser(User user);

    void addLikePost(User user, int idPost);
    
    java.util.ArrayList<Post> getPostsSubject(int idUniversity ,int idDegree,int idSubject);
    
    ArrayList<Post> getPosts();
    
    void removePostUserBean(PostUserBean postUserBean);

    public PostUserBean getPostUserBean(User user);

    void addFavouriteSubjectBean(FavouriteSubjectsBean subject);

    FavouriteSubjectsBean getFavouriteSubjectsBean(User user);

    void setTimer(int miliseconds, User user, Post post);
    
}
