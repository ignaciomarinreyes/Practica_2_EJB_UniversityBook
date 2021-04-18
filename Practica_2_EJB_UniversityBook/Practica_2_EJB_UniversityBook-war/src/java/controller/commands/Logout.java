package controller.commands;

import components.PostUserBeanRemote;


public class Logout extends FrontCommand {

    
    @Override
    public void process() {
        PostUserBeanRemote postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean");
        postUserBean.remove();
        request.getSession().setAttribute("postUserBean", null);
        request.getSession().setAttribute("user", null);
        forward("/index.jsp");
    }

}
