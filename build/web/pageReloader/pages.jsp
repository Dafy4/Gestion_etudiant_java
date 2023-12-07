<%-- 
    Document   : pageReloader
    Created on : 29 août 2023, 13:52:24
    Author     : ORDI
--%>

<%@page import="modele.UserModele"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String nbre = request.getParameter("nbre");
    String nom_page = null;
    String requete = request.getParameter("page");   
    String action = null;
    if(requete == null)
    {
         nom_page = "../administrateur/accueilAdmin";
         out.println("if requete null, nom_page = "+nom_page);
    }
    else
    {
        if(requete.equals("accueilAdmin") || requete.equals("ajouterAdmin") || requete.equals("consulterAdmin") || requete.equals("parametresAdmin") || requete.equals("deconnexion"))
        {
            nom_page = "../administrateur/" + requete;
        }
        else
        {
            action = request.getParameter("action");
            if(action!=null)
            {
                nom_page = "../administrateur/"+requete+"/"+action;
            }
        }
         
         /*
        if(requete.equals("Ajouts"))
        {
            action = request.getParameter("action");
            out.print("action : "+action);
            out.print("nbre = "+nbre);
            if(action != null)
            {
                out.print(" *************** prêt!");
                out.print("action : "+action);
                nom_page = "../administrateur/"+requete+"/"+action;
            }
        }
        else
        {
            if(requete.equals("Consulter"))
            {
               action = request.getParameter("action");
               if(action!=null)
               {
                    nom_page = "../administrateur/"+requete+"/"+action;
               }
            }
            else
            {
                 nom_page = "../administrateur/" + requete; 
            }
              
        }
        //nom_page = "../administrateur/" + requete; 
           
            
            
        
        /*
        if(action.equals("ajouterEtudiants"))
        {
           nom_page = "../administrateur/Ajouts/ajoutEtudiants";
        }
        else
        {
            if(action.equals("ajouterClasses"))
            {
                nom_page = "../administrateur/Ajouts/ajoutClasses";
            }
            else
            {
                  nom_page = "../administrateur/" + requete;
            }
        }
                */
       
    }
%>
<jsp:include page="../header/headerAdmin.jsp"/>
<jsp:include page="<%=nom_page + ".jsp"%>"/>
<jsp:include page="../administrateur/footerAdmin.jsp"/>