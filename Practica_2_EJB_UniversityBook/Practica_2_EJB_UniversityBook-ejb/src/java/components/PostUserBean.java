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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@Stateful
public class PostUserBean implements PostUserBeanRemote {

    private ArrayList<Post> postsFollowedSubject;
    private ArrayList<Post> myPosts;

    @PostConstruct
    public void init() {
        postsFollowedSubject = new ArrayList<Post>();
        myPosts = new ArrayList<Post>();
    }

    @Override
    public java.util.ArrayList<Post> getPostsFollowedSubject() {
       return postsFollowedSubject;
    }
      
    @Override
    public ArrayList<Post> getMyPosts() {
        return myPosts;
    }

    @Override
    public void addPostFollowedSubject(Post post) {
        postsFollowedSubject.add(post);
    }

    @Override
    public void addDefaultPostsFollowedSubject(java.util.ArrayList<Post> posts) {
        postsFollowedSubject.addAll(posts);
    }

    @Override
    public void addDefaultMyPosts(java.util.ArrayList<Post> posts) {
        myPosts.addAll(posts);
    }     
    
}
