package controller.commands;

import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import components.AllStatefulBeanLocal;

public class ShowPostsFollowedSubject extends FrontCommand {

    private AllStatefulBeanLocal allStatefulBeanLocal;

    @Override
    public void process() {
        try {
            allStatefulBeanLocal = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostsFollowedSubjectsByUser", allStatefulBeanLocal.getPostsFollowedSubjectByUser((User) request.getSession().getAttribute("user")));
        forward("/MainFrame.jsp");
    }

}
