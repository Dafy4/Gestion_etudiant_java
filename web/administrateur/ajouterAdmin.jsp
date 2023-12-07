<%-- 
    Document   : ajouter
    Created on : 29 août 2023, 15:04:04
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1> Ajouter de nouveux membres! </h1>
<div class="btn-action">
    <a href="pageServlet?page=Ajouts&action=ajoutEtudiants"> <button class="btn-ajout-et"> Etudiants  </button>   </a>
    <a href="pageServlet?page=Ajouts&action=ajoutMatieres"> <button class="btn-ajout-mat"> Matières   </button>   </a>
    <a href="pageServlet?page=Ajouts&action=ajoutProfesseur"> <button class="btn-ajout-prof"> Professeur </button>   </a>
    <!-- <a href="pageServlet?page=Ajouts&action=ajoutCours"> <button class="btn-ajout-cours"> Cours      </button>   </a> -->
    <a href="pageServlet?page=Ajouts&action=ajoutClasses"> <button class="btn-ajout-classes"> Classes     </button>   </a>    
</div>

