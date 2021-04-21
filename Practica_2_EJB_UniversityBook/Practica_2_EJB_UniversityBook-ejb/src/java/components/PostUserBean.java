/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import entities.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@Stateful
public class PostUserBean implements PostUserBeanRemote {

    private ArrayList<Post> myPosts;
    private PostBeanLocalLocal postBeanLocal;

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
        //postBean.addPost(post);
    }
    
    @Override
    public void addDefaultMyPosts(java.util.ArrayList<Post> posts) {
        myPosts.addAll(posts);
    }     
    
    @Override
    @Remove
    public void remove(){
        
    }
    
}
