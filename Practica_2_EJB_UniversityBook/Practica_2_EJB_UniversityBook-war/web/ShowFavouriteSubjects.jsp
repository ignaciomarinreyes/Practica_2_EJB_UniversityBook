<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(HashSet<Subject> subjects) {
        String result = "<table style='width:100%'>"; 
        result += "<tr><td>ID</td><td>Nombre</td><td>Curso</td></tr>";
        for(Subject subject: subjects){
        result += "<tr>" 
                +  "<td>" + subject.getId() +"</td>"
                +  "<td>" + subject.getName() +"</td>"
                +  "<td>" + subject.getCourse() +"</td>"
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
        <%@ include file="Menu.jsp"%>    
        <div id="centerSpace">
            <%  
                HashSet<Subject> subjectsList = (HashSet<Subject>) request.getAttribute("favouriteSubjects");
                out.println(printTable(subjectsList));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
