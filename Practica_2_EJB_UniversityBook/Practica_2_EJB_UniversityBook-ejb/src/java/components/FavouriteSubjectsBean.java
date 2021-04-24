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
    
    @PostConstruct
    public void init() {
        subjects = new HashSet<Subject>();
        try {      
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        allStatefulBean.addFavouriteSubjectBean(this);
    }

    @Override
    public void addFavouriteSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public HashSet<Subject> getFavouritesSubjects() {
        return subjects;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return this.user;
    }
    
    

    
}
