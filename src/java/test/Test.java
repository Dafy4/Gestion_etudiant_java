/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AuthentificationDao;
import dao.InsertionDao;
import java.sql.SQLException;
import modele.EtudiantsModele;
import modele.GradeModele;
import modele.MatieresModele;
import modele.ProfesseursModele;
import modele.UserModele;

/**
 *
 * @author ORDI
 */
public class Test {
    public static void main(String[] args) throws SQLException
    {
        
        /*TEST D'AUTHENTIFICATION*/
        /*
        String nom_user = "Voni";
        String password = "admin";

        UserModele compte = new UserModele();
        compte.setNom_user(nom_user);
        compte.setPassword(password);

        AuthentificationDao dao = new AuthentificationDao();
        boolean verification = dao.verifUser(compte);
        System.out.println("verification = " + verification);
        System.out.print("type : " + compte.getType_user());
                */
        /*
        //TEST INSERTION ETUDIANTS
        
        EtudiantsModele etudiant = new EtudiantsModele();
            etudiant.setNum_matr("01-T");
            etudiant.setGrade("terminale");
            etudiant.setNom("ANDRIAMAHARIVONISOA");
            etudiant.setPrenom("Aina Dafy Ange");
            etudiant.setDate_nais("2022-11-29");
            etudiant.setAdresse("LOT 17H80 IVORY ANTSIRABEI");
       int num_tel = 38411;
            etudiant.setNum_tel(789);
            etudiant.setEtablissement_prec("IES-AV");
            etudiant.setNom_mere("NY-ANDRIANAIVOSOLO Noroarivony");
       int num_mere = 34175;
            etudiant.setNum_tel_mere(879);
            etudiant.setNom_pere("LANTOHELITIANA Dafy Angelo");
        int num_pere = 342175;
            etudiant.setNum_tel_pere(899);
            etudiant.setNom_tuteur("");
            etudiant.setNum_tel_tuteur(0);
        */    
            /*INSERTION DANS BDD*/
        /*
            InsertionDao insert = new InsertionDao();
            insert.InsertionEtudiants(etudiant);
            System.out.print("envoie réussie");
         */       
        /*
        //INSERTION CLASSES
        GradeModele classe = new GradeModele();
        classe.setGrade("seconde");
        classe.setOrgannisation_annee_scolaire("trimestre");
        classe.setEffectifs(50);
        
        InsertionDao insert = new InsertionDao();
        insert.InsertionGrade(classe);
        System.out.print("ok ok");
         */  
        
        //INSERTION PROFESSEUR
       /* ProfesseursModele prof = new ProfesseursModele();
        prof.setNum_prof("1-P");
        prof.setNom_prof("test");
        prof.setPrenom_prof("test");
        prof.setNum_tel_prof(231);
        prof.setAdresse("test");
        
         InsertionDao insert = new InsertionDao();
         insert.InsertionProfesseur(prof);
          System.out.print("ok ok");
               */
        //Create table par grade
      /* String grade = "6eme";
       InsertionDao insert = new InsertionDao();
       insert.createGrade(grade);
       System.out.print("ok ok");
              */
        
        //RECHERCHE NOM ET PRENOM PROF PAR ID 
        /*
        InsertionDao insert = new InsertionDao();
        String name = insert.nomProf("2");
        System.out.print("name = "+name);
                */
        
        //GET ID MATIERE 
        MatieresModele matiere = new MatieresModele();
        matiere.setNom_matiere("Mathematiques");
        matiere.setCoefficient(3);
        matiere.setGrade("6eme");
          InsertionDao insert = new InsertionDao();
          insert.insertMatieres(matiere);
          System.out.print("num_matiere = "+ matiere.getNum_matiere());
    }
    
}
