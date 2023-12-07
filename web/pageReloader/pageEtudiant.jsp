<%-- 
    Document   : pageEtudiant
    Created on : 20 sept. 2023, 10:47:55
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
         nom_page = "../etudiant/accueilEtudiant";
         out.println("if requete null, nom_page = "+nom_page);
    }
    else
    {
        if(requete.equals("accueilEtudiant") || requete.equals("profilEtudiant") || requete.equals("releveEtudiant") || requete.equals("programmeEtudiant") || requete.equals("deconnexion"))
        {
            nom_page = "../etudiant/" + requete;
        }
        else
        {
            action = request.getParameter("action");
            if(action!=null)
            {
                nom_page = "../etudiant/"+requete+"/"+action;
            }
        }
    }
%>
<jsp:include page="../header/headerEtudiant.jsp"/>
<jsp:include page="<%=nom_page + ".jsp"%>"/>
<jsp:include page="../administrateur/footerAdmin.jsp"/>