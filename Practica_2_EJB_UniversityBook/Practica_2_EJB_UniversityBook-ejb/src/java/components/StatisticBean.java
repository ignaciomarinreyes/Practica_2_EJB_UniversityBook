package components;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class StatisticBean implements StatisticBeanRemote {

    private SessionBeanRemote sessionBean;
    private int numberUserHasLogged;
    private HashMap<String,Integer> mapNumberInvokeBean;
    private StatisticBeanRemote statisticBean;
    private LogBeanRemote logBean;

    @PostConstruct
    public void init() {
        mapNumberInvokeBean = new HashMap<String,Integer>();
        try {
            sessionBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getNumberUserHasLogged() {       
        return numberUserHasLogged;
    }

    @Override
    public void increaseNumberUserHasLogged() {
        numberUserHasLogged++;
    }

    @Override
    public int getNumberUserLoggedNow() {
        return sessionBean.getNumberUserLoggedNow();
    }

    @Override
    public void addMapNumberInvokeBean(String key) {
        mapNumberInvokeBean.put(key, mapNumberInvokeBean.containsKey(key) ? mapNumberInvokeBean.get(key) + 1 : 1);    
    }  

    @Override
    public java.util.HashMap<String, Integer> getMapNumberInvokeBean() {
        return mapNumberInvokeBean;
    }
    
    

}
