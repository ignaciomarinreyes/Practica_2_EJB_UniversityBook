package controller.commands;

import components.PostBeanLocalLocal;
import components.PostUserBeanRemote;
import components.SessionBeanRemote;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Login extends FrontCommand {

    SessionBeanRemote sessionBeanRemote;
    PostBeanLocalLocal postBean;
    PostUserBeanRemote postUserBean;

    @Override
    public void process() {
        try {
            sessionBeanRemote = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBeanLocal!components.PostBeanLocalLocal");
            postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean");
            if ((User) request.getSession().getAttribute("user") == null) {
                User user = sessionBeanRemote.login(request.getParameter("nickname"), request.getParameter("password"));
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    if(postUserBean == null){
                        postUserBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostUserBean!components.PostUserBeanRemote");
                        request.getSession().setAttribute("postUserBean", postUserBean);
                        postUserBean.addDefaultMyPosts(user);
                    }                                    
                    request.setAttribute("PostsFollowedSubjectsByUser", postBean.getPostsFollowedSubjectByUser(user));
                    forward("/MainFrame.jsp");
                } else {
                    forward("/index.jsp");
                }
            } else {
                request.setAttribute("PostsFollowedSubjectsByUser", postBean.getPostsFollowedSubjectByUser((User) request.getSession().getAttribute("user")));
                forward("/MainFrame.jsp");
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

}
