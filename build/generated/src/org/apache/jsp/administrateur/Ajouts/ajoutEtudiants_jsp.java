package org.apache.jsp.administrateur.Ajouts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import modele.GradeModele;
import dao.InsertionDao;

public final class ajoutEtudiants_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

        InsertionDao liste = new InsertionDao();
        List<GradeModele> grades = new ArrayList<GradeModele>();
        
        grades = liste.findGrade();

      out.write("\n");
      out.write("<div class=\"choixGrade\">\n");
      out.write("    <h2>Choisissez la grade dans laquelle inscrire les étudiants :</h2>\n");
      out.write("    ");

        int i;
        i = 1;
        int effectifs = 0;
        for(GradeModele listeGrade : grades)
        {
            out.println("<button class='grade' id='gradeSelect"+i+"' onclick=Redirection("+i+")>"+ listeGrade.getGrade() +"</button>");
            effectifs = listeGrade.getEffectifs();
            i++;
        }
    
      out.write("\n");
      out.write("<script>\n");
      out.write("    \n");
      out.write("    /*Prend le grade numéro séléctionner et la valeur du grade*/\n");
      out.write("    function Redirection(i)\n");
      out.write("    {\n");
      out.write("        var gradeSelectionner = document.getElementById(\"gradeSelect\"+i).innerHTML;\n");
      out.write("        console.log(\"grade = \",gradeSelectionner);\n");
      out.write("        var afficher =  document.getElementById(\"gradeForm\");\n");
      out.write("        //afficher.innerHTML = gradeSelectionner; \n");
      out.write("        afficher.setAttribute(\"value\", gradeSelectionner);\n");
      out.write("        apparaitre();\n");
      out.write("        //afficherDemande();\n");
      out.write("    }\n");
      out.write("    function apparaitre()\n");
      out.write("    {\n");
      out.write("        const formulaire = document.getElementById(\"form\");\n");
      out.write("        formulaire.style.visibility = \"visible\";\n");
      out.write("    }\n");
      out.write("    function afficherDemande()\n");
      out.write("    {\n");
      out.write("        const ajoutForm = document.getElementById(\"ajoutForm\");\n");
      out.write("        ajoutForm.style.display = \"block\";\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function nombreForm()\n");
      out.write("    {\n");
      out.write("        //const btn_valider = document.getElementById(\"nbre_form\");\n");
      out.write("        var nbre_form = document.getElementById(\"Nbre_form\").value;\n");
      out.write("        console.log(\"nbre = \", nbre_form);\n");
      out.write("        return nbre_form;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function dates(){\n");
      out.write("        var dateFinal = \"\";\n");
      out.write("        var date = document.getElementById(\"date_nais\").innerText;\n");
      out.write("       \n");
      out.write("            var tab_morceau = date.split(\"-\");\n");
      out.write("            for(var i = tab_morceau.length - 1; i < 0; i--)\n");
      out.write("            {\n");
      out.write("                dateFinal = tab_morceau[i] + \"-\";\n");
      out.write("            }\n");
      out.write("            console.log(dateFinal);\n");
      out.write("    }\n");
      out.write("//document.getElementById(\"date_nais\").addEventListener(\"mouseout\", dates());\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- <div id=\"ajoutForm\" style=\"display:none\">\n");
      out.write("        <h2> Ajouter plus de formulaires : </h2>\n");
      out.write("        <input type=\"number\" name=\"nbre_form\" id=\"Nbre_form\" min=\"1\">\n");
      out.write("        <button id=\"nbre_form\" onclick=\"nombreForm()\"> Valider </button>\n");
      out.write("</div>\n");
      out.write(" -->\n");
      out.write("\n");
      out.write("<div class=\"formulaireEtudiant\" id=\"form\" style=\"visibility: hidden\">\n");
      out.write("    \n");
      out.write("    <h1>Formulaire d'inscription d'étudiants</h1>\n");
      out.write("    <form action=\"AjoutsServlet\" method=\"post\">\n");
      out.write("        <div class=\"infoEtudiant\">\n");
      out.write("                <div>\n");
      out.write("                       <input type=\"text\" name=\"grade\" id=\"gradeForm\" value=\"grade\" readonly >\n");
      out.write("                       <input type=\"text\" name=\"anne_scolaire\" id=\"anne_scolaire\" value=\"grade\">\n");
      out.write("                </div>\n");
      out.write("            ");
  
                String grade = request.getParameter("grade");
                if(grade != null)
                {
                    int placesReste = effectifs - (liste.Inscrits(grade));
                out.print("<h1> Place restantes :"+placesReste+" </h1>"); 
                }
            
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"Num_matr\"> Numero matricule </label>\n");
      out.write("                    <input type=\"text\" name=\"num_matr\" id=\"Num_matr\" placeholder=\"@01\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"Nom\"> Nom </label>\n");
      out.write("                    <input type=\"text\" name=\"nom_etudiant\" id=\"Nom\" placeholder=\"@nom\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"Prenom\"> Prénoms </label>\n");
      out.write("                    <input type=\"text\" name=\"prenom_etudiant\" id=\"Prenom\" placeholder=\"@prenom\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"date_nais\"> Date naissance </label>\n");
      out.write("                    <input type=\"date\" name=\"date_nais\" id=\"date_nais\" >\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"Adresse\"> Adresse</label>\n");
      out.write("                    <input type=\"text\" name=\"adresse\" id=\"Adresse\" placeholder=\"@LOT nom_quartier nom_ville\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"Num_tel\"> Numéro téléphone</label>\n");
      out.write("                    <input type=\"tel\" name=\"num_tel\" id=\"Num_tel\" placeholder=\"+261345288411\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label for=\"Etab_prec\"> Etablissement précédent </label>\n");
      out.write("                    <input type=\"text\" name=\"etab_prec\" id=\"Etab_prec\">\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"infoParents\">\n");
      out.write("                    <div>\n");
      out.write("                        <label for=\"Nom_mere\"> Nom et prénoms de la mère </label>\n");
      out.write("                        <input type=\"text\" name=\"nom_mere\" id=\"Nom_mere\" placeholder=\"@nom et prénoms mere\">\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <label for=\"Num_mere\"> Téléphone de la mère </label>\n");
      out.write("                        <input type=\"tel\" name=\"num_mere\" id=\"Num_mere\" placeholder=\"+261345288412\">\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <label for=\"Nom_pere\"> Nom du père </label>\n");
      out.write("                        <input type=\"text\" name=\"nom_pere\" id=\"Nom_pere\" placeholder=\"@nom et prénoms\">\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <label for=\"Num_pere\"> Téléphone </label>\n");
      out.write("                        <input type=\"tel\" name=\"num_pere\" id=\"Num_pere\" placeholder=\"+261345288413\">\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <label for=\"Nom_tuteur\"> Nom et prénoms du tuteur </label>\n");
      out.write("                        <input type=\"text\" name=\"nom_tuteur\" id=\"Nom_tuteur\" placeholder=\"@nom_tuteur\">\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <label for=\"Num_tuteur\"> Téléphone </label>\n");
      out.write("                        <input type=\"tel\" name=\"num_tuteur\" id=\"Num_mere\" placeholder=\"+261345288414\">\n");
      out.write("                    </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <input type=\"submit\" name=\"submit\" id=\"envoie\" value=\"Valider\">\n");
      out.write("        <input type=\"reset\" name=\"init\" id=\"reinitialiser\" value=\"Reinitialiser\">\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
