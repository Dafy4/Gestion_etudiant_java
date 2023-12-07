<%-- 
    Document   : ajoutProfesseur
    Created on : 14 sept. 2023, 00:34:08
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
    <div class="formProf">
        <h1> Un nouvel embauché!</h1>
        <form action="AjoutProfesseurServlet" method="post" class="form_prof">
            <div>
                <label for="NomProf"> Nom  </label>
                <input type="text" name="nom_prof" id="NomProf">
            </div>
            <div>
                <label for="PrenomProf"> Prénoms </label>
                <input type="text" name="prenom_prof" id="PrenomProf">
            </div>
            <div>
                <label for="TelProf"> Téléphone </label>
                <input type="tel" name="tel_prof" id="TelProf">
            </div>
            <div>
                <label for="AdresseProf"> Adresse </label>
                <input type="text" name="adresse_prof" id="AdresseProf">
            </div>
            <div>
                <label for="mdp"> Mot de passe </label>
                <input type="text" name="mdp_prof" id="mdp">
            </div>   
            <input type="submit" name="validerProf"  class="btn_V" value="Valider">
            <input type="reset" name="AnnulerProf" class="btn_A" value="Réinitialiser">
        </form>
    </div>
        

