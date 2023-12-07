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
import modele.GradeModele;

/**
 *
 * @author ORDI
 */
public class InsertionGradeServlet extends HttpServlet {

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
            int nbre = Integer.valueOf(request.getParameter("nbre"));
            
            String confirmation = null;
            String grade = null;
            String organisation = null;
            int effectifs = 0;
            for(int i = 1; i <= nbre ; i++)
            {
                grade = request.getParameter("grade"+i);
                organisation = request.getParameter("org"+i);
                effectifs = Integer.valueOf(request.getParameter("efectifs"+i)) ;
            
                /*MODELE*/
             
                GradeModele classe = new GradeModele();
                classe.setGrade(grade);
                classe.setOrganisation_annee_scolaire(organisation);
                classe.setEffectifs(effectifs);
            
                /*DAO insertion*/
            
                InsertionDao insert = new InsertionDao();
                insert.InsertionGrade(classe);
                insert.createGrade(grade);
            }
            confirmation = "Formulaire envoyé avec succès";
            request.getRequestDispatcher("pageServlet?page=Ajouts&action=ajoutClasses&confirmation="+confirmation).forward(request, response);
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
