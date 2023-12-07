<%-- 
    Document   : ConsulterMatieres
    Created on : 20 sept. 2023, 20:10:18
    Author     : ORDI
--%>

<%@page import="modele.ProfesseursModele"%>
<%@page import="modele.MatieresModele"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.GradeModele"%>
<%@page import="dao.InsertionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<%
    InsertionDao listeGrade = new InsertionDao();
    List<GradeModele> grades = new ArrayList<GradeModele>();
    grades = listeGrade.findGrade();
    
    MatieresModele matieres = new MatieresModele();
    List<MatieresModele> mat = new ArrayList<MatieresModele>();
%>
<%%>
<% for(GradeModele listeGrades : grades){ %>

 <% out.print("<h1> Grade :"+listeGrades.getGrade()+" </h1>"); %>
<% 
     mat = listeGrade.findMatieresByGrade(listeGrades.getGrade());
%>
<table class="consultMat"> 
    <tr>
        <th> Matière </th>
        <th> Coefficient </th>
        <th> Professeur </th>
        <th> Grade </th>
        <!-- <th> Actions </th> -->
    </tr>
   
        
                <%
                    for(MatieresModele matiere: mat)
                   {
                        int num_matiere = matiere.getNum_matiere();
                        int num_prof = listeGrade.findNumProf(num_matiere);
                        ProfesseursModele prof = new ProfesseursModele();
                         prof = listeGrade.findProfByNum(num_prof);
                %>
                 <tr>
                    <td> <% out.print(matiere.getNom_matiere()) ;%>  </td>
                    <td> <% out.print(matiere.getCoefficient()) ;%>  </td>

                    <td> <% out.print(prof.getNom_prof() +"  "+prof.getPrenom_prof()) ;%> </td>

                    <td> <% out.print(matiere.getGrade()); %> </td>
                    <!-- <td>  <button> Modifier </button> <button> Supprimer </button> </td> -->
                </tr>
                 
                  <% } %>
      
        
   
</table>
        
<% } %>
