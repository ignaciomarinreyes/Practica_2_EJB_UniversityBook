package controller.commands;

import components.UserRolRemote;
import entities.Rol;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
