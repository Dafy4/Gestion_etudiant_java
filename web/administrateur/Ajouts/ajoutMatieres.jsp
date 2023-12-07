<%-- 
    Document   : ajoutMatieres
    Created on : 16 sept. 2023, 15:21:02
    Author     : ORDI
--%>

<%@page import="modele.ProfesseursModele"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.InsertionDao"%>
<%@page import="modele.GradeModele"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
        InsertionDao liste = new InsertionDao();
        List<GradeModele> grades = new ArrayList<GradeModele>();
        
        grades = liste.findGrade();

        List<ProfesseursModele> prof = new ArrayList<ProfesseursModele>();
        prof = liste.listeProfesseur() ;
%>
<h1> Assigner les matières à des professeurs </h1>
<div class="choixGrade">
<%
        int i;
        i = 1;
        int effectifs = 0;
        for(GradeModele listeGrade : grades)
        {
            out.println("<button class='grade' id='gradeSelect"+i+"' onclick=Redirection("+i+")>"+ listeGrade.getGrade() +"</button>");
            effectifs = listeGrade.getEffectifs();
            i++;
        }
%>
</div>
<script>
function Redirection(i)
    {
        var gradeSelectionner = document.getElementById("gradeSelect"+i).innerHTML;
        console.log("grade = ",gradeSelectionner);
        var afficher =  document.getElementById("gradeInput");
        //afficher.innerHTML = gradeSelectionner; 
        afficher.setAttribute("value", gradeSelectionner);
        //apparaitre();
        //afficherDemande();
    }
    function apparaitre()
    {
        const formulaire = document.getElementById("form");
        formulaire.style.display = "block";
    }
    
</script>

<form action="NombreAjout?page=Ajouts&action=ajoutMatieres" method="post" class="nombre_ajout_mat">
    <label for="NbreClasse"> Combien de matières voulez-vous ajouter? Et pour quelles classe? </label>
    <input type="text" name="grade" id="gradeInput" value="grade" readonly >
    <input type="number" name="nbre_classe"  min="1" value="0" id="NbreClasse">
    <input type="submit" name="sub-nbre" value="Valider">
</form>

    
<%
    
    if(request.getParameter("valider")!=null)
    {
        int nbre = Integer.valueOf(request.getParameter("nbre"));
        out.print("<form action='AjoutMatieresServlet?nbre="+nbre+"' method='post' id='form' class='form_mat' >"); 
        out.print("<h2>"+nbre+"</h2>");
        String grade = request.getParameter("grade");
%>
    
    <table class="tab_form_mat">
        <tr>
            <th> Matière </th>
            <th> Coefficient </th>
            <th> identifiant du professeur </th>
            <th> Nom et prénoms du professeur </th>
            <th> Classe </th>
        </tr>
        <%  for(int j = 1 ; j <= nbre ; j++)
        { 
        %>
        <tr>
            <td> <% out.print("<input type='text' id='matiere' name='matiere"+j+"' >"); %>  </td>
            <td> <% out.print("<input type='text' id='coefficient' name='coefficient"+j+"'>"); %>  </td>
            <td> 
                    <%  String id = null;
                        out.print("<select name='prof"+j+"' id='prof"+j+"'>");
                        for(ProfesseursModele professeur : prof)
                        {
                           id = professeur.getNum_prof();
                           out.print("<option>"+ professeur.getNum_prof() +" </option>");
                        } 
                        out.print("</select>");
                    %>
            </td>
            <% out.print("<td id='nom_prof"+j+"'> "+liste.nomProf(id)+" </td>"); %>
            
            <td> <% out.print("<input type='text' id='gradeInput' value="+grade+" name='grade' readonly>"); %>  </td>
        </tr>
        <% } %>
    </table>
    <input type="submit" id="btn-valider" name="valider">
    <% out.print("</form>"); %>

    <script src="css/jquery.min.js"></script>
    
<script>
     <%  for(int j = 1 ; j <= nbre ; j++)
        { 
         out.print("var select"+j+" = document.getElementById('prof"+j+"');"); 
         out.print("var idProf"+j+" = select"+j+".value;");
         out.print(" console.log('idProf"+j+" = ',idProf"+j+"); ");
         out.print(" select"+j+".addEventListener('click', function(){ ");
            out.print(" idProf"+j+" = select"+j+".value;");
            out.print(" console.log('idProf"+j+" = ',idProf"+j+");");
            out.print(" $.ajax({");
            out.print("url : 'IdServlet',");
            out.print(" method : 'post',");
            out.print(" data : {id:idProf"+j+"}, ");
            out.print(" success: function(response){ ");
            out.print(" document.getElementById('nom_prof"+j+"').innerHTML= response ; ");
            out.print(" } ");
            out.print("  }) ");
        
            String name = null;
           // out.print("var td = document.getElementById('nom_prof"+j+"') ;");
           // out.print(" console.log( td );");
         out.print("});");
    
    } %>
        
</script>
    <% } %>