/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class SessionBean implements SessionBeanRemote {

    private ArrayList<User> usersLogged;
    private UserBeanRemote userBean;
    
    @PostConstruct
    public void init(){
        try {
            userBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/UserBean!components.UserBeanRemote");
            usersLogged = new ArrayList<User>();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public User login(String nickName, String password) {   
        User user = userBean.getUser(nickName, password);
        System.out.println("LoginBean::login:: Inicia " +  user.getName() + " " + user.getSurname() + " sesión en la aplicación");
        if (user != null){
            usersLogged.add(user);
            return user;
        } else{
            return null;
        }
    }
    
}
