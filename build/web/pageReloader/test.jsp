<%-- 
    Document   : test
    Created on : 29 août 2023, 21:11:36
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<% 
    String nom_page = null;
    String requete = request.getParameter("page");
    if(requete == null)
    {
        nom_page = "../administrateur/accueilAdmin"; 
    }
    else
    {
        nom_page = requete;
    }
%>

<jsp:include page="../administrateur/headerAdmin.jsp"/>
<h1> <% out.print(nom_page);%> </h1>
    </body>
</html>
