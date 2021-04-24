package controller.commands;

import components.PostUserBean;
import components.PostUserBeanRemote;
import components.SessionBeanRemote;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import components.AllStatefulBeanLocal;

public class Login extends FrontCommand {

    SessionBeanRemote sessionBeanRemote;
    AllStatefulBeanLocal allStatefulBean;
    PostUserBeanRemote postUserBean;

    @Override
    public void process() {
        try {
            sessionBeanRemote = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
            allStatefulBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
            if ((User) request.getSession().getAttribute("user") == null) {
                User user = sessionBeanRemote.login(request.getParameter("nickname"), request.getParameter("password"));
                postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean" + user.getId());
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    if(postUserBean == null){
                        PostUserBean postUserBeanOfArray = allStatefulBean.getPostUserBean(user);
                        if(postUserBeanOfArray != null){
                            postUserBean = postUserBeanOfArray;
                        } else {
                            postUserBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostUserBean!components.PostUserBeanRemote");
                            postUserBean.setUser(user);
                        }                      
                        request.getSession().setAttribute("postUserBean" + user.getId(), postUserBean);
                        postUserBean.addDefaultMyPosts(user);
                    }                                    
                    request.setAttribute("PostsFollowedSubjectsByUser", allStatefulBean.getPostsFollowedSubjectByUser(user));
                    forward("/MainFrame.jsp");
                } else {
                    forward("/index.jsp");
                }
            } else {
                request.setAttribute("PostsFollowedSubjectsByUser", allStatefulBean.getPostsFollowedSubjectByUser((User) request.getSession().getAttribute("user")));
                forward("/MainFrame.jsp");
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

}
