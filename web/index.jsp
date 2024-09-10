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
                        <div> <label for="input_username"> Nom d'utilisateur </label> </div>
                        <div> <input type="text" id="input_username" name="user"> </div>
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
                        <div>  <label for="input_password"> Mot de passe </label> </div>
                        <div>  <input type="password" id="input_password" placeholder="***********" name="password" > </div>     
                    </div>
                    <div class="button">
                         <input type="submit" value="Valider" id="btnSubmit" style="display: none;">
                         <input type="reset">
                    </div>
            </form>
        </div>
        <script src="js/sweetalert.min.js"></script>
        <script>
            window.onload = function() {
                <% if (request.getAttribute("error") != null) { %>
                    console.log("ok");
                    swal({
                        title: "Athentification non valide",
                        text: '<%= request.getAttribute("error") != null ? request.getAttribute("error").toString() : "" %>',
                        icon: "warning",
                        button: "D'accord!",
                    });
                <% 
                   
                    } 
                %>
            }
            /*Ne pas afficher le boutton valider tant que les champs de saisies ne sont pas remplies*/
            var inptUser = document.getElementById("input_username");
            console.log(inptUser);
            var inptPassd = document.getElementById("input_password");
            var btnSubmit = document.getElementById("btnSubmit");
            if(inptUser.value == null || inptPassd.value == null)
            {
                console.log("Pas assez");
                btnSubmit.style.display = "none";
            }
            else if(inptUser.value != null && inptPassd.value != null)
            {
                console.log("valeur" + inptUser.value);
                btnSubmit.style.display = "block";
            }
        </script>
    </body>
</html>
