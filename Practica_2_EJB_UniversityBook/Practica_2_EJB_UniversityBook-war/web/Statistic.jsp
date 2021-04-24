<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTable(int numberUserHasLogged, int numberUserLoggedNow, HashMap<String, Integer> mapNumberInvokeBean) {
        String result = "<table style='width:100%'>"; 
        result += "<tr><td>Concepto</td><td>Valor</td></tr>"
                + "<tr>" 
                + "<td>Número logueos en el sistema </td><td>" + numberUserHasLogged +"</td>"
                + "</tr>"
                + "<tr>" 
                + "<td>Número usuarios logueados actualmente</td><td>" + numberUserLoggedNow +"</td>"
                + "</tr>"
                + "</table>"
                + "<h1>Número de veces que se llama a cada componente</h1>"
                + "<table style='width:100%'>"
                + "<tr><td>Componente</td><td>Número llamadas</td></tr>";
                for (Map.Entry<String, Integer> entry : mapNumberInvokeBean.entrySet()) {
                    result += "<tr><td>" + entry.getKey() + "</td><td>" +  entry.getValue() + "</td></tr>";
                }
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
                out.println(printTable(((Integer) request.getAttribute("numberUserHasLogged")), ((Integer) request.getAttribute("numberUserLoggedNow")), (HashMap<String, Integer>) request.getAttribute("mapNumberInvokeBean")) );
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
