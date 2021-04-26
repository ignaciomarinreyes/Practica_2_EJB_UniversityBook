package components;

import entities.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class SessionBean implements SessionBeanRemote {

    private ArrayList<User> usersLogged;
    private UserBeanRemote userBean;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;

    @PostConstruct
    public void init() {
        try {
            userBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/UserBean!components.UserBeanRemote");
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");
            usersLogged = new ArrayList<User>();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("SessionBean");
        logBean.writeLogEJBInfo("SessionBean::init::Llamada al PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        statisticBean.addMapNumberInvokeBean("SessionBean");
        logBean.writeLogEJBInfo("SessionBean::destroy::Llamada al PreDestroy");
    }

    @Override
    public User login(String nickName, String password) {
        statisticBean.addMapNumberInvokeBean("SessionBean");
        logBean.writeLogEJBInfo("SessionBean::login::Inicia sesión un usuario");
        User user = userBean.getUser(nickName, password);
        if (user != null) {
            usersLogged.add(user);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public int getNumberUserLoggedNow() {
        statisticBean.addMapNumberInvokeBean("SessionBean");
        logBean.writeLogEJBInfo("SessionBean::getNumberUserLoggedNow::Obtiene el número de usuarios loggeados actualmente");
        return usersLogged.size();
    }

    @Override
    public void remove(User user) {
        statisticBean.addMapNumberInvokeBean("SessionBean");
        logBean.writeLogEJBInfo("SessionBean::remove::Borra un usuario del SessionBean");
        for (int i = 0; i < usersLogged.size(); i++) {
            if (usersLogged.get(i).getId() == user.getId()) {
                usersLogged.remove(i);
            }
        }
    }

}
