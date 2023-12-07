package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <div class=\"image\">\n");
      out.write("            <img src=\"assets/login.png\">\n");
      out.write("        </div>\n");
      out.write("         <div class=\"authentification\"> \n");
      out.write("            <form action=\"AuthentificationServlet\" method=\"POST\">\n");
      out.write("                <h1> Authentification </h1>\n");
      out.write("                    <div class=\"nom_user\">\n");
      out.write("                        <div> <label for=\"utilisateur\"> Nom d'utilisateur </label> </div>\n");
      out.write("                        <div> <input type=\"text\" id=\"utilisateur\" name=\"user\"> </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <!-- <div class=\"type_user\">\n");
      out.write("                        <div> <label for=\"type_utilisateur\"> Qui êtes vous? </label> </div>\n");
      out.write("                        <div>\n");
      out.write("                            <select id=\"type_utilisateur\" name=\"type_user\">\n");
      out.write("                                <option> Administrateur </option>\n");
      out.write("                                <option> Professeur </option>\n");
      out.write("                                <option> Etudiant </option>\n");
      out.write("                                <option> Parent d'élève </option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div> -->\n");
      out.write("                    \n");
      out.write("                    <div class=\"user_password\">\n");
      out.write("                        <div>  <label for=\"password\"> Mot de passe </label> </div>\n");
      out.write("                        <div>  <input type=\"password\" id=\"password\" placeholder=\"***********\" name=\"password\"> </div>     \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                         <input type=\"submit\" value=\"Valider\">\n");
      out.write("                         <input type=\"reset\">\n");
      out.write("                    </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
