<%@page import="java.util.List"%>
<%@page import="data.Data"%>
<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    public static String printPosts(List<Post> posts) {
        String result = "";
        for (Post post : posts) {
            result += "<div class='post'><h1>" + post.getTitle() + "</h1>"
                    + "<div class='tuser'><span>" + post.getUser().getName() + "</span><span> " + post.getDate() + "</span></div>"
                    + "<p>" + post.getContent() + "</p>";
            if (post.getPathImage() != null) {
                result += "<div class='picture'><img src='" + post.getPathImage() + "' width='40%' height='40%'></div>";
            }
            if (post.getLinks().size() > 0) {
                result += "<div class='link'>";
                for (String link : post.getLinks()) {
                    result += "<a href='" + link + "'>Enlace</a>";
                }
                result += "</div>";
            }
            if (post.getFiles().size() > 0) {
                result += "<div class='file'>";
                for (String file : post.getFiles()) {
                    result += "<a href='" + file + "'>Fichero</a>";
                }
                result += "</div>";
            }
            if (post.getComments().size() > 0) {
                result += "<div>";
                for (Comment comment : post.getComments()) {
                    result += "<div class='tcomment'><span>" + comment.getUser().getName() + "</span><span> " + comment.getDate() + "</span></div>"
                            + "<div class='comment'>" + comment.getContent() + "</div>";
                }
                result += "</div>";
            }
            result += "</div>";
            result += "<form action='FrontController' style='display: inline;' method='GET''>";
            result += "<input type='hidden' name='command' value='GiveLike'> ";
            result +="<input type='hidden' name='idPost' value='"+  post.getId() +"'> ";
            result += "<input value=' + Añadir like' type='submit'>";
            result += "</form> ";
            result += "<span class='like'>Me gusta: " + post.numberLikes() + "</span>";
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
        <%@ include file="Menu.jsp"%>    
        <div id="centerSpace">
            <%                 out.println(printPosts((List<Post>) request.getAttribute("postsMYUser")));
            %>
        </div>
        <%@ include file="Footer.jsp"%> 
    </body>
</html>
