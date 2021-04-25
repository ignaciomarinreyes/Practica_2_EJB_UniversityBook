<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>Publish</title>
    </head>
    <body>
        <%@ include file="Header.jsp"%>    
        <%@ include file="Menu.jsp"%>    
        <div id="centerSpace">
            <form action='FrontController' method='GET'>
                <p>Título: </p>
                <input type="text" name="title"><br>
                <p>Mensaje:</p>
                <textarea name="content" rows="4" cols="50"></textarea><br>
                <input type='hidden' id='subjects' name='subject' value='<%= request.getParameter("subject")%>'>   
                <span>Programar publicación (milisegundos): </span>
                <input type="text" name="miliseconds"><br>
                <input type='hidden' name='command' value='ProgramPublish'>
                <select width="200px" name="donation">
                    <option value='No donar'>No donar</option>
                    <option value='Donar ahora'>Donar ahora</option>
                    <option value='Donar mensualmente durante 12 meses'>Donar mensualmente durante 12 meses</option>
                    <option value='Donar trimestralmente durante 12 meses'>Donar trimestralmente durante 12 meses</option>
                </select>
                <button type="submit">Confirmar</button>
            </form>
        </div>
    </body>
</html>
