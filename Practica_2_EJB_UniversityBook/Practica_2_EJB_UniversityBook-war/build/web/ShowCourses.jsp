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
                out.println("<h3>Número de asignaturas por curso</h3>");
                out.println("<ul><li>Primer curso: " + numberSubjectsByCourse[0] +"</li>");
                out.println("<li>Segundo curso: " + numberSubjectsByCourse[1]  +"</li>");
                out.println("<li>Tercer curso: " +  numberSubjectsByCourse[2] +"</li>");
                out.println("<li>Cuarto curso: " + numberSubjectsByCourse[3]  +"</li></ul>");
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
