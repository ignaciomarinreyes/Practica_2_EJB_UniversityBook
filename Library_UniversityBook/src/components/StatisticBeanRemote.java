package components;

import javax.ejb.Remote;

@Remote
public interface StatisticBeanRemote {

    int getNumberUserHasLogged();

    void increaseNumberUserHasLogged();

    int getNumberUserLoggedNow();

    void addMapNumberInvokeBean(String key);

    java.util.HashMap<String, Integer> getMapNumberInvokeBean();

}
