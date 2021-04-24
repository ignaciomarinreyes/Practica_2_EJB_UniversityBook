<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
                int[] numberSubjectsByCourse = (int[]) request.getAttribute("numberSubjectsByCourse");
                out.println("<h1>Número de asignaturas por curso</h1>");
                out.println("<p>Primer curso: " + numberSubjectsByCourse[0] +"</p>");
                out.println("<p>Segundo curso: " + numberSubjectsByCourse[1]  +"</p>");
                out.println("<p>Tercer curso: " +  numberSubjectsByCourse[2] +"</p>");
                out.println("<p>Cuarto curso: " + numberSubjectsByCourse[3]  +"</p>");
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
