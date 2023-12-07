<%-- 
    Document   : accueilProfesseur
    Created on : 28 août 2023, 14:08:53
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Welcome professeur!</h1>
         <p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    </body>
</html>
