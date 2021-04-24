package controller.commands;

import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import components.AllStatefulBeanLocal;

public class GiveLike extends FrontCommand {

    private AllStatefulBeanLocal allStatefulBean;
    
    @Override
    public void process() {
        try {
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        int idPost = Integer.valueOf(request.getParameter("idPost"));
        allStatefulBean.addLikePost((User) request.getSession().getAttribute("user"), idPost);
        forward("/Like.jsp");
    }
}
