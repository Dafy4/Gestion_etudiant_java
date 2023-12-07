<%-- 
    Document   : headerEtudiant
    Created on : 29 août 2023, 22:25:51
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/header.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <a href="pageEtudiantServlet?page=accueilEtudiant"> Accueil </a>
            <a href="pageEtudiantServlet?page=profilEtudiant"> Profil </a>
            <a href="pageEtudiantServlet?page=releveEtudiant"> Relevé de notes </a>
            <a href="pageEtudiantServlet?page=programmeEtudiant"> Programme </a>
            <a href="pageEtudiantServlet?page=deconnexion"> Déconnexion </a>   
        </div>
 