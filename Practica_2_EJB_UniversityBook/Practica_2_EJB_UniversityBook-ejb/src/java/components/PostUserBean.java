/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.DonationRecognition;
import entities.Post;
import entities.Subject;
import entities.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TimerService;
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
    private List<DonationRecognition> donationRecognitions;
    private int donationTotal;

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
        donationRecognitions = new ArrayList<DonationRecognition>();
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
    public void addPost(String title, User user, LocalDate date, String content, String pathImage, int idSubject, String donation) {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::addPost::Añade un post");
        myPosts.add(chooseDonationPost(title, user, date, content, pathImage, studyBean.getSubjectById(idSubject), donation));
    }

    @Override
    public void addDefaultMyPosts(User user) {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::addDefaultMyPosts::Añade mis post por defecto");
        myPosts.addAll(Data.getPostsOfUser(user));
    }

    @Override
    @Remove
    public void remove() {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::remove::Se borra el postUserBean");
    }

    @Override
    public void setUser(User user) {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::setUser::Establece el usuario");
        this.user = user;
    }

    @Override
    public User getUser() {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::getUser::Obtiene el usuario");
        return user;
    }

    @Override
    public void programPost(int miliseconds, String title, User user, LocalDate date, String content, String pathImage, int idSubject, String donation) {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::programPost::Se programa un post");
        allStatefulBean.setTimer(miliseconds, user, chooseDonationPost(title, user, date, content, pathImage, studyBean.getSubjectById(idSubject), donation));
    }

    @Override
    public void addPost(Post post) {
        statisticBean.addMapNumberInvokeBean("PostUserBean_" + this.hashCode());
        logBean.writeLogEJBInfo("PostUserBean_" + this.hashCode() + "::addPost::Añade un post programado");
        myPosts.add(post);
    }

    @Override
    public int recognizedDonation(LocalDateTime date) {
        int result = 0;
        Iterator it = donationRecognitions.iterator();
        while (it.hasNext()) {
            DonationRecognition r = (DonationRecognition) it.next();
            if (r.isRecognizableBy(date)) {
                result += r.getDonation();
            }
        }
        donationTotal = result;
        return result;
    }
    
    

    @Override
    public void calculateRecognitions() {
        for (Post post : myPosts) {
            post.calculateRecognitions(this);
        }
    }

    @Override
    public void addDonationRecognition(DonationRecognition donationRecognition) {
        donationRecognitions.add(donationRecognition);
    }

    private Post chooseDonationPost(String title, User user, LocalDate date, String content, String pathImage, Subject subject, String donation) {
        switch (donation) {
            case "No donar":
                return Post.newFreeDonationPost(title, user, date, content, pathImage, subject);
            case "Donar mensualmente durante 12 meses":
                return Post.newMontlhlyDonationForAYear(title, user, date, content, pathImage, subject);
            case "Donar ahora":
                return Post.newNowDonation(title, user, date, content, pathImage, subject);             
            case "Donar trimestralmente durante 12 meses":
                return Post.newQuarterlyDonationForAYear(title, user, date, content, pathImage, subject);
            default:
                return null;
        }
    }

    @Override
    public int getDonationTotal() {
        return donationTotal;
    }
}
