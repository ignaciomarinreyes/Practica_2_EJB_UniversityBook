package controller.commands;

import components.PostUserBeanRemote;
import entities.User;


public class Logout extends FrontCommand {

    
    @Override
    public void process() {
        PostUserBeanRemote postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean" + ((User) request.getSession().getAttribute("user")).getId());
        request.getSession().setAttribute("user", null);
        forward("/index.jsp");
    }

}
