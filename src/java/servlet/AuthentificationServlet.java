/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AuthentificationDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.UserModele;

/**
 *
 * @author ORDI
 */
public class AuthentificationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            /*On stocke les valeurs saisies par l'utilisateur*/
            String nom_user = request.getParameter("user");
           String password = request.getParameter("password");
            
            /*On envoie ces valeurs pour être stockées dans UserModele*/
            UserModele user = new UserModele();
            user.setNom_user(nom_user);
            user.setPassword(password);
            
            AuthentificationDao dao = new AuthentificationDao();
            boolean verification = dao.verifUser(user);
            String type_user = user.getType_user();
            /*Si la personne est bien un utilisateur*/
            if(verification == true)
            {
                
                if(type_user.equals("admin"))
                {
                    request.getRequestDispatcher("pageReloader/pages.jsp").forward(request, response);
                }
                else
                {
                    if(type_user.equals("etudiant"))
                    {
                        request.getRequestDispatcher("pageReloader/pageEtudiant.jsp").forward(request, response);
                    }
                    else
                    {
                         request.getRequestDispatcher("pageReloader/pageProfesseur.jsp").forward(request, response);
                    }
                }
                
            }
            else{
                out.print("Vous ne faites pas parmis nos utilisateurs");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
             
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AuthentificationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
