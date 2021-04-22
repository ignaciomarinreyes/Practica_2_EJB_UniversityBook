package controller.commands;

import components.PostBeanLocalLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsSubject extends FrontCommand {
    
    private PostBeanLocalLocal postBean;
    
    @Override
    public void process() {
        try {
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBeanLocal!components.PostBeanLocalLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostBySubject", postBean.getPostsSubject(Integer.parseInt(request.getParameter("universities")), Integer.parseInt(request.getParameter("degrees")), Integer.parseInt(request.getParameter("subjects"))));
        forward("/ShowPostsSubject.jsp");
    }

}
