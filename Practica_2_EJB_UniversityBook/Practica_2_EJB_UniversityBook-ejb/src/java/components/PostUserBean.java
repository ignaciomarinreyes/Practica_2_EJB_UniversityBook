/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import entities.Subject;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author ignacio
 */
@Stateful
public class PostUserBean implements PostUserBeanRemote {

    private ArrayList<Post> postsFollowedSubject;
    private ArrayList<Subject> followedSubjects;
    private ArrayList<Post> myPosts;

    @PostConstruct
    public void init() {
        postsFollowedSubject = new ArrayList<Post>();
        followedSubjects = new ArrayList<Subject>();
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
    public void addPost(Post post) {  
        myPosts.add(post);
        for(Subject subjectFollowed :followedSubjects){
            if(subjectFollowed.getId() == post.getSubject().getId()) postsFollowedSubject.add(post);
        }       
    }

    @Override
    public void addDefaultPostsFollowedSubject(java.util.ArrayList<Post> posts) {
        postsFollowedSubject.addAll(posts);
    }
    
    @Override
    public void addDefaultMyPosts(java.util.ArrayList<Post> posts) {
        myPosts.addAll(posts);
    }     

    @Override
    public void addDefaultSubjectsFollowed(java.util.ArrayList<Subject> subjects) {
        followedSubjects.addAll(subjects);
    }
    
    @Override
    @Remove
    public void remove(){
        
    }
    
}
