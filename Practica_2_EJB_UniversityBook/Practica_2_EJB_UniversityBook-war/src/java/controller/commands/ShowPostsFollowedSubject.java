package controller.commands;

import components.PostBeanRemote;
import entities.User;
import data.dao.PostDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsFollowedSubject extends FrontCommand {

    private PostBeanRemote postBean;
    
    @Override
    public void process() {
        try {
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBean!components.PostBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostsFollowedSubjectsByUser", postBean.getPostsFollowedSubjectByUser((User) request.getSession().getAttribute("user")));
        forward("/MainFrame.jsp");
    }

}
