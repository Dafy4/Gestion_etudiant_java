package org.apache.jsp.professeur.Consulter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.ProfesseurDao;
import modele.UserModele;
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
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("\n");
      out.write(" ");
 
     
     //SESSION
            String username = (String)session.getAttribute("user") ; 
            out.print(username); 
            //id_user
            //int id = Integer.parseInt(session.getAttribute("id_user").toString()) ;
    // DAO
            //num_prof
            ProfesseurDao profDao = new ProfesseurDao();
            //int num =  profDao.getNumProfByIdUser(id);
            
 
      out.write('\n');

    
            

      out.write("\n");
      out.write("<h1> Vous êtes enseignant dans ces classes : </h1>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        <th> Grade </th>\n");
      out.write("        <th> Effectifs </th>\n");
      out.write("        <th> Matiere </th>\n");
      out.write("        <th> Coefficient </th>\n");
      out.write("    </tr>\n");
      out.write("   <tr>\n");
      out.write("      \n");
      out.write("   </tr>\n");
      out.write("   \n");
      out.write("</table>");
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
