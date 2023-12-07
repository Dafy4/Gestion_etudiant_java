<%-- 
    Document   : ajoutClasses
    Created on : 1 sept. 2023, 15:40:51
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<h1>Classes!</h1>
<div class="formulaireClasse">
    <form action="NombreAjout?page=Ajouts&action=ajoutClasses" method="post">
        <label for="NbreClasse"> Combien de grades voulez-vous ajouter? </label>
        <input type="number" name="nbre_classe"  min="1" value="0" id="NbreClasse">
        <input type="submit" name="sub-nbre" value="Valider">
    </form>
       
     <% if(request.getParameter("valider")!=null){
        
          int nbre = Integer.valueOf(request.getParameter("nbre"));
           out.print(" <form action='InsertionGradeServlet?nbre="+nbre+"' method='post'> ");
             for(int i = 1 ; i <= nbre ; i++)
             {
                out.print(" <label for='Grade'> Grade </label>");
                out.print(" <div>");
                out.print(" <input type='text' id='Grade' name='grade"+i+"' placeholder='seconde'>");
                out.print(" </div>");
                out.print("  <div>");
                out.print("<label for='Org'> Organisatiion année scolaire </label> ");
                out.print("<input type='text' name='org"+i+"' id='Org' placeholder='@semestre ou @trimestre' >");
                out.print("   </div>");
                out.print("<div>");
                out.print(" <label for='Effectifs'> Effectifs </label>");
                out.print("<input type='text' name='efectifs"+i+"' id='Effectifs'>");
                out.print("</div>");
                out.print("<input type='reset' id='annulerClasse' value='Annuler'>");
                out.print("");
             }
              out.print("<input type='submit' id='envoyerClasse' value='Envoyer'>");
              out.print("</form>");
         }  
         String confirmation = request.getParameter("confirmation");
         if(confirmation != null)
         {
             out.print("  <div>" + confirmation );
              out.print("   </div>");
         }
     %>
</div>


