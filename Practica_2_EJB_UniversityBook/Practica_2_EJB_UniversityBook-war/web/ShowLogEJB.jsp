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
    public static String printLog(String mensaje) {
        String[] arregloString = mensaje.split("\n");
        String result = "";
        for(int i=0; i < arregloString.length ;i++){ 
            result += "<p>" + arregloString[i] + "</p>";
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
                out.println(printLog((String) request.getAttribute("logEJB")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
