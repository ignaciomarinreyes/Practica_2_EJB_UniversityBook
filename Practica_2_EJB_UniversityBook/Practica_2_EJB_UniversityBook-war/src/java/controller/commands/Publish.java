package controller.commands;

import components.PostBeanRemote;
import components.PostUserBeanRemote;
import entities.Post;
import entities.User;
import data.Data;
import data.dao.PostDAO;
import data.dao.SubjectDAO;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Publish extends FrontCommand {

    private PostBeanRemote postBean;
    private PostUserBeanRemote postUserBean;
    
    @Override
    public void process() {
        try {
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBean!components.PostBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean");
        Post post = new Post(request.getParameter("title"), (User) request.getSession().getAttribute("user"), LocalDate.now(), request.getParameter("content"), null, SubjectDAO.findById(Integer.valueOf(request.getParameter("subject"))));
        postBean.addPost(post);
        postUserBean.addPost(post);
        request.setAttribute("postsMYUser", postUserBean.getMyPosts());
        forward("/ShowMyPosts.jsp");
    }

}
