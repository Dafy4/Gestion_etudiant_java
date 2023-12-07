<%-- 
    Document   : ConsulterMatieres
    Created on : 23 sept. 2023, 06:44:26
    Author     : ORDI
--%>

<%@page import="modele.EnseignerModele"%>
<%@page import="dao.ProfesseurDao"%>
<%@page import="modele.UserModele"%>
<%@page import="modele.MatieresModele"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.GradeModele"%>
<%@page import="dao.InsertionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

 <% 
     
     //SESSION
            String username = (String)session.getAttribute("user") ; 
            out.print(username); 
            //id_user
            int id = Integer.parseInt(session.getAttribute("id_user").toString()) ;
    // DAO
            //num_prof
            ProfesseurDao profDao = new ProfesseurDao();
            int num_prof =  profDao.getNumProfByIdUser(id);
            
            //num_matiere
            /*
            List<EnseignerModele> listeNumMatieres = new ArrayList<EnseignerModele>();
            listeNumMatieres = profDao.findNuMatiere(num_prof);
                    */
 %>
<%
    
            
%>
<h1> Vous êtes enseignant dans ces classes : </h1>
<table>
    <tr>
        <th> Grade </th>
        <th> Effectifs </th>
        <th> Matiere </th>
        <th> Coefficient </th>
    </tr>
   <tr>
      <td></td>
   </tr>
   
</table>