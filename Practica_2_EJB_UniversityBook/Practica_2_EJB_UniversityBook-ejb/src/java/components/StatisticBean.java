package components;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class StatisticBean implements StatisticBeanRemote {

    private SessionBeanRemote sessionBean;
    private int numberUserHasLogged;
    private HashMap<String, Integer> mapNumberInvokeBean;

    @PostConstruct
    public void init() {
        mapNumberInvokeBean = new HashMap<String, Integer>();
        try {
            sessionBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
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
