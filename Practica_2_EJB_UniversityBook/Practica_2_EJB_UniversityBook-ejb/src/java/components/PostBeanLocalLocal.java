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
public interface PostBeanLocalLocal {

    void addPostUserBean(PostUserBean postUserBean);
    
    ArrayList<Post> getPostsFollowedSubjectByUser(User user);

    void addLikePost(User user, int idPost);
    
    java.util.ArrayList<Post> getPostsSubject(int idUniversity ,int idDegree,int idSubject);
    
    ArrayList<Post> getPosts();
    
    void removePostUserBean(PostUserBean postUserBean);
    
}
