<%-- 
    Document   : consulter
    Created on : 4 sept. 2023, 21:08:41
    Author     : ORDI
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.GradeModele"%>
<%@page import="dao.InsertionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    InsertionDao liste = new InsertionDao();
    List<GradeModele> grades = new ArrayList<GradeModele>();
    
    grades = liste.findGrade();
%>

    <h1>Classes existantes</h1>
    <table class="consulteClasse">
        <tr>
            <th> Grade </th>
            <th> Organisation année scolaire </th>
            <th> Effectifs </th>
            <!-- <th> Actions </th> -->
        </tr>
        <% 
            for(GradeModele listeGrade: grades)
            {
                out.print("<tr>");
                out.print("  <td>" + listeGrade.getGrade() +"  </td> ");
            
                out.print(" <td>" + listeGrade.getOrganisation_annee_scolaire() +"  </td>");
                out.print(" <td>" + listeGrade.getEffectifs() +"  </td>");
                out.print(" <td> <div class='listeConsulte'>");
                /* out.print(" <a href='http://'> <button class='btn_modif'> Modifier </button> </a>  "); 
                out.print(" <a href='http://'> <button class='btn_suppr'> Supprimer </button> </a> "); */
                out.print("</div> </td>");
                out.print("</tr>");
            }
         %>
    </table> 
        