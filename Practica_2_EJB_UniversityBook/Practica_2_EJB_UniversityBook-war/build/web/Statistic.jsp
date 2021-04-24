<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(int numberUserHasLogged, int numberUserLoggedNow) {
        String result = "<table style='width:100%'>"; 
        result += "<tr><td>Concepto</td><td>Valor</td></tr>"
                + "<tr>" 
                + "<td>Número logueos en el sistema </td><td>" + numberUserHasLogged +"</td>"
                + "</tr>"
                + "<tr>" 
                + "<td>Número usuarios logueados actualmente</td><td>" + numberUserLoggedNow +"</td>"
                + "</tr>"
                + "</table>";
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
                out.println(printTable(((Integer) request.getAttribute("numberUserHasLogged")), ((Integer) request.getAttribute("numberUserLoggedNow"))));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
