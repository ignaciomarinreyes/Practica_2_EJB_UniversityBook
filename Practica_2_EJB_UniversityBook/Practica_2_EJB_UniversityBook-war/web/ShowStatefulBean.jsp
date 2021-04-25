<%@page import="entities.Subject"%>
<%@page import="components.FavouriteSubjectsBean"%>
<%@page import="components.PostUserBean"%>
<%@page import="components.AllStatefulBeanLocal"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printTablePostUserBean(AllStatefulBeanLocal allStatefulBeanLocal) {
        String result = "";
        for (PostUserBean postUserBean : allStatefulBeanLocal.getAllPostUserBean()) {
            result += "<span>PostUserBean_" + postUserBean.hashCode() + " " + postUserBean.getUser().getName() + "</span><form action='FrontController' method='GET'><button type='submit'>Eliminar</button><input type='hidden' name='hashCode' value='" + postUserBean.hashCode() +"'><input type='hidden' name='command' value='RemoveStateful'></form>"
                    + "<table style='width:100%'><tr><td>Id</td><td>Título</td><td>Asignatura</td></tr>";
            for (Post post : postUserBean.getMyPosts()) {
                result += "<tr><td>" + post.getId() + "</td><td>" + post.getTitle() + "</td><td>" + post.getSubject().getName() + "</td></tr>";
            }
            result += "</table>"
                   + "<ul><li>Total de donaciones de " + postUserBean.getUser().getName() + ": " + postUserBean.getDonationTotal() + "</li></ul>";
        }
        return result;
    }

    public static String printTableFavouriteSubjectsBean(AllStatefulBeanLocal allStatefulBeanLocal) {
        String result = "";
        for (FavouriteSubjectsBean favouriteSubjectsBean : allStatefulBeanLocal.getAllFavouriteSubjectsBean()) {
            result += "<span>PostUserBean_" + favouriteSubjectsBean.hashCode() + " " + favouriteSubjectsBean.getUser().getName() + "</span><form action='FrontController' method='GET'><button type='submit'>Eliminar</button><input type='hidden' name='hashCode' value='" + favouriteSubjectsBean.hashCode() +"'><input type='hidden' name='command' value='RemoveStateful'></form>"
                    + "<table style='width:100%'><tr><td>Id</td><td>Nombre</td></tr>";
            for (Subject subject : favouriteSubjectsBean.getFavouritesSubjects()) {
                result += "<tr><td>" + subject.getId() + "</td><td>" + subject.getName() + "</td></tr>";
            }
            result += "</table>";
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
                out.println("<h1>PostUserBean</h1>");
                out.println(printTablePostUserBean((AllStatefulBeanLocal) request.getAttribute("allStatefulBean")));
                out.println("<h1>FavouriteSubjectsBean</h1>");
                out.println(printTableFavouriteSubjectsBean((AllStatefulBeanLocal) request.getAttribute("allStatefulBean")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>

