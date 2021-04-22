package controller.commands;


import components.PostBeanLocalLocal;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsFollowedSubject extends FrontCommand {

    private PostBeanLocalLocal postBean;
    
    @Override
    public void process() {
        try {
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBeanLocal!components.PostBeanLocalLocal");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostsFollowedSubjectsByUser", postBean.getPostsFollowedSubjectByUser((User) request.getSession().getAttribute("user")));
        forward("/MainFrame.jsp");
    }

}
