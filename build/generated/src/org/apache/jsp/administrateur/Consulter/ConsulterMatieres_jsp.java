package org.apache.jsp.administrateur.Consulter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modele.ProfesseursModele;
import modele.MatieresModele;
import java.util.List;
import java.util.ArrayList;
import modele.GradeModele;
import dao.InsertionDao;

public final class ConsulterMatieres_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("\n");

    InsertionDao listeGrade = new InsertionDao();
    List<GradeModele> grades = new ArrayList<GradeModele>();
    grades = listeGrade.findGrade();
    
    MatieresModele matieres = new MatieresModele();
    List<MatieresModele> mat = new ArrayList<MatieresModele>();

      out.write('\n');

      out.write('\n');
 for(GradeModele listeGrades : grades){ 
      out.write("\n");
      out.write("\n");
      out.write(" ");
 out.print("<h1> Grade :"+listeGrades.getGrade()+" </h1>"); 
      out.write('\n');
 
     mat = listeGrade.findMatieresByGrade(listeGrades.getGrade());

      out.write("\n");
      out.write("<table class=\"consultMat\"> \n");
      out.write("    <tr>\n");
      out.write("        <th> Matière </th>\n");
      out.write("        <th> Coefficient </th>\n");
      out.write("        <th> Professeur </th>\n");
      out.write("        <th> Grade </th>\n");
      out.write("        <th> Actions </th>\n");
      out.write("    </tr>\n");
      out.write("   \n");
      out.write("        \n");
      out.write("                ");

                    for(MatieresModele matiere: mat)
                   {
                        int num_matiere = matiere.getNum_matiere();
                        int num_prof = listeGrade.findNumProf(num_matiere);
                        ProfesseursModele prof = new ProfesseursModele();
                         prof = listeGrade.findProfByNum(num_prof);
                
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                    <td> ");
 out.print(matiere.getNom_matiere()) ;
      out.write("  </td>\n");
      out.write("                    <td> ");
 out.print(matiere.getCoefficient()) ;
      out.write("  </td>\n");
      out.write("\n");
      out.write("                    <td> ");
 out.print(prof.getNom_prof() +"  "+prof.getPrenom_prof()) ;
      out.write(" </td>\n");
      out.write("\n");
      out.write("                    <td> ");
 out.print(matiere.getGrade()); 
      out.write(" </td>\n");
      out.write("                      <td> ");
 out.print(listeGrades.getGrade()); 
      out.write("  </td>\n");
      out.write("                     </tr>\n");
      out.write("                  ");
 } 
      out.write("\n");
      out.write("      \n");
      out.write("        \n");
      out.write("   \n");
      out.write("</table>\n");
      out.write("        \n");
 } 
      out.write('\n');
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
