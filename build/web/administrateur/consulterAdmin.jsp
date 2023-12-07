<%-- 
    Document   : consulter
    Created on : 29 août 2023, 15:42:42
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <h1> Choisissez une categorie</h1>
        <div class="btn-action">
            <a href="pageServlet?page=Consulter&action=consulterEtudiants"> <button class="btn-ajout-et"> Etudiants  </button>   </a>
            <a href="pageServlet?page=Consulter&action=ConsulterMatieres"> <button class="btn-ajout-mat"> Matières   </button>   </a>
            <a href="pageServlet?page=Consulter&action=consulterProfesseur"> <button class="btn-ajout-prof"> Professeur </button>   </a>
            <!-- <a href="pageServlet?page=Consulter&action=consulterCours"> <button class="btn-ajout-cours"> Cours      </button>   </a> -->
            <a href="pageServlet?page=Consulter&action=consulterClasses"> <button class="btn-ajout-classes"> Classes     </button>   </a>    
        </div>
