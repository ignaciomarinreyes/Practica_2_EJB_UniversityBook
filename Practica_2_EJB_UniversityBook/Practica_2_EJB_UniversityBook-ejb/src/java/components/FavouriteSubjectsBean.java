/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import data.Data;
import entities.Subject;
import entities.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ignacio
 */
@Stateful
public class FavouriteSubjectsBean implements FavouriteSubjectsBeanRemote {

    private HashSet<Subject> subjects;
    private AllStatefulBeanLocal allStatefulBean;
    private User user;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    
    @PostConstruct
    public void init() {
        subjects = new HashSet<Subject>();
        try {      
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("FavouriteSubjectsBean_" + this.hashCode());
        logBean.writeLogEJBInfo("FavouriteSubjectsBean_" + this.hashCode() + "::init::Llamada al PostConstruct");
        allStatefulBean.addFavouriteSubjectBean(this);
    }

    @Override
    public void addFavouriteSubject(Subject subject) {
        statisticBean.addMapNumberInvokeBean("FavouriteSubjectsBean_" + this.hashCode());
        logBean.writeLogEJBInfo("FavouriteSubjectsBean_" + this.hashCode() + "::addFavouriteSubject::Añade una asignatura favorita");
        subjects.add(subject);
    }

    @Override
    public HashSet<Subject> getFavouritesSubjects() {
        statisticBean.addMapNumberInvokeBean("FavouriteSubjectsBean_" + this.hashCode());
        logBean.writeLogEJBInfo("FavouriteSubjectsBean_" + this.hashCode() + "::getFavouritesSubjects::Obtienen las asignaturas favoritas");
        return subjects;
    }

    @Override
    public void setUser(User user) {
        statisticBean.addMapNumberInvokeBean("FavouriteSubjectsBean_" + this.hashCode());
        logBean.writeLogEJBInfo("FavouriteSubjectsBean_" + this.hashCode() + "::setUser::Establece un usuario");
        this.user = user;
    }

    @Override
    public User getUser() {
        statisticBean.addMapNumberInvokeBean("FavouriteSubjectsBean_" + this.hashCode());
        logBean.writeLogEJBInfo("FavouriteSubjectsBean_" + this.hashCode() + "::getUser::Obtiene un usuario");
        return this.user;
    }
    
    

    
}
