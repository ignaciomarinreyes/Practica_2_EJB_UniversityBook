package controller.commands;

import components.PostBeanLocalLocal;
import components.PostUserBeanRemote;
import components.StudyBeanRemote;
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

public class ShowSubjects extends FrontCommand {

    private StudyBeanRemote studyBeanRemote;
        
    @Override
    public void process() {  
        try {
            studyBeanRemote = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("subjects", studyBeanRemote.getSubjects());
        forward("/ShowSubjects.jsp");
    }

}
