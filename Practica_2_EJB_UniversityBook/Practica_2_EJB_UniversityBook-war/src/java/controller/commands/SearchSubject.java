package controller.commands;

import components.StudyBeanRemote;
import data.Data;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchSubject extends FrontCommand {

    private StudyBeanRemote studyBean;
    
    @Override
    public void process() {
        try {
            studyBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("universities", studyBean.getUniversities());
        request.setAttribute("degrees", studyBean.getDegrees());
        request.setAttribute("subjects", studyBean.getSubjects());
        forward("/SearchSubject.jsp");
    }
}
