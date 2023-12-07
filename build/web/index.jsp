<%-- 
    Document   : index
    Created on : 30 juil. 2023, 20:48:45
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="image">
            <img src="css/assets/login.png">
        </div>
         <div class="authentification"> 
            <form action="SessionServlet" method="POST">
                <h1> Authentification </h1>
                    <div class="nom_user">
                        <div> <label for="utilisateur"> Nom d'utilisateur </label> </div>
                        <div> <input type="text" id="utilisateur" name="user"> </div>
                    </div>
                    
                    <!-- <div class="type_user">
                        <div> <label for="type_utilisateur"> Qui êtes vous? </label> </div>
                        <div>
                            <select id="type_utilisateur" name="type_user">
                                <option> Administrateur </option>
                                <option> Professeur </option>
                                <option> Etudiant </option>
                                <option> Parent d'élève </option>
                            </select>
                        </div>
                    </div> -->
                    
                    <div class="user_password">
                        <div>  <label for="password"> Mot de passe </label> </div>
                        <div>  <input type="password" id="password" placeholder="***********" name="password"> </div>     
                    </div>
                    <div class="button">
                         <input type="submit" value="Valider">
                         <input type="reset">
                    </div>
            </form>
        </div>
        
    </body>
</html>
