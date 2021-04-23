package controller.commands;

import components.PostBeanLocalLocal;
import components.PostUserBeanRemote;
import components.SubjectDegreeUniversityRemote;
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

    private SubjectDegreeUniversityRemote subjectDegreeUniversity;
        
    @Override
    public void process() {  
        try {
            subjectDegreeUniversity = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SubjectDegreeUniversity!components.SubjectDegreeUniversityRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("subjects", subjectDegreeUniversity.getSubjectGroupByUniversity());
        forward("/ShowSubjects.jsp");
    }

}
