package controller.commands;

import components.PostUserBeanRemote;
import components.SessionBeanRemote;
import entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Logout extends FrontCommand {

    private SessionBeanRemote sessionBean;
    
    @Override
    public void process() {
        //PostUserBeanRemote postUserBean = (PostUserBeanRemote) request.getSession().getAttribute("postUserBean" + ((User) request.getSession().getAttribute("user")).getId());      
        try {
            sessionBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SessionBean!components.SessionBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        sessionBean.remove((User) request.getSession().getAttribute("user"));
        request.getSession().setAttribute("user", null);
        forward("/index.jsp");
    }

}
