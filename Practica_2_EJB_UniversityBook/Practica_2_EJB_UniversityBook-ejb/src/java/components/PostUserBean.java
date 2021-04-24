/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.Post;
import entities.User;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@Stateful
public class PostUserBean implements PostUserBeanRemote {

    private ArrayList<Post> myPosts;
    private AllStatefulBeanLocal allStatefulBean;
    private User user;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    @EJB
    private StudyBeanRemote studyBean;

    @PostConstruct
    public void init() {
        myPosts = new ArrayList<Post>();
        try {      
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        allStatefulBean.addPostUserBean(this);
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::init::Llamada al PostConstruct");
    }
      
    @Override
    public ArrayList<Post> getMyPosts() {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());     
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::getMyPosts::Obtiene mis posts");
        return myPosts;
    }

    @Override
    public void addPost(String title, User user, LocalDate date, String content, String pathImage, int idSubject) {  
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::addPost::Añade un post");      
        myPosts.add(new Post(title, user, date, content, pathImage, studyBean.getSubjectById(idSubject)));
    }
    
    @Override
    public void addDefaultMyPosts(User user) {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() +  "::addDefaultMyPosts::Añade mis post por defecto");
        myPosts.addAll(Data.getPostsOfUser(user));
    }  
  
    @Override
    @Remove
    public void remove(){
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() +  "::remove::Se borra el postUserBean");
        allStatefulBean.removePostUserBean(this);
    }
    
    @Override
    public void setUser(User user){
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::setUser::Establece el usuario");
        this.user = user;
    }
    
    @Override
    public User getUser(){
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::getUser::Obtiene el usuario");
        return user;
    }
    
}
