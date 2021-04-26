package controller.commands;

import components.StudyBeanRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import components.AllStatefulBeanLocal;

public class ShowPostsSubject extends FrontCommand {

    private AllStatefulBeanLocal allStatefulBeanLocal;
    private StudyBeanRemote studyBean;

    @Override
    public void process() {
        try {
            allStatefulBeanLocal = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/AllStatefulBean!components.AllStatefulBeanLocal");
            studyBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostBySubject", allStatefulBeanLocal.getPostsSubject(Integer.parseInt(request.getParameter("universities")), Integer.parseInt(request.getParameter("degrees")), Integer.parseInt(request.getParameter("subjects"))));
        request.setAttribute("subjectChoosen", studyBean.getSubjectById(Integer.parseInt(request.getParameter("subjects"))));
        forward("/ShowPostsSubject.jsp");
    }

}
