<%-- 
    Document   : consulterProfesseur
    Created on : 23 sept. 2023, 00:27:44
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

        <h1> Choisissez une categorie</h1>
        <div class="btn-action">
            <a href="pageProfesseurServlet?page=Consulter&action=consulterEtudiants"> <button class="btn-ajout-et"> Etudiants  </button>   </a>
            <a href="pageProfesseurServlet?page=Consulter&action=ConsulterMatieres"> <button class="btn-ajout-mat"> Matières   </button>   </a>
            <a href="pageProfesseurServlet?page=Consulter&action=consulterProfesseur"> <button class="btn-ajout-prof"> Professeur </button>   </a>
            <a href="pageProfesseurServlet?page=Consulter&action=consulterCours"> <button class="btn-ajout-cours"> Cours      </button>   </a>
            <a href="pageProfesseurServlet?page=Consulter&action=consulterClasses"> <button class="btn-ajout-classes"> Classes     </button>   </a>    
        </div>
