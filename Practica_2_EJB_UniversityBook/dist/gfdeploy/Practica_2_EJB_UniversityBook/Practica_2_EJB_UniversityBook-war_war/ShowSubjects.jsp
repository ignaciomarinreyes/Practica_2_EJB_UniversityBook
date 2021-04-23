<%@page import="java.util.HashMap"%>
<%@page import="entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(ArrayList<Subject> subjects) {
        String result = "<table style='width:100%'>"; 
        result += "<tr><td>ID</td><td>Asignatura</td><td>Grado</td></tr>";
        for(Subject subject: subjects){
        result += "<tr>" 
                +  "<td>" + subject.getId() +"</td>"
                +  "<td>" + subject.getName() +"</td>"
                +  "<td>" + subject.getDegree().getName() +"</td>"
                + "</tr>";
        }
        result += "</table>";
        return result;
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
    </head>
    <body>
        <%@ include file="Header.jsp"%>    
        <%@ include file="MenuAdmin.jsp"%>    
        <div id="centerSpace">
            <%  
                HashMap<String, ArrayList<Subject>> parameter = (HashMap<String, ArrayList<Subject>>) request.getAttribute("subjects");               
                for(ArrayList<Subject> subjects : parameter.values()){
                                    if(subjects.size() > 0){
                                        out.println("<h1>"+ subjects.get(0).getUniversity().getName() + "</h1>"); 
                                        out.println(printTable(subjects));
                                    }
                }

            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
