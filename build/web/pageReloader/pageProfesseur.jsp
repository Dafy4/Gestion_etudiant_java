<%-- 
    Document   : pageProfesseur
    Created on : 23 sept. 2023, 00:22:11
    Author     : ORDI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String nbre = request.getParameter("nbre");
    String nom_page = null;
    String requete = request.getParameter("page");   
    String action = null;
    if(requete == null)
    {
         nom_page = "../professeur/accueilProfesseur";
         out.println("if requete null, nom_page = "+nom_page);
    }
    else
    {
        if(requete.equals("accueilProfesseur") || requete.equals("ajouterProfesseur") || requete.equals("consulterProfesseur") || requete.equals("parametresProfesseur") || requete.equals("deconnexion"))
        {
            nom_page = "../professeur/" + requete;
        }
        else
        {
            action = request.getParameter("action");
            if(action!=null)
            {
                nom_page = "../professeur/"+requete+"/"+action;
            }
        }
    }
%>
<jsp:include page="../header/headerProfesseur.jsp"/>
<jsp:include page="<%=nom_page + ".jsp"%>"/>
<jsp:include page="../administrateur/footerAdmin.jsp"/>