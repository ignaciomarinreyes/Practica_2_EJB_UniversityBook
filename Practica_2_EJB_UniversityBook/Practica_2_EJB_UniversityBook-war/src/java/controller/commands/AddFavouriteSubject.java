package controller.commands;

import components.FavouriteSubjectsBeanRemote;
import components.StudyBeanRemote;
import entities.Subject;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AddFavouriteSubject extends FrontCommand {

    private FavouriteSubjectsBeanRemote favouriteSubjectsBean;
        
    @Override
    public void process() {  
        try {
            favouriteSubjectsBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/FavouriteSubjectsBean!components.FavouriteSubjectsBeanRemote");             
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        favouriteSubjectsBean.addFavouriteSubject((Subject) request.getAttribute("subjectChoosen"));
        forward("/Add.jsp");
    }

}
