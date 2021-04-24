<%@page import="entities.Subject"%>
<%@page import="entities.Rol"%>
<%@page import="entities.User"%>
<div id="menu">
    <form action='FrontController' method='GET' style='float: left; margin-left: 10px;'>                 
        <input type='hidden' name='command' value='SearchSubject'>   
        <%
            if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ShowPostsSubject.jsp")) {
                out.println("<input value='Buscar' style='background-color: #9BC1E4;' type='submit'>");
                out.println("</form>");
                out.println("<span>" + ((Subject) request.getAttribute("subjectChoosen")).getName() + "</span>");
                out.println("<form action='FrontController' method='GET' style='float: left; margin-right: 10px;'>");
                out.println("<input type='hidden' name='command' value='AddFavouriteSubject'>");
                out.println("<input type='hidden' name='idSubject' value='" + ((Subject) request.getAttribute("subjectChoosen")).getId() + "'>");
                out.println("<input value='Añadir a Favoritos' type='submit'>");
                out.println("</form> ");
            } else {
                out.println("<input value='Buscar' style='background-color: none;' type='submit'>");
                out.println("</form>");
            }
            out.println("<form action='FrontController' method='GET' style='float: right; margin-right: 10px;'>");
            out.println("<input type='hidden' name='command' value='Logout'> ");
            out.println("<input value='Cerrar Sesión' type='submit'>");
            out.println("</form> ");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'> ");
            out.println("<input type='hidden' name='command' value='Configuracion'> ");
            out.println("<input value='Configuración' type='submit'>");
            out.println("</form>");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'> ");
            out.println("<input type='hidden' name='command' value='ShowFavouriteSubjects'> ");
            if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ShowFavouriteSubjects.jsp")) {
                out.println("<input value='Asignaturas Favoritas' type='submit' style='background-color: #9BC1E4;'>");
            } else {
                out.println("<input value='Asignaturas Favoritas' type='submit'>");
            }
            out.println("</form>");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'>");
            if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ShowMyPosts.jsp")) {
                out.println("<input value='Perfil' type='submit' style='background-color: #9BC1E4;'>");
            } else {
                out.println("<input value='Perfil' type='submit'>");
            }
            out.println("<input type='hidden' name='command' value='ShowMyPosts'>");
            out.println("</form>");
            out.println("<form action='FrontController' style='float: right; margin-right: 10px;'>");
            out.println("<input type='hidden' name='command' value='ShowPostsFollowedSubject'>");
            if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/MainFrame.jsp")) {
                out.println("<input value='Inicio' type='submit' style='background-color: #9BC1E4;'> ");
            } else {
                out.println("<input value='Inicio' type='submit'>");
            }
            out.println("</form> ");
            if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ShowPostsSubject.jsp")) {
                out.println("<form action='Publish.jsp' style='float: right; margin-right: 10px;'>");
                out.println("<input type='hidden' id='subjects' name='subject' value='" + request.getParameter("subjects") + "'> ");
                if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/Publish.jsp")) {
                    out.println("<input value='Publicar' type='submit' style='background-color: #9BC1E4;> ");
                } else {
                    out.println("<input value='Publicar' type='submit'>");
                }
                out.println("</form>");
            }
            if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ShowPostsSubject.jsp")) {
                out.println("<form action='ProgramPublish.jsp' style='float: right; margin-right: 10px;'>");
                out.println("<input type='hidden' id='subjects' name='subject' value='" + request.getParameter("subjects") + "'> ");
                if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ProgramPublish.jsp")) {
                    out.println("<input value='Programar publicación' type='submit' style='background-color: #9BC1E4;> ");
                } else {
                    out.println("<input value='Programar publicación' type='submit'>");
                }
                out.println("</form>");
            }
            if (((User) session.getAttribute("user")).getRol().equals(Rol.Admin)) {

                out.println("<form action='ControlPanel.jsp' style='float: right; margin-right: 10px;'>");
                if (request.getRequestURI().equals("/Practica_2_EJB_UniversityBook-war/ControlPanel.jsp")) {
                    out.println("<input value='Administrador' type='submit' style='background-color: #9BC1E4;>");
                } else {
                    out.println("<input value='Panel de Control' type='submit'>");
                }
                out.println("</form> ");
            }
            out.println("<span>  </span>");
            out.println("<div style='float: right; margin-right: 10px; padding-top: 5px; background-color: white; font-size: 15pt;'>" + ((User) request.getSession().getAttribute("user")).getName() + "</div>");
            out.println("</div>");
        %>