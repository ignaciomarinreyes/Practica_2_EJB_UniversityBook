package controller.commands;

import components.SubjectsOperationRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowCourses extends FrontCommand {

    private SubjectsOperationRemote subjectsOperation;

    @Override
    public void process() {
        try {
            subjectsOperation = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/SubjectsOperation!components.SubjectsOperationRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("numberSubjectsByCourse", subjectsOperation.getNumberSubjectsByCourse());
        forward("/ShowCourses.jsp");
    }

}
