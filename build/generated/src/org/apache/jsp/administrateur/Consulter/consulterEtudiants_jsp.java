package org.apache.jsp.administrateur.Consulter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modele.EtudiantsModele;
import java.util.List;
import java.util.ArrayList;
import modele.GradeModele;
import dao.InsertionDao;

public final class consulterEtudiants_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("  <h1>Choisissez dans quelle grade voulez-vous consulter : </h1>\n");

     InsertionDao liste = new InsertionDao();
    List<GradeModele> grades = new ArrayList<GradeModele>();
    
    grades = liste.findGrade();
    int i;
        i = 1;
         for(GradeModele listeGrade : grades)
        {
            out.println(" <a href='ChoixGradeServlet?grade="+listeGrade.getGrade()+"'><button class='grade' id='gradeSelect"+i+"'>"+ listeGrade.getGrade() +"</button> </a>");
            i++;
        }

      out.write("\n");
      out.write("           \n");

          
         String grade = request.getParameter("grade");
         out.print("<h2>"+ grade+ "</h2>");
         
         if(grade != null)
         {
            InsertionDao listeEt = new InsertionDao();
            List<EtudiantsModele> listeEtudiants = new ArrayList<EtudiantsModele>();
            listeEtudiants = listeEt.findEtudiants(grade);
            
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Numero matricule</th>\n");
      out.write("                    <th> Nom et prénoms</th>\n");
      out.write("                    <th> Téléphone </th>\n");
      out.write("                    <th>Adresse </th>\n");
      out.write("                    <th>Date de naissance </th>\n");
      out.write("                    <th>Etablissement précédent </th>\n");
      out.write("                    <th>Mère</th>\n");
      out.write("                    <th>Père</th>\n");
      out.write("                    <th>Tuteur</th>\n");
      out.write("                </tr>\n");
      out.write("        \n");
      out.write("          ");
for(EtudiantsModele etudiant : listeEtudiants){ 
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                    <td> ");
 out.println(etudiant.getNum_matr());
      out.write(" </td>\n");
      out.write("                        <td> ");
 out.println(etudiant.getNom() +" "+etudiant.getPrenom()); 
      out.write(" </td>\n");
      out.write("                        <td> ");
 out.println(etudiant.getNum_tel()) ;
      out.write("</td>\n");
      out.write("                        <td> ");
out.println(etudiant.getAdresse()) ;
      out.write("</td>\n");
      out.write("                        <td> ");
out.println(etudiant.getDate_nais()) ;
      out.write("</td>\n");
      out.write("                        <td> ");
out.println(etudiant.getEtablissement_prec()) ;
      out.write("</td>\n");
      out.write("                        <td> ");
out.println(etudiant.getNom_mere()+"("+  etudiant.getNum_tel_mere() +")")  ; 
      out.write(" </td>\n");
      out.write("                        <td> ");
out.println(etudiant.getNom_pere() +"("+   etudiant.getNum_tel_pere() +")") ;
      out.write(" </td>\n");
      out.write("                        <td> ");
out.println(etudiant.getNom_tuteur() +"("+  etudiant.getNum_tel_tuteur() +")" );
      out.write(" </td>\n");
      out.write("                    </tr>\n");
      out.write("               ");
}
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("         </table>");
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
