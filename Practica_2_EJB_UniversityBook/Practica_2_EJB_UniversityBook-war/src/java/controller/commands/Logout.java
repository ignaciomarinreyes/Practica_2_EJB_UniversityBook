package controller.commands;

public class Logout extends FrontCommand {

    @Override
    public void process() {
        request.getSession().setAttribute("user", null);
        forward("/index.jsp");
    }

}
