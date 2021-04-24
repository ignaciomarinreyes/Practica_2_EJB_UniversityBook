package controller.commands;

import components.PostUserBeanRemote;
import components.UserBeanRemote;
import components.UserRolRemote;
import entities.Post;
import entities.Rol;
import entities.User;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import components.AllStatefulBeanLocal;

public class ShowUsers extends FrontCommand {

    private UserRolRemote userRol;
    
    @Override
    public void process() {  
        try {
            userRol = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/UserRol!components.UserRolRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("usersTeacher", userRol.getUsersByRol(Rol.Teacher));
        request.setAttribute("usersStudent", userRol.getUsersByRol(Rol.Student));
        request.setAttribute("usersAdmin", userRol.getUsersByRol(Rol.Admin));
        forward("/ShowUsers.jsp");
    }

}
