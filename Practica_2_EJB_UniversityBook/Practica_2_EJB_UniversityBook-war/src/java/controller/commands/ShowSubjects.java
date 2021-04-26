package controller.commands;

import components.StudyBeanRemote;
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
