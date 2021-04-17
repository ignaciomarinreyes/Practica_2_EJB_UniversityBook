package controller.commands;


import components.PostBeanRemote;
import components.PostUserBeanRemote;
import components.SessionBeanRemote;
import components.UserBeanRemote;
import data.Data;
import entities.Post;
import entities.User;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Login extends FrontCommand {

    SessionBeanRemote sessionBeanRemote;
    UserBeanRemote userBean;
    PostBeanRemote postBean;
    PostUserBeanRemote postUserBean;
    
    @Override
    public void process() { 
        try {
            //dataBeanRemote = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/DataBean!components.DataBeanRemote");
            //dataBeanRemote.loadDefaultValues();
            sessionBeanRemote = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
            loadDefaulValues();       
            User user = sessionBeanRemote.login(request.getParameter("nickname"), request.getParameter("password"));
            if(user != null){
                request.getSession().setAttribute("user", user);
                postUserBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostUserBean!components.PostUserBeanRemote");
                loadDefaultValuesUser(user);
                request.setAttribute("PostsFollowedSubjectsByUser", postUserBean.getPostsFollowedSubject());
                forward("/MainFrame.jsp");
            } else {
                forward("/index.jsp");
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    private void loadDefaulValues() throws NamingException {
        userBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/UserBean!components.UserBeanRemote");
        postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBean!components.PostBeanRemote");
        if(userBean.getUsers().size() == 0){
            Data.loadDefaultData();
            userBean.addDefaultUsers((ArrayList<User>) Data.getUsers());
            postBean.addDefaultPosts((ArrayList<Post>) Data.getPosts());
        }      
    }

    private void loadDefaultValuesUser(User user) {
        postUserBean.addDefaultPostsFollowedSubject(Data.getPostsOfUser(user));
    }
}
