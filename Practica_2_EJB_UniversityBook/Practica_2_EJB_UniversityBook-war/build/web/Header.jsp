<%
    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<header id="title"><span>UniversityBook</span></header> 

