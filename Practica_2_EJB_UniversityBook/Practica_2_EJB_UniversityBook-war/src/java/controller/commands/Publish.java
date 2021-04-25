package controller.commands;

import components.PostUserBeanRemote;
import entities.Post;
import entities.User;
import java.time.LocalDate;

public class Publish extends FrontCommand {

    private PostUserBeanRemote postUserBean;
    
    @Override
    public void process() {
        postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean" + ((User) request.getSession().getAttribute("user")).getId());
        postUserBean.addPost((String) request.getParameter("title"), (User) request.getSession().getAttribute("user"), LocalDate.now(), (String) request.getParameter("content"), null, Integer.valueOf(request.getParameter("subject")), (String) request.getParameter("donation"));
        request.setAttribute("postsMYUser", postUserBean.getMyPosts());
        postUserBean.calculateRecognitions();
        forward("/ShowMyPosts.jsp");
    }

}
