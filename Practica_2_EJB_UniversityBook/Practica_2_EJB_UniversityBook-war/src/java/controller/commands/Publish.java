package controller.commands;

import entities.Post;
import entities.User;
import data.Data;
import data.dao.PostDAO;
import data.dao.SubjectDAO;
import java.time.LocalDate;

public class Publish extends FrontCommand {

    @Override
    public void process() {
        Data.add(new Post(request.getParameter("title"), (User) request.getSession().getAttribute("user"), LocalDate.now(), request.getParameter("content"), null, SubjectDAO.findById(Integer.valueOf(request.getParameter("subject")))));
        request.setAttribute("postsMYUser", PostDAO.findPostByUser((User) request.getSession().getAttribute("user")));
        forward("/ShowMyPosts.jsp");
    }

}
