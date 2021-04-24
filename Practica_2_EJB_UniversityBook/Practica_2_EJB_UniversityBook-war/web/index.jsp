<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="template.css"/>
        <title>UniversityBook</title> 
    </head>
    <body>
        <% 
            if(request.getSession().getAttribute("user") != null){
                response.sendRedirect("/Practica_2_EJB_UniversityBook-war/FrontController?command=Login");
            }
        %>
        <header id="title"><span>UniversityBook</span></header> 
        <div id="divlogged">
            <form action='FrontController' method='POST'>
                <div style="padding: 10px;">
                    <span>Nombre: </span>
                    <input type='text' name='nickname' value='admin'> 
                </div>  
                <div style="padding: 10px;">
                    <span>Contraseña: </span>
                    <input type='text' name='password' value='1234'> 
                </div>  
                <input type='hidden' name='command' value='Login'> 
                <input style="padding: 10px;" value='Iniciar Sesión' type='submit'>
            </form>
        </div>   
    </body>   
</html>



