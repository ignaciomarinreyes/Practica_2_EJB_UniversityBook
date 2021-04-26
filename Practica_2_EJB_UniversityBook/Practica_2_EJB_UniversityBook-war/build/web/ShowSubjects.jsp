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
    public static String printTable(Set<User> students) {
        String result = "<table style='width:100%'>";
        result += "<tr><th>ID</th><th>Nombre</th><th>Apellido</th></tr>";
        for (User student : students) {
            result += "<tr>"
                    + "<td>" + student.getId() + "</td>"
                    + "<td>" + student.getName() + "</td>"
                    + "<td>" + student.getSurname() + "</td>"
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
            <%                ArrayList<Subject> subjects = (ArrayList<Subject>) request.getAttribute("subjects");
                for (Subject subject : subjects) {
                    out.println("<h3>" + subject.getUniversity().getName() + ":" + subject.getDegree().getName() + ":" + subject.getName() + "</h3>");
                    out.println(printTable(subject.getStudents()));
                }
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
