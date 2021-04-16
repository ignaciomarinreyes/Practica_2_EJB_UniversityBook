package controller.commands;

import entities.University;
import data.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.XsltProcessor;

public class ShowUniversities extends FrontCommand {

    @Override
    public void process() {
        PrintWriter out = null;
        try {
            List<University> universities = Data.getUniversities();
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
                + " <div id='centerSpace'>";
    }

    private String footer() {
        return "</div>"
                + "</body> "
                + "</html>";
    }

}
