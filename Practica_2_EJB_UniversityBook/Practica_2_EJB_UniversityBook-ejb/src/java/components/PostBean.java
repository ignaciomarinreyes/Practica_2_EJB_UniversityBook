/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import java.util.ArrayList;
import javax.ejb.Singleton;

/**
 *
 * @author ignacio
 */
@Singleton
public class PostBean implements PostBeanRemote {
    
    private ArrayList<Post> posts;

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
        posts.addAll(posts);
    }
}
