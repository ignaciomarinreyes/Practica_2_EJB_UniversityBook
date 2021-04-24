/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.Post;
import entities.Subject;
import entities.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class AllStatefulBean implements AllStatefulBeanLocal {

    private ArrayList<PostUserBean> postUserBeans;
    private ArrayList<FavouriteSubjectsBean> favouriteSubjects;

    @PostConstruct
    public void init() {
        postUserBeans = new ArrayList<PostUserBean>();
        favouriteSubjects = new ArrayList<FavouriteSubjectsBean>();
        Data.loadDefaultData();
    }

    @Override
    public void addPostUserBean(PostUserBean postUserBean) {
        postUserBeans.add(postUserBean);
    }

    @Override
    public void removePostUserBean(PostUserBean postUserBean) {
        postUserBeans.remove(postUserBean);
    }

    @Override
    public ArrayList<Post> getPostsFollowedSubjectByUser(User user) {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for (Post post : getPosts()) {
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
        for (Post post : getPosts()) {
            if (post.getId() == idPost) {
                post.addLike(user);
            }
        }

    }

    @Override
    public java.util.ArrayList<Post> getPostsSubject(int idUniversity, int idDegree, int idSubject) {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for (Post post : getPosts()) {
            if (post.getSubject().getId() == idSubject && post.getSubject().getDegree().getId() == idDegree && post.getSubject().getUniversity().getId() == idUniversity) {
                postsList.add(post);
            }
        }
        return postsList;
    }

    @Override
    public ArrayList<Post> getPosts() {
        ArrayList<Post> postsList = new ArrayList<Post>();
        for (PostUserBean postUserBean : postUserBeans) {
            postsList.addAll(postUserBean.getMyPosts());
        }
        return postsList;
    }

    @Override
    public PostUserBean getPostUserBean(User user) {
        for (PostUserBean postUserBean : postUserBeans) {
            if (postUserBean.getUser().getId() == user.getId()) {
                return postUserBean;
            }
        }
        return null;
    }

    @Override
    public void addFavouriteSubjectBean(FavouriteSubjectsBean favouriteSubjectsBean) {
        favouriteSubjects.add(favouriteSubjectsBean);
    }

    @Override
    public FavouriteSubjectsBean getFavouriteSubjectsBean(User user) {
        for (FavouriteSubjectsBean favouriteSubjectsBean : favouriteSubjects) {
            if (favouriteSubjectsBean.getUser().getId() == user.getId()) {
                return favouriteSubjectsBean;
            }
        }
        return null;
    }

}
