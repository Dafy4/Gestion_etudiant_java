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
import modele.ApprendreModele;
import modele.EnseignerModele;
import modele.MatieresModele;

/**
 *
 * @author ORDI
 */
public class AjoutMatieresServlet extends HttpServlet {

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
           String grade = request.getParameter("grade");
           int nbre = Integer.valueOf(request.getParameter("nbre"));
           
           String prof = null;
           String matiere = null;
           int num_prof;
           int coefficient;
           int num_matiere;
           
           InsertionDao insert = new InsertionDao();
           MatieresModele matieres = new MatieresModele();
           EnseignerModele enseigner = new EnseignerModele();
           ApprendreModele apprendre = new ApprendreModele();
           
           for(int i = 1 ; i <= nbre ; i++)
           {
               prof = request.getParameter("prof"+i);
               matiere = request.getParameter("matiere"+i);
               coefficient = Integer.valueOf(request.getParameter("coefficient"+i));
               num_prof = Integer.valueOf(request.getParameter("prof"+i));

               
               //MATIERES
               matieres.setNom_matiere(matiere);
               matieres.setCoefficient(coefficient);
               matieres.setGrade(grade);
               insert.insertMatieres(matieres);
               
               //ENSEIGNER
               num_matiere = matieres.getNum_matiere();
               enseigner.setNum_matiere(num_matiere);
               enseigner.setNum_prof(num_prof);
               insert.insertEnseigner(enseigner);
               
               //APPRENDRE
               apprendre.setGrade(grade);
               apprendre.setNum_matiere(num_matiere);
               insert.insertApprendre(apprendre);
           }
           
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
