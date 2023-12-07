package org.apache.jsp.administrateur.Ajouts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modele.ProfesseursModele;
import java.util.List;
import java.util.ArrayList;
import dao.InsertionDao;
import modele.GradeModele;

public final class ajoutMatieres_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

        InsertionDao liste = new InsertionDao();
        List<GradeModele> grades = new ArrayList<GradeModele>();
        
        grades = liste.findGrade();

        List<ProfesseursModele> prof = new ArrayList<ProfesseursModele>();
        prof = liste.listeProfesseur() ;

      out.write("\n");
      out.write("<h1> Assigner les matières à des professeurs </h1>\n");
      out.write("<div class=\"choixGrade\">\n");

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
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("function Redirection(i)\n");
      out.write("    {\n");
      out.write("        var gradeSelectionner = document.getElementById(\"gradeSelect\"+i).innerHTML;\n");
      out.write("        console.log(\"grade = \",gradeSelectionner);\n");
      out.write("        var afficher =  document.getElementById(\"gradeInput\");\n");
      out.write("        //afficher.innerHTML = gradeSelectionner; \n");
      out.write("        afficher.setAttribute(\"value\", gradeSelectionner);\n");
      out.write("        //apparaitre();\n");
      out.write("        //afficherDemande();\n");
      out.write("    }\n");
      out.write("    function apparaitre()\n");
      out.write("    {\n");
      out.write("        const formulaire = document.getElementById(\"form\");\n");
      out.write("        formulaire.style.display = \"block\";\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<form action=\"NombreAjout?page=Ajouts&action=ajoutMatieres\" method=\"post\">\n");
      out.write("    <label for=\"NbreClasse\"> Combien de grades voulez-vous ajouter? </label>\n");
      out.write("    <input type=\"text\" name=\"grade\" id=\"gradeInput\" value=\"grade\" readonly >\n");
      out.write("    <input type=\"number\" name=\"nbre_classe\"  min=\"1\" value=\"0\" id=\"NbreClasse\">\n");
      out.write("    <input type=\"submit\" name=\"sub-nbre\" value=\"Valider\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("    \n");

    
    if(request.getParameter("valider")!=null)
    {
        int nbre = Integer.valueOf(request.getParameter("nbre"));
        out.print("<form action='AjoutMatieresServlet?nbre="+nbre+"' method='post' id='form' >"); 
        out.print("<h2>"+nbre+"</h2>");
        String grade = request.getParameter("grade");

      out.write("\n");
      out.write("    \n");
      out.write("    <table >\n");
      out.write("        <tr>\n");
      out.write("            <th> Matière </th>\n");
      out.write("            <th> Coefficient </th>\n");
      out.write("            <th> Professeur </th>\n");
      out.write("            <th> Classe </th>\n");
      out.write("        </tr>\n");
      out.write("        ");
  for(int j = 1 ; j <= nbre ; j++)
        { 
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td> ");
 out.print("<input type='text' id='matiere' name='matiere"+j+"' >"); 
      out.write("  </td>\n");
      out.write("            <td> ");
 out.print("<input type='text' id='coefficient' name='coefficient"+j+"'>"); 
      out.write("  </td>\n");
      out.write("            <td> \n");
      out.write("                <select name=\"prof\" id=\"prof\">\n");
      out.write("                    ");
 
                        for(ProfesseursModele professeur : prof)
                        {
                           out.print("<option value='' name='prof"+j+"'>"+professeur.getNom_prof() + "   "+ professeur.getPrenom_prof()+"</option>");
                        } 
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("            </td>\n");
      out.write("            <td> ");
 out.print("<input type='text' id='gradeInput' value="+grade+" name='grade' readonly>"); 
      out.write("  </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </table>\n");
      out.write("    <input type=\"submit\" id=\"btn-valider\" name=\"valider\">\n");
      out.write("    ");
 out.print("</form>"); 
      out.write('\n');
 } 
      out.write('\n');
      out.write(' ');
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
