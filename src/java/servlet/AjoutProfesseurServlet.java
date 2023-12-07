/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.InsertionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.ProfesseursModele;
import modele.UserModele;

/**
 *
 * @author ORDI
 */
public class AjoutProfesseurServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String nom_user = request.getParameter("prenom_prof");
            String type_User = "professeur";
            String mdp_prof = request.getParameter("mdp_prof");
            UserModele user = new UserModele();
            user.setNom_user(nom_user);
            user.setPassword(mdp_prof);
            user.setType_user(type_User);
            
            
            String nom = request.getParameter("nom_prof");
            
            String prenom = request.getParameter("prenom_prof");
            String adresse = request.getParameter("adresse_prof");
            int num_tel = Integer.valueOf(request.getParameter("tel_prof"));
            ProfesseursModele professeur = new ProfesseursModele();
            
            InsertionDao insertProf = new InsertionDao();
            int id = insertProf.createAccountProf(user);
            professeur.setId_user(id);
            professeur.setNom_prof(nom);
            professeur.setPrenom_prof(prenom);
            professeur.setAdresse(adresse);
            professeur.setNum_tel_prof(num_tel);
            
            
            insertProf.InsertionProfesseur(professeur);
           
            
            request.getRequestDispatcher("pageReloader/pages.jsp?page=Ajouts&action=confirmation").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
