package controller.commands;

import data.Data;

public class SearchSubject extends FrontCommand {

    @Override
    public void process() {
        request.setAttribute("universities", Data.getUniversities());
        request.setAttribute("degrees", Data.getDegrees());
        request.setAttribute("subjects", Data.getSubjects());
        forward("/SearchSubject.jsp");
    }
}
