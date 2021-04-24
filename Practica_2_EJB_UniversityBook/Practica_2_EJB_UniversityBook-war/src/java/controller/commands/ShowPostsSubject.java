package controller.commands;

import components.PostBeanLocalLocal;
import components.StudyBeanRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowPostsSubject extends FrontCommand {
    
    private PostBeanLocalLocal postBean;
    private StudyBeanRemote studyBean;
    
    @Override
    public void process() {
        try {
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBeanLocal!components.PostBeanLocalLocal");
            studyBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("PostBySubject", postBean.getPostsSubject(Integer.parseInt(request.getParameter("universities")), Integer.parseInt(request.getParameter("degrees")), Integer.parseInt(request.getParameter("subjects"))));
        request.setAttribute("subjectChoosen", studyBean.getSubjectById(Integer.parseInt(request.getParameter("subjects"))));
        forward("/ShowPostsSubject.jsp");
    }

}
