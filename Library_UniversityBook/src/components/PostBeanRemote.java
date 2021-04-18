/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import entities.Subject;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author ignacio
 */
@Remote
public interface PostBeanRemote {

    void addPost(Post post);

    ArrayList<Post> getPosts();

    void addDefaultPosts(java.util.ArrayList<Post> posts);

    java.util.ArrayList<Post> getPostsSubject(int idUniversity ,int idDegree,int idSubject);
    
}
