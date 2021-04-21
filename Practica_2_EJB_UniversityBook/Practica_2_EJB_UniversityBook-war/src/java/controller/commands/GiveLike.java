package controller.commands;

import components.PostBeanRemote;
import entities.User;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GiveLike extends FrontCommand {

    private PostBeanRemote postBean;
    
    @Override
    public void process() {
        try {
            postBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/PostBean!components.PostBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        int idPost = Integer.valueOf(request.getParameter("idPost"));
        System.out.println(this);
         System.out.println(this.hashCode());
         System.out.println(((User) request.getSession().getAttribute("user")).hashCode());
        postBean.addLikePost((User) request.getSession().getAttribute("user"), idPost);
        forward("/Like.jsp");
    }
}
