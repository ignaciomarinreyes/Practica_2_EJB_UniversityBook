package controller.commands;

import components.AllStatefulBeanLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowStatefulBean extends FrontCommand {

    private AllStatefulBeanLocal allStatefulBean;

    @Override
    public void process() {
        try {
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("allStatefulBean", allStatefulBean);
        forward("/ShowStatefulBean.jsp");
    }

}
