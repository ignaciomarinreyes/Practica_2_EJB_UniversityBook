
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>Unknow</title>
    </head>
    <body>
        <%@ include file="Header.jsp"%>  
        <%@ include file="Menu.jsp"%>  
        <h1 style='text-align: center;'>
            Mensaje de error
        </h1>
        <p style='padding-left: 10px;'>
            Se ha producido un error en el comando <%= request.getParameter("command")%>
        </p>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
