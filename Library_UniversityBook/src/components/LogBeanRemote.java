package components;

import javax.ejb.Remote;

@Remote
public interface LogBeanRemote {

    void writeLogEJBInfo(String mensaje);

    String getLogEJB();

}
