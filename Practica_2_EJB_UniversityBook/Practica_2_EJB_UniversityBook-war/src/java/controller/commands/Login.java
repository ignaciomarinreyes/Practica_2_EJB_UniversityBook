package controller.commands;

import components.PostBeanRemote;
import components.PostUserBeanRemote;
import components.SessionBeanRemote;
import components.StudyBeanRemote;
import components.UserBeanRemote;
import data.Data;
import entities.Degree;
import entities.Post;
import entities.Subject;
import entities.University;
import entities.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Login extends FrontCommand {

    SessionBeanRemote sessionBeanRemote;
    UserBeanRemote userBean;
    PostBeanRemote postBean;
    PostUserBeanRemote postUserBean;
    StudyBeanRemote studyBean;

    @Override
    public void process() {
        try {
            sessionBeanRemote = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
            loadDefaulValues();
            postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean");
            if ((User) request.getSession().getAttribute("user") == null) {
                User user = sessionBeanRemote.login(request.getParameter("nickname"), request.getParameter("password"));
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    if(postUserBean == null){
                        postUserBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostUserBean!components.PostUserBeanRemote");
                        request.getSession().setAttribute("postUserBean", postUserBean);
                    }                   
                    loadDefaultValuesUser(user);
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

    private void loadDefaulValues() throws NamingException {
        userBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/UserBean!components.UserBeanRemote");
        postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBean!components.PostBeanRemote");
        studyBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        if (userBean.getUsers().size() == 0) {
            Data.loadDefaultData();
            userBean.addDefaultUsers((ArrayList<User>) Data.getUsers());
            postBean.addDefaultPosts((ArrayList<Post>) Data.getPosts()); 
            studyBean.addDefaultUniversities((ArrayList<University>) Data.getUniversities());
            studyBean.addDefaultDegrees((ArrayList<Degree>) Data.getDegrees());
            studyBean.addDefaultSubjects((ArrayList<Subject>) Data.getSubjects());
        }
    }

    private void loadDefaultValuesUser(User user) {
        postUserBean.addDefaultMyPosts(Data.getPostsOfUser(user));
    }
    
    private static byte[] serialize(PostUserBeanRemote postUserBeanRemote){
        ByteArrayOutputStream bs= new ByteArrayOutputStream();
        ObjectOutputStream os = null;
        byte[] bytes = null;
        try {
            os = new ObjectOutputStream (bs);
            os.writeObject(postUserBeanRemote);  
            os.close();
            bytes =  bs.toByteArray(); 
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bytes;
    }
}
