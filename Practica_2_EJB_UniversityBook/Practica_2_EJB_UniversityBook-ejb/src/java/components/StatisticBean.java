package components;

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

    @PostConstruct
    public void init() {
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

}
