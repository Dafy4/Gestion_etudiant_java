<%-- 
    Document   : consulterEtudiants
    Created on : 13 sept. 2023, 22:44:22
    Author     : ORDI
--%>

<%@page import="modele.EtudiantsModele"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.GradeModele"%>
<%@page import="dao.InsertionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
  <h1>Choisissez dans quelle grade voulez-vous consulter : </h1>
<%
     InsertionDao liste = new InsertionDao();
    List<GradeModele> grades = new ArrayList<GradeModele>();
    
    grades = liste.findGrade();
    int i;
        i = 1;
        out.print("<div class='choixGrade'>");
         for(GradeModele listeGrade : grades)
        {
            out.println(" <a href='ChoixGradeServlet?grade="+listeGrade.getGrade()+"'><button class='grade' id='gradeSelect"+i+"'>"+ listeGrade.getGrade() +"</button> </a>");
            i++;
        }
        out.print("</div>");
%>
           
<%
          
         String grade = request.getParameter("grade");
        
         
         if(grade != null)
         {
            out.print("<h2>"+ grade+ "</h2>");
            InsertionDao listeEt = new InsertionDao();
            List<EtudiantsModele> listeEtudiants = new ArrayList<EtudiantsModele>();
            listeEtudiants = listeEt.findEtudiants(grade);
            %>
            <table>
                <tr>
                    <th>Numero matricule</th>
                    <th> Nom et prénoms</th>
                    <th> Téléphone </th>
                    <th>Adresse </th>
                    <th>Date de naissance </th>
                    <th>Etablissement précédent </th>
                    <th>Mère</th>
                    <th>Père</th>
                    <th>Tuteur</th>
                </tr>
        
          <%for(EtudiantsModele etudiant : listeEtudiants){ %>
                    <tr>
                    <td> <% out.println(etudiant.getNum_matr());%> </td>
                        <td> <% out.println(etudiant.getNom() +" "+etudiant.getPrenom()); %> </td>
                        <td> <% out.println(etudiant.getNum_tel()) ;%></td>
                        <td> <%out.println(etudiant.getAdresse()) ;%></td>
                        <td> <%out.println(etudiant.getDate_nais()) ;%></td>
                        <td> <%out.println(etudiant.getEtablissement_prec()) ;%></td>
                        <td> <%out.println(etudiant.getNom_mere()+"("+  etudiant.getNum_tel_mere() +")")  ; %> </td>
                        <td> <%out.println(etudiant.getNom_pere() +"("+   etudiant.getNum_tel_pere() +")") ;%> </td>
                        <td> <%out.println(etudiant.getNom_tuteur() +"("+  etudiant.getNum_tel_tuteur() +")" );%> </td>
                    </tr>
               <%}%>
        <%}%>
         </table>