package org.apache.jsp.administrateur.Ajouts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajoutClasses_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("<h1>Classes!</h1>\n");
      out.write("<div class=\"formulaireClasse\">\n");
      out.write("    <form action=\"NombreAjoutServlet\" method=\"post\">\n");
      out.write("        <label for=\"Nbre_classe\"> Combien de grades voulez-vous ajouter? </label>\n");
      out.write("        <input type=\"number\" name=\"nbre_classe\" id=\"Nbre_classe\" min=\"1\">\n");
      out.write("        <input type=\"submit\" class=\"btn-nbre-ajout-classe\" name=\"nbre-ajout\" value=\"valider\">\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("     ");

         
         int nbre = Integer.valueOf(request.getParameter("nbre_ajout"));
         out.print("nbre = " + nbre);
         /*
         int nbre = Integer.valueOf(request.getParameter("nbre")) ;
         if(nbre != 0)
         {
             for(int i = nbre ; i <= nbre ; i++)
             {
                out.print(" <form action='' method='post'> ");
                out.print(" <label for='Grade'> Grade </label>");
                out.print(" <div>");
                out.print(" <input type='text' id='Grade' name='grade' placeholder='seconde'>");
                out.print(" </div>");
                out.print("  <div>");
                out.print("<label for='Org'> Organisatiion année scolaire </label> ");
                out.print("<input type='text' name='org' id='Org' placeholder='@semestre ou @trimestre' >");
                out.print("   </div>");
                out.print("<div>");
                out.print(" <label for='Effectifs'> Effectifs </label>");
                out.print("<input type='text' name='efectifs' id='Effectifs'>");
                out.print("</div>");
                out.print("<input type='submit' id='envoyerClasse' value='Envoyer'>");
                out.print("<input type='reset' id='annulerClasse' value='Annuler'>");
                out.print("</form>");
                out.print("");
             }
         }
            */     
     
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
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
