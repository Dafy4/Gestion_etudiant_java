/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.InsertionDao;
import dao.ProfesseurDao;
import modele.UserModele;

/**
 *
 * @author ORDI
 */
public class TestCreateAccount {
       public static void main(String[] args)
    {
        /*
        UserModele user = new UserModele();
        user.setNom_user("Soa");
        user.setPassword("professeur");
        user.setType_user("professeur");
        InsertionDao insert = new InsertionDao();
       int id = insert.createAccountProf(user);
      System.out.print(id);
                */
        /*
        ProfesseurDao prof = new ProfesseurDao();
        int id_user = 5;
        System.out.print(prof.getNumProfByIdUser(id_user));
         prof.getNumProfByIdUser(id_user);
        */
        /*
         InsertionDao dao = new InsertionDao();
         System.out.print(dao.findIdUser("Angelo", "professeur")); */
        
         InsertionDao dao = new InsertionDao();
         System.out.print(dao.Inscrits("6eme"));
         
    }
}
