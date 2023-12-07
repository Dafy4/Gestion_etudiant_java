/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.InsertionDao;
import java.util.ArrayList;
import java.util.List;
import modele.MatieresModele;
import modele.ProfesseursModele;

/**
 *
 * @author ORDI
 */
public class TestMatieres {

    public static void main(String[] args)
    {
            MatieresModele matieres = new MatieresModele();
            InsertionDao dao = new InsertionDao();
            List<MatieresModele> mat = new ArrayList<MatieresModele>();
                 mat = dao.findMatieresByGrade("3eme");
                 for(MatieresModele matiere: mat)
                 {
                    System.out.println("num_matiere = "+  matiere.getNum_matiere());
                     System.out.println("nom_matiere = "+  matiere.getNom_matiere());
                      System.out.println("grade = "+matiere.getGrade());
                       System.out.println("coeff : "+ matiere.getCoefficient());
                    
                       int num_matiere = matiere.getNum_matiere();
                       System.out.println("num_matiere = "+ num_matiere);
                       
                    int num_prof = dao.findNumProf(num_matiere);
                    System.out.println("num_prof = "+ num_matiere);
                    
                    ProfesseursModele prof = new ProfesseursModele();
                    prof =   dao.findProfByNum(num_prof);
                    System.out.println("nom_prof : "+prof.getNom_prof());
                    System.out.println("prenom_prof : "+prof.getPrenom_prof());
                 }
            
            
    }
}
