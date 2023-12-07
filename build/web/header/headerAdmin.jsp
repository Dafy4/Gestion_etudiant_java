<%-- 
    Document   : headerAdmin
    Created on : 29 août 2023, 14:33:04
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/header.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // HttpSession session1 = request.getSession();
             if(session.getAttribute("user") == null)
             {
                 response.sendRedirect("index.jsp");
                 
             }
             
        %>
        <div class="header">
            <a href="pageServlet?page=accueilAdmin"> Accueil </a>
            <a href="pageServlet?page=ajouterAdmin"> Ajouter </a>
            <a href="pageServlet?page=consulterAdmin"> Consulter </a>
            <!-- <a href="pageServlet?page=parametresAdmin"> Paramètres </a> -->
            <a href="DeconnexionServlet"> Déconnexion </a>   
        </div>
        
