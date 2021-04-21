
package controller.commands;

import components.PostUserBeanRemote;

public class ShowMyPosts extends FrontCommand{

    private PostUserBeanRemote postUserBean;
    
    @Override
    public void process() {
        postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean");
        request.setAttribute("postsMYUser", postUserBean.getMyPosts());       
        forward("/ShowMyPosts.jsp");
    }
    
}
