/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import entities.Subject;
import entities.User;
import java.util.ArrayList;
import javax.ejb.Remote;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@Remote
public interface PostUserBeanRemote {

    void addPost(Post post);

    void addDefaultMyPosts(java.util.ArrayList<Post> posts);

    ArrayList<Post> getMyPosts();
    
    void remove();
    
}
