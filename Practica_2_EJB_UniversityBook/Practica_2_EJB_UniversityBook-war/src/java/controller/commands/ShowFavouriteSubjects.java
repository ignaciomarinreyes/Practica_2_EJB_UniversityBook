package controller.commands;

import components.FavouriteSubjectsBeanRemote;
import entities.User;

public class ShowFavouriteSubjects extends FrontCommand {

    private FavouriteSubjectsBeanRemote favouriteSubjectsBean;
        
    @Override
    public void process() {  
        favouriteSubjectsBean = (FavouriteSubjectsBeanRemote) request.getSession().getAttribute("favouriteSubjectsBean" + ((User) request.getSession().getAttribute("user")).getId());
        request.setAttribute("favouriteSubjects", favouriteSubjectsBean.getFavouritesSubjects());
        forward("/ShowFavouriteSubjects.jsp");
    }

}

