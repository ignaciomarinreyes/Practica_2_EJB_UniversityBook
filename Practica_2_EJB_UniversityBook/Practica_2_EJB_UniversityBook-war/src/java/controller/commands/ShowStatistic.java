package controller.commands;

import components.StatisticBeanRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowStatistic extends FrontCommand {

    private StatisticBeanRemote statisticBean;

    @Override
    public void process() {
        try {
            statisticBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StatisticBean!components.StatisticBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("numberUserHasLogged", statisticBean.getNumberUserHasLogged());
        request.setAttribute("numberUserLoggedNow", statisticBean.getNumberUserLoggedNow());
        request.setAttribute("mapNumberInvokeBean", statisticBean.getMapNumberInvokeBean());
        forward("/Statistic.jsp");
    }

}
