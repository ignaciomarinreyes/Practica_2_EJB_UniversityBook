<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(List<User> usersTeacher, List<User> usersStudent, List<User> usersAdmin) {
        String result = "<h3>Teacher</h3>" 
        + "<table style='width:100%'>"; 
        result += "<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Apodo</th><th>Contraseña</th></tr>";
        for(User user: usersTeacher){
        result += "<tr>" 
                +  "<td>" + user.getId() +"</td>"
                +  "<td>" + user.getName() +"</td>"
                +  "<td>" + user.getSurname() +"</td>"
                +  "<td>" + user.getNickname() +"</td>"
                +  "<td>" + user.getPassword() +"</td>"
                + "</tr>";
        }
        result += "</table>";

        result += "<h3>Student</h3>" 
        + "<table style='width:100%'>"; 
        result += "<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Apodo</th><th>Contraseña</th></tr>";
        for(User user: usersStudent){
        result += "<tr>"
                +  "<td>" + user.getId() +"</td>"
                +  "<td>" + user.getName() +"</td>"
                +  "<td>" + user.getSurname() +"</td>"
                +  "<td>" + user.getNickname() +"</td>"
                +  "<td>" + user.getPassword() +"</td>"
                + "</tr>";
        }
        result += "</table>";

        result += "<h3>Admin</h3>" 
        + "<table style='width:100%'>"; 
        result += "<tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Apodo</th><th>Contraseña</th></tr>";
        for(User user: usersAdmin){
        result += "<tr>"
                +  "<td>" + user.getId() +"</td>"
                +  "<td>" + user.getName() +"</td>"
                +  "<td>" + user.getSurname() +"</td>"
                +  "<td>" + user.getNickname() +"</td>"
                +  "<td>" + user.getPassword() +"</td>"
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
                out.println(printTable((List<User>)request.getAttribute("usersTeacher"), (List<User>)request.getAttribute("usersStudent"), (List<User>) request.getAttribute("usersAdmin")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
