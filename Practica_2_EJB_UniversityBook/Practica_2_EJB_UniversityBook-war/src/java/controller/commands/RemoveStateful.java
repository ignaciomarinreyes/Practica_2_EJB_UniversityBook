package controller.commands;

import components.AllStatefulBeanLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoveStateful extends FrontCommand {

    private AllStatefulBeanLocal allStatefulBean;

    @Override
    public void process() {
        try {
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        String attributeDelete = allStatefulBean.removeStateful(Integer.parseInt((String) request.getParameter("hashCode")));
        request.getSession().setAttribute(attributeDelete, null);
        forward("/OperationSuccesful.jsp");
    }

}
