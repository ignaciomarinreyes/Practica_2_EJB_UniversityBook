package controller.commands;

import components.LogBeanRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowLogEJB extends FrontCommand {

    private LogBeanRemote logBean;

    @Override
    public void process() {
        try {
            logBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/LogBean!components.LogBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("logEJB", logBean.getLogEJB());
        forward("/ShowLogEJB.jsp");
    }

}
