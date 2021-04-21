/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import entities.Subject;
import entities.User;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@Singleton
public class PostBean implements PostBeanRemote {

    private ArrayList<Post> posts;
    private ArrayList<PostUserBean> postUserBeans;
    
    @PostConstruct
    public void init() {
        posts = new ArrayList<Post>();
        postUserBeans = new ArrayList<PostUserBean>();
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
    public java.util.ArrayList<Post> getPostsSubject(int idUniversity, int idDegree, int idSubject) {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for (Post post : posts) {
            if (post.getSubject().getId() == idSubject && post.getSubject().getDegree().getId() == idDegree && post.getSubject().getUniversity().getId() == idUniversity) {
                postsList.add(post);
            }
        }
        return postsList;
    }

    @Override
    public ArrayList<Post> getPostsFollowedSubjectByUser(User user) {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for (Post post : posts) {
            for (Subject subjectFollowed : user.getSubjects()) {
                if (post.getSubject().getId() == subjectFollowed.getId()) {
                    postsList.add(post);
                }
            }
        }
        return postsList;
    }

    @Override
    public void addLikePost(User user, int idPost) {
        System.out.println(user);
        System.out.println(user.hashCode());
        for (Post post : posts) {
            if (post.getId() == idPost) {
                post.addLike(user);
            }
        }
        
    }

    public void addPostUserBean(PostUserBean postUserBean){
        postUserBeans.add(postUserBean);
    }



}
