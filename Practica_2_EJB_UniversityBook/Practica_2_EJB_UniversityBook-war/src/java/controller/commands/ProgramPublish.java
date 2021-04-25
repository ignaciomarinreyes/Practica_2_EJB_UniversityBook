package controller.commands;

import components.PostUserBeanRemote;
import entities.Post;
import entities.User;
import java.time.LocalDate;

public class ProgramPublish extends FrontCommand {

    private PostUserBeanRemote postUserBean;
    
    @Override
    public void process() {
        postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean" + ((User) request.getSession().getAttribute("user")).getId());
        postUserBean.programPost(Integer.parseInt(request.getParameter("miliseconds")),(String) request.getParameter("title"), (User) request.getSession().getAttribute("user"), LocalDate.now(), (String) request.getParameter("content"), null, Integer.valueOf(request.getParameter("subject")), (String) request.getParameter("donation"));
        request.setAttribute("postsMYUser", postUserBean.getMyPosts());
        forward("/ShowMyPosts.jsp");
    }

}
