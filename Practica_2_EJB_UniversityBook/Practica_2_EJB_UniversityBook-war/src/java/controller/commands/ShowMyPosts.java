package controller.commands;

import components.PostUserBeanRemote;
import entities.User;

public class ShowMyPosts extends FrontCommand {

    private PostUserBeanRemote postUserBean;

    @Override
    public void process() {
        postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean" + ((User) request.getSession().getAttribute("user")).getId());
        request.setAttribute("postsMYUser", postUserBean.getMyPosts());
        forward("/ShowMyPosts.jsp");
    }

}
