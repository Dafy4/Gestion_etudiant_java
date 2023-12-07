<%-- 
    Document   : headerProfesseur
    Created on : 29 août 2023, 22:25:04
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
            <a href="pageProfesseurServlet?page=accueilProfesseur"> Accueil </a>
            <a href="pageProfesseurServlet?page=ajouterProfesseur"> Ajouter </a>
            <a href="pageProfesseurServlet?page=consulterProfesseur"> Consulter </a>
            <a href="pageProfesseurServlet?page=parametresProfesseur"> Paramètres </a>
            <a href="pageProfesseurServlet?page=deconnexion"> Déconnexion </a>   
        </div>