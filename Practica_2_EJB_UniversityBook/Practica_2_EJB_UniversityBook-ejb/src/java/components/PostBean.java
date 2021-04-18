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
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author ignacio
 */
@Singleton
public class PostBean implements PostBeanRemote {
    
    private ArrayList<Post> posts;
   
    @PostConstruct
    public void init() {
        posts = new ArrayList<Post>();
    }
    
    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public ArrayList<Post> getPosts() {
        return posts;
    }

    @Override
    public void addDefaultPosts(java.util.ArrayList<Post> posts) {
        this.posts.addAll(posts);
    }

    @Override
    public java.util.ArrayList<Post> getPostsSubject(int idUniversity ,int idDegree,int idSubject) {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for(Post post: posts){
            if(post.getSubject().getId() == idSubject && post.getSubject().getDegree().getId() == idDegree && post.getSubject().getUniversity().getId() == idUniversity){
                postsList.add(post);
            }
        }
        return postsList;
    }

    @Override
    public ArrayList<Post> getPostsFollowedSubjectByUser(User user) {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for(Post post: posts){
            for(Subject subjectFollowed: user.getSubjects()){
                if(post.getSubject().getId() == subjectFollowed.getId()){
                    postsList.add(post);
                }
            }
        }
        return postsList;
    }
    
    
    
}
