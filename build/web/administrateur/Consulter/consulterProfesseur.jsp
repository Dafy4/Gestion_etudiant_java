<%-- 
    Document   : consulterProfesseur
    Created on : 14 sept. 2023, 15:48:17
    Author     : ORDI
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.ProfesseursModele"%>
<%@page import="dao.InsertionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    InsertionDao listeProf = new InsertionDao();
    List<ProfesseursModele> liste = new ArrayList<ProfesseursModele>();
    liste = listeProf.listeProfesseur();
%>
<h1> Liste des professeurs de l'établissement </h1>
<table class="consulteClasse">
    <tr>
        <th> Nom et prénoms </th>
        <th> Contacts </th>
        <th> Adresses </th>
        <!-- <th> Action </th> -->
    </tr>
    <%for(ProfesseursModele professeur :liste) {%>
    <tr>
        <td> <% out.print(professeur.getNom_prof()+"   "+professeur.getPrenom_prof());%> </td>
        <td> <% out.print(professeur.getNum_tel_prof());%> </td>
        <td> <% out.print(professeur.getAdresse());%> </td>
        <!-- <td> <% out.print("<div> <button> Modifier </button> <button> Renvoyer </button></div>");%> </td> -->
    </tr> 
     <%}%>
</table>
