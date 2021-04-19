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

    private PostUserBeanRemote postUserBean;
    
    @Override
    public void process() {
        postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean");
        Post post = new Post(request.getParameter("title"), (User) request.getSession().getAttribute("user"), LocalDate.now(), request.getParameter("content"), null, SubjectDAO.findById(Integer.valueOf(request.getParameter("subject"))));
        postUserBean.addPost(post);
        request.setAttribute("postsMYUser", postUserBean.getMyPosts());
        forward("/ShowMyPosts.jsp");
    }

}
