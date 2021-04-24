/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Rol;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class UserRol implements UserRolRemote {

    @EJB
    private UserBeanRemote userBean;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    
    @PostConstruct
    public void init(){
        try {
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");            
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("UserRol");
        logBean.writeLogEJBInfo("UserRol::init::Llamada al PostConstruct");
    }
    
    
    @Override
    public java.util.List<User> getUsersByRol(Rol rol) {
        statisticBean.addMapNumberInvokeBean("UserRol");
        logBean.writeLogEJBInfo("UserRol::getUsersByRol::Obtiene el usuario según el rol");
        List<User> users = new ArrayList<User>();
        for(User user:userBean.getUsers()){
            if(user.getRol().equals(rol)) users.add(user);
        }
        return users;
    }

    
}
