/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.Post;
import entities.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@Stateful
public class PostUserBean implements PostUserBeanRemote {

    private ArrayList<Post> myPosts;
    private PostBeanLocalLocal postBeanLocal;
    private User user;

    @PostConstruct
    public void init() {
        myPosts = new ArrayList<Post>();
        try {      
            postBeanLocal = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBeanLocal!components.PostBeanLocalLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        postBeanLocal.addPostUserBean(this);
    }
      
    @Override
    public ArrayList<Post> getMyPosts() {
        return myPosts;
    }

    @Override
    public void addPost(Post post) {  
        myPosts.add(post);
    }
    
    @Override
    public void addDefaultMyPosts(User user) {
        myPosts.addAll(Data.getPostsOfUser(user));
    }  
  
    @Override
    @Remove
    public void remove(){
        postBeanLocal.removePostUserBean(this);
    }
    
    @Override
    public void setUser(User user){
        this.user = user;
    }
    
    @Override
    public User getUser(){
        return user;
    }
    
}
