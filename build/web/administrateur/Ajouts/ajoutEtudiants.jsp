<%-- 
    Document   : ajoutEtudiants
    Created on : 1 sept. 2023, 09:19:24
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
<div class="choixGrade">
    
    
    <h2>Choisissez la grade dans laquelle inscrire les étudiants :</h2>
    <%
        int i;
        i = 1;
        int effectifs = 0;
        for(GradeModele listeGrade : grades)
        {
            effectifs = listeGrade.getEffectifs();
            int placesReste = effectifs - (liste.Inscrits(listeGrade.getGrade()));
            out.println("<button class='grade' id='gradeSelect"+i+"' onclick=Redirection("+i+")>"+ listeGrade.getGrade() +" </button>"+"Place restantes : "+ placesReste+"");
            
            //out.print("<h5> Place restantes :"+placesReste+"  </h5>");          
            i++;
        }
    %>
<script> 
    
    /*Prend le grade numéro séléctionner et la valeur du grade*/
    function Redirection(i)
    {
        var gradeSelectionner = document.getElementById("gradeSelect"+i).innerHTML;
        console.log("grade = ",gradeSelectionner);
        var afficher =  document.getElementById("gradeForm");
        //afficher.innerHTML = gradeSelectionner; 
        afficher.setAttribute("value", gradeSelectionner);
        apparaitre();
        //afficherDemande();
    }
    function apparaitre()
    {
        const formulaire = document.getElementById("form");
        formulaire.style.visibility = "visible";
    }
    function afficherDemande()
    {
        const ajoutForm = document.getElementById("ajoutForm");
        ajoutForm.style.display = "block";
    }
    
    function nombreForm()
    {
        //const btn_valider = document.getElementById("nbre_form");
        var nbre_form = document.getElementById("Nbre_form").value;
        console.log("nbre = ", nbre_form);
        return nbre_form;
    }
    
    function dates(){
        var dateFinal = "";
        var date = document.getElementById("date_nais").innerText;
       
            var tab_morceau = date.split("-");
            for(var i = tab_morceau.length - 1; i < 0; i--)
            {
                dateFinal = tab_morceau[i] + "-";
            }
            console.log(dateFinal);
    }
//document.getElementById("date_nais").addEventListener("mouseout", dates());
</script>

</div>

<!-- <div id="ajoutForm" style="display:none">
        <h2> Ajouter plus de formulaires : </h2>
        <input type="number" name="nbre_form" id="Nbre_form" min="1">
        <button id="nbre_form" onclick="nombreForm()"> Valider </button>
</div>
 -->

<div class="formulaireEtudiant" id="form" style="visibility: hidden">
    
    <h1>Formulaire d'inscription d'étudiants</h1>
    <form action="AjoutsServlet" method="post">
        <div class="infoEtudiant">
                <div>
                       <input type="text" name="grade" id="gradeForm" value="grade" readonly >
                       <input type="text" name="anne_scolaire" id="anne_scolaire" value="grade">
                </div>
            <%  
                String grade = request.getParameter("grade");
                if(grade != null)
                {
                    int placesReste = effectifs - (liste.Inscrits(grade));
                out.print("<h1> Place restantes :"+placesReste+" </h1>"); 
                }
            %>
                <div>
                    <label for="Num_matr"> Numero matricule </label>
                    <input type="text" name="num_matr" id="Num_matr" placeholder="@01">
                </div>
                <div>
                    <label for="Nom"> Nom </label>
                    <input type="text" name="nom_etudiant" id="Nom" placeholder="@nom">
                </div>
                <div>
                    <label for="Prenom"> Prénoms </label>
                    <input type="text" name="prenom_etudiant" id="Prenom" placeholder="@prenom">
                </div>
                <div>
                    <label for="date_nais"> Date naissance </label>
                    <input type="date" name="date_nais" id="date_nais" >
                </div>
                <div>
                    <label for="Adresse"> Adresse</label>
                    <input type="text" name="adresse" id="Adresse" placeholder="@LOT nom_quartier nom_ville">
                </div>
                <div>
                    <label for="Num_tel"> Numéro téléphone</label>
                    <input type="tel" name="num_tel" id="Num_tel" placeholder="+261345288411">
                </div>
                <div>
                    <label for="Etab_prec"> Etablissement précédent </label>
                    <input type="text" name="etab_prec" id="Etab_prec">
                </div>
        </div>
        <div class="infoParents">
                    <div>
                        <label for="Nom_mere"> Nom et prénoms de la mère </label>
                        <input type="text" name="nom_mere" id="Nom_mere" placeholder="@nom et prénoms mere">
                    </div>
                    <div>
                        <label for="Num_mere"> Téléphone de la mère </label>
                        <input type="tel" name="num_mere" id="Num_mere" placeholder="+261345288412">
                    </div>
                    <div>
                        <label for="Nom_pere"> Nom du père </label>
                        <input type="text" name="nom_pere" id="Nom_pere" placeholder="@nom et prénoms">
                    </div>
                    <div>
                        <label for="Num_pere"> Téléphone </label>
                        <input type="tel" name="num_pere" id="Num_pere" placeholder="+261345288413">
                    </div>
                    <div>
                        <label for="Nom_tuteur"> Nom et prénoms du tuteur </label>
                        <input type="text" name="nom_tuteur" id="Nom_tuteur" placeholder="@nom_tuteur">
                    </div>
                    <div>
                        <label for="Num_tuteur"> Téléphone </label>
                        <input type="tel" name="num_tuteur" id="Num_mere" placeholder="+261345288414">
                    </div>
        </div>
        
        <input type="submit" name="submit" id="envoie" value="Valider">
        <input type="reset" name="init" id="reinitialiser" value="Reinitialiser">
    </form>
</div>

