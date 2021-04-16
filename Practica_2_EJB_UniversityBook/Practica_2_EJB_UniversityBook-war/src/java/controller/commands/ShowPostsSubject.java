package controller.commands;

import data.dao.PostDAO;

public class ShowPostsSubject extends FrontCommand {

    @Override
    public void process() {
        request.setAttribute("PostBySubject", PostDAO.findPostBySubject(Integer.parseInt(request.getParameter("universities")), Integer.parseInt(request.getParameter("degrees")), Integer.parseInt(request.getParameter("subjects"))));
        forward("/ShowPostsSubject.jsp");
    }

}
