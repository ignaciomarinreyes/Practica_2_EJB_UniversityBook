
package components;

import data.Data;
import entities.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class UserBean implements UserBeanRemote {
    private ArrayList<User> users;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;
    
    @PostConstruct
    public void init(){
        users = new ArrayList<User>();
        users.addAll(Data.getUsers());
        try {
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");            
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        statisticBean.addMapNumberInvokeBean("UserBean");
        logBean.writeLogEJBInfo("UserBean::init::Llamada al PostConstruct");        
    }

    @Override
    public User getUser(String nickName, String password) {
        statisticBean.addMapNumberInvokeBean("UserBean");
        logBean.writeLogEJBInfo("UserBean::getUser::Obtiene el usuario según apodo y contraseña"); 
        for(User user: users){
            if(user.getNickname().equals(nickName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        statisticBean.addMapNumberInvokeBean("UserBean");
        logBean.writeLogEJBInfo("UserBean::getUser::Obtiene el usuario"); 
        return users;
    }
    
}
