
package controller.commands;

import entities.User;
import data.dao.PostDAO;

public class ShowMyPosts extends FrontCommand{

    @Override
    public void process() {
        request.setAttribute("postsMYUser", PostDAO.findPostByUser((User) request.getSession().getAttribute("user")));       
        forward("/ShowMyPosts.jsp");
    }
    
}
