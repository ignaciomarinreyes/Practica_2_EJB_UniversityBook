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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class AllStatefulBean implements AllStatefulBeanLocal {

    private ArrayList<PostUserBean> postUserBeans;
    private ArrayList<FavouriteSubjectsBean> favouriteSubjects;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    @Resource
    TimerService timerPublishPost;
    private PostUserBean postUserBeanChoosen;
    private Post programmedPost;

    @PostConstruct
    public void init() {
        try {
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::init::Llamada al PostConstruct");
        postUserBeans = new ArrayList<PostUserBean>();
        favouriteSubjects = new ArrayList<FavouriteSubjectsBean>();
        Data.loadDefaultData();
    }

    @Override
    public void setTimer(int miliseconds, User user, Post post) {
        programmedPost = post;
        for (PostUserBean postUserBean : postUserBeans) {
            if (postUserBean.getUser().getId() == user.getId()) {
                postUserBeanChoosen = postUserBean;
                break;
            }
        }
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::setTimer::Se establece la cuenta atrás del post programado");
        timerPublishPost.createSingleActionTimer(miliseconds, new TimerConfig());
    }

    @Timeout
    public void timeout(Timer t) {
        postUserBeanChoosen.addPost(programmedPost);
    }

    @Override
    public void addPostUserBean(PostUserBean postUserBean) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::addPostUserBean::Añade un postUserBean");
        postUserBeans.add(postUserBean);
    }

    @Override
    public void removePostUserBean(PostUserBean postUserBean) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::removePostUserBean::Borra un PostUserBean");
        postUserBeans.remove(postUserBean);
    }

    @Override
    public ArrayList<Post> getPostsFollowedSubjectByUser(User user) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getPostsFollowedSubjectByUser::Obtiene todos los post de asignaturas seguidas por un usuario");
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
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::addLikePost::Añade Like a un post");
        for (Post post : getPosts()) {
            if (post.getId() == idPost) {
                post.addLike(user);
            }
        }

    }

    @Override
    public java.util.ArrayList<Post> getPostsSubject(int idUniversity, int idDegree, int idSubject) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getPostsSubject::Obtiene todos los post de una asignatura");
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
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getPosts::Obtiene todos los post de la aplicación");
        ArrayList<Post> postsList = new ArrayList<Post>();
        for (PostUserBean postUserBean : postUserBeans) {
            postsList.addAll(postUserBean.getMyPosts());
        }
        return postsList;
    }

    @Override
    public PostUserBean getPostUserBean(User user) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getPostUserBean::Obtiene el PosUserBean de un usuario");
        for (PostUserBean postUserBean : postUserBeans) {
            if (postUserBean.getUser().getId() == user.getId()) {
                return postUserBean;
            }
        }
        return null;
    }

    @Override
    public void addFavouriteSubjectBean(FavouriteSubjectsBean favouriteSubjectsBean) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::addFavouriteSubjectBean::Añade una asignatura favorita al favouriteSubjectBean de un usuario");
        favouriteSubjects.add(favouriteSubjectsBean);
    }

    @Override
    public FavouriteSubjectsBean getFavouriteSubjectsBean(User user) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getFavouriteSubjectsBean::Obtiene el favouriteSubjectBean de un usuario");
        for (FavouriteSubjectsBean favouriteSubjectsBean : favouriteSubjects) {
            if (favouriteSubjectsBean.getUser().getId() == user.getId()) {
                return favouriteSubjectsBean;
            }
        }
        return null;
    }

    @Override
    public java.util.List<PostUserBean> getAllPostUserBean() {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getAllPostUserBean::Obtiene todos los postUserBean");
        return postUserBeans;
    }

    @Override
    public java.util.List<FavouriteSubjectsBean> getAllFavouriteSubjectsBean() {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::getAllFavouriteSubjectsBean::Obtiene todos los favouriteSubjectBean");
        return favouriteSubjects;
    }

    @Override
    public String removeStateful(int hashCode) {
        statisticBean.addMapNumberInvokeBean("AllStatefulBean");
        logBean.writeLogEJBInfo("AllStatefulBean::removeStateful::Borra un stateful");
        String atributteDelete = "";
        FavouriteSubjectsBean favouriteSubjectsBeanDelete = null;
        PostUserBean postUserBeanDelete = null;
        for (FavouriteSubjectsBean favouriteSubjectsBean : favouriteSubjects) {
            if (favouriteSubjectsBean.hashCode() == hashCode) {
                atributteDelete = "favouriteSubjectsBean" + favouriteSubjectsBean.getUser().getId();
                favouriteSubjectsBeanDelete = favouriteSubjectsBean;
            }
        }
        for (PostUserBean postUserBean : postUserBeans) {
            if (postUserBean.hashCode() == hashCode) {
                atributteDelete = "postUserBean" + postUserBean.getUser().getId();
                postUserBeanDelete = postUserBean;
            }
        }
        if (favouriteSubjectsBeanDelete != null) {
            favouriteSubjects.remove(favouriteSubjectsBeanDelete);
            favouriteSubjectsBeanDelete.remove();
        }
        if (postUserBeanDelete != null) {
            postUserBeans.remove(postUserBeanDelete);
            postUserBeanDelete.remove();
        }
        return atributteDelete;
    }
    
    @Schedule(second="*/5", minute="*", hour="*")
    public void updateDonationTotalPostUserBean(){
        System.out.println("updateDonation");
        for(PostUserBean postUserBean: postUserBeans){
            postUserBean.recognizedDonation(LocalDateTime.now());
        }
    }
    
}
