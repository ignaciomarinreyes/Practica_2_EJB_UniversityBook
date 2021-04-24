package controller.commands;

import components.FavouriteSubjectsBeanRemote;
import components.StudyBeanRemote;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddFavouriteSubject extends FrontCommand {

    private FavouriteSubjectsBeanRemote favouriteSubjectsBean;
    private StudyBeanRemote studyBean;

    @Override
    public void process() {
        favouriteSubjectsBean = (FavouriteSubjectsBeanRemote) request.getSession().getAttribute("favouriteSubjectsBean" + ((User) request.getSession().getAttribute("user")).getId());
        try {
            studyBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        favouriteSubjectsBean.addFavouriteSubject(studyBean.getSubjectById(Integer.parseInt((String) request.getParameter("idSubject"))));
        forward("/OperationSuccesful.jsp");
    }

}
