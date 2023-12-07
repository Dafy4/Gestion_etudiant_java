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
import modele.EtudiantsModele;

/**
 *
 * @author ORDI
 */
public class AjoutsEtudiantsServlet extends HttpServlet {

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
           
            //PARAMETRE OBTENUE VIA LE FORMULAIRE
            
            String grade = request.getParameter("grade");
            String anne_scolaire = request.getParameter("anne_scolaire");
            String num_matr = request.getParameter("num_matr");
            String nom_etudiant = request.getParameter("nom_etudiant");
            String prenom_etudiant = request.getParameter("prenom_etudiant");
            String date_naissance = request.getParameter("date_nais");
            String adresse = request.getParameter("adresse");
            String num_tel_etudiant1 = request.getParameter("num_tel");
            int num_tel_etudiant = Integer.valueOf(num_tel_etudiant1);
            String etablissement_prec = request.getParameter("etab_prec");
            String nom_mere = request.getParameter("nom_mere");
            String num_mere1 = request.getParameter("num_mere");
            int num_mere = Integer.valueOf(num_mere1);
            String nom_pere = request.getParameter("nom_pere");
            String num_pere1 = request.getParameter("num_pere");
            int num_pere = Integer.valueOf(num_pere1);
            String nom_tuteur = request.getParameter("nom_tuteur");
            String num_tuteur1 = request.getParameter("num_tuteur");
            int num_tuteur = Integer.valueOf(num_tuteur1);
            
            //ENVOIE DES INFORMATIONS DANS ETUDIANTSMODELE
            EtudiantsModele etudiant = new EtudiantsModele();
            
            etudiant.setGrade(grade);
            etudiant.setNum_matr(num_matr);
            etudiant.setNom(nom_etudiant);
            etudiant.setPrenom(prenom_etudiant);
            etudiant.setDate_nais(date_naissance);
            etudiant.setAdresse(adresse);
            etudiant.setNum_tel(num_tel_etudiant);
            etudiant.setEtablissement_prec(etablissement_prec);
            etudiant.setNom_mere(nom_mere);
            etudiant.setNum_tel_mere(num_mere);
            etudiant.setNom_pere(nom_pere);
            etudiant.setNum_tel_pere(num_pere);
            etudiant.setNom_tuteur(nom_tuteur);
            etudiant.setNum_tel_tuteur(num_tuteur);
            
            //INSERTION DANS BDD
            InsertionDao insert = new InsertionDao();
            insert.InsertionEtudiants(etudiant);
            insert.InsertEtudiantArchive(grade, anne_scolaire, etudiant);
            
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
