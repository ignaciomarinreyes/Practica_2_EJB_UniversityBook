package controller.commands;

import components.StudyBeanRemote;
import entities.University;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import util.XsltProcessor;

public class ShowUniversities extends FrontCommand {

    private StudyBeanRemote studyBean;

    @Override
    public void process() {
        PrintWriter out = null;
        try {
            studyBean = InitialContext.doLookup("java:global/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-ejb/StudyBean!components.StudyBeanRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        try {
            List<University> universities = studyBean.getUniversities();
            XsltProcessor processor = new XsltProcessor("university.xsl");
            out = response.getWriter();
            out.println(head());
            for (University university : universities) {
                out.println(processor.getTransformation(util.ConverterObjectToXml.toXmlUniversity(University.class, university)));
            }
            out.println(footer());
        } catch (IOException ex) {
            Logger.getLogger(ShowUniversities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private String head() {
        return "<html>"
                + "<head>"
                + "   <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'> "
                + "  <link rel='stylesheet' type='text/css' href='template.css'/> "
                + "</head> "
                + "<body> "
                + " <header id=\"title\"><a style=\"color: black; text-decoration: none;\" href=\"MainFrame.jsp\">UniversityBook</a></header>"
                + menuAdmin()
                + " <div id='centerSpace'>";
    }

    private String footer() {
        return "</div>"
                + "</body> "
                + "</html>";
    }

    private String menuAdmin() {
        String result = "<div id='menu'>"
                + "<form action='FrontController' method='GET' style='float: right; margin-right: 10px;'>"
                + "<input type='hidden' name='command' value='Logout'>"
                + "<input value='Cerrar Sesión' type='submit'>"
                + "</form> "
                + "<form action='FrontController' style='float: right; margin-right: 10px;'>"
                + "<input type='hidden' name='command' value='ShowPostsFollowedSubject'> "
                + "<input value='Inicio' type='submit'>"
                + "</form>  "
                + "<form action='FrontController' style='float: left; margin-right: 10px;'>"
                + "<input type='hidden' name='command' value='ShowUniversities'>        "
                + "<input value='Universities' type='submit'>"
                + "</form>"
                + "<form action='FrontController' style='float: left; margin-right: 10px;'>"
                + "<input type='hidden' name='command' value='ShowDegrees'>"
                + "<input value='Degrees' type='submit'>"
                + "</form>"
                + "<form action='FrontController' style='float: left; margin-right: 10px;'>"
                + "<input type='hidden' name='command' value='ShowUsers'>"
                + "<input value='Users' type='submit'>"
                + "</form>"
                + "<form action='FrontController' style='float: left; margin-right: 10px;'>"
                + "<input type='hidden' name='command' value='ShowSubjects'>"
                + "<input value='Subjects' type='submit'>"
                + "</form>"
                + "</div>";
        return result;
    }

}
