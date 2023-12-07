/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.AccessBdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.ApprendreModele;
import modele.EnseignerModele;
import modele.EtudiantsModele;
import modele.GradeModele;
import modele.MatieresModele;
import modele.ProfesseursModele;
import modele.UserModele;

/**
 *
 * @author ORDI
 */
public class InsertionDao {
    //private List<EtudiantsModele> etudiants;
    public void InsertionGrade(GradeModele classe)
    {
        String sql = "INSERT INTO classe(grade,organisation_annee_scolaire,effectifs) VALUES"
                + " ('"+ classe.getGrade() +"', '"+ classe.getOrganisation_annee_scolaire()+"', '"+classe.getEffectifs()+"')";
        
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
    }
    public void InsertionEtudiants(EtudiantsModele etudiants)
    {
        String sql = "INSERT INTO etudiant(num_matr,grade,nom,prenom,date_nais,adresse,num_tel,etablissement_prec,nom_mere,num_tel_mere,nom_pere,num_tel_pere,nom_tuteur,num_tel_tuteur) VALUES"
                + " ('"+etudiants.getNum_matr()+"', '"+etudiants.getGrade()+"', "
                + " '" + etudiants.getNom() +"' ,"
                + " '"+ etudiants.getPrenom() +"', " 
                + " '" + etudiants.getDate_nais() + "' , '" + etudiants.getAdresse()+ "', "
                + " '" + etudiants.getNum_tel()+ "', '" +  etudiants.getEtablissement_prec()+ "' , "
                + " '" + etudiants.getNom_mere() + "' , '" + etudiants.getNum_tel_mere() +"' , "
                + " '" + etudiants.getNom_pere() + "' , '" + etudiants.getNum_tel_pere() + "' , "
                + " '" + etudiants.getNom_tuteur()+ "', '" + etudiants.getNum_tel_tuteur() +"') ";
        
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
    }
    public void InsertEtudiantArchive(String grade,String annee_scolaire, EtudiantsModele etudiant)
    {
        String sql = "INSERT INTO "+grade+"(num_matr, nom, prenom, annee_scolaire) VALUES("
                + "'"+etudiant.getNum_matr()+"',"
                + " '"+etudiant.getNom()+"',"
                + " '"+etudiant.getPrenom()+"',"
                + " '"+annee_scolaire+"' "
                + ") ";
        
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
    }
    public List<GradeModele> findGrade()
    {
        List<GradeModele> grades = new ArrayList<GradeModele>();
        String sql = "SELECT * FROM classe";
        
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        
        ResultSet resultat = access.executeSelect(sql);
        try {
            while(resultat.next())
            {
                GradeModele grade = new GradeModele();
                grade.setGrade(resultat.getString("grade"));
                grade.setOrganisation_annee_scolaire(resultat.getString("organisation_annee_scolaire"));
                grade.setEffectifs(Integer.valueOf(resultat.getString("effectifs")));
                
                grades.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grades;
    }
    
    public List<EtudiantsModele> findEtudiants(String grade)
    {
            String sql = "SELECT * FROM etudiant WHERE grade = '"+ grade+"' ";
            
            AccessBdd access = new AccessBdd();
            access.loadDriver();
            
            ResultSet resultat = access.executeSelect(sql);
            
            List <EtudiantsModele> etudiants = new ArrayList<EtudiantsModele>();
            try {
                    while(resultat.next())
                    {
                        EtudiantsModele etudiant = new EtudiantsModele();
                        etudiant.setNom(resultat.getString("nom"));
                        etudiant.setPrenom(resultat.getString("prenom"));
                        etudiant.setNum_tel(Integer.valueOf(resultat.getString("num_tel")));
                        etudiant.setDate_nais(resultat.getString("date_nais"));
                        etudiant.setAdresse(resultat.getString("adresse"));
                        etudiant.setEtablissement_prec(resultat.getString("etablissement_prec"));
                        etudiant.setNom_mere(resultat.getString("nom_mere"));
                        etudiant.setNum_tel_mere(Integer.valueOf(resultat.getString("num_tel_mere")));
                        etudiant.setNom_pere(resultat.getString("nom_pere"));
                        etudiant.setNum_tel_pere(Integer.valueOf(resultat.getString("num_tel_pere")));
                        etudiant.setNom_tuteur(resultat.getString("nom_tuteur"));
                        etudiant.setNum_tel_tuteur(Integer.valueOf(resultat.getString("num_tel_tuteur")));

                        etudiants.add(etudiant);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        return etudiants;
    }
    
    public void InsertionProfesseur(ProfesseursModele professeur)
    {
        String sql = "INSERT INTO professeur(num_prof,nom_prof,prenom_prof,num_tel_prof,adresse_prof) VALUES"
                + "( '"+professeur.getNum_prof()+"' ,"
                + " '"+professeur.getNom_prof()+"' ,"
                + " '"+professeur.getPrenom_prof()+"' ,"
                + " '"+professeur.getNum_tel_prof()+"',"
                + " '"+professeur.getAdresse()+"' )";
         AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
    }
    public List<ProfesseursModele> listeProfesseur(){
        List<ProfesseursModele> listeProfesseur = new ArrayList<ProfesseursModele>();
        String sql = "SELECT * FROM professeur";
        
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        
        ResultSet resultat = access.executeSelect(sql);
        try {
            while(resultat.next())
            {
                ProfesseursModele prof = new ProfesseursModele();
                prof.setNum_prof(resultat.getString("num_prof"));
                prof.setNom_prof(resultat.getString("nom_prof"));
                prof.setPrenom_prof(resultat.getString("prenom_prof"));
                prof.setAdresse(resultat.getString("adresse_prof"));
                prof.setNum_tel_prof(Integer.valueOf(resultat.getString("num_tel_prof")));
                listeProfesseur.add(prof);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProfesseur;
    }
    
   public String nomProf(String id)
   {
      
       String name = null;
       String nom = null;
       String prenom = null;
       
       String sql = "SELECT nom_prof,prenom_prof FROM professeur WHERE num_prof = "+id;
       
       AccessBdd access = new AccessBdd();
       access.loadDriver();
      ResultSet resultat = access.executeSelect(sql);
        try {
            while(resultat.next())
            {
                nom = resultat.getString("nom_prof");
                prenom = resultat.getString("prenom_prof");
                name = nom +" "+ prenom;
                
            } } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return name;
   }
   
    public void createGrade(String grade){
        String sql = "CREATE TABLE "+grade+"("
                + "id INT(11),"
                + "num_matr INT(11),"
                + "nom VARCHAR(50),"
                + "prenom VARCHAR(50),"
                + "annee_scolaire VARCHAR(20),"
                + "PRIMARY KEY (id),"
                + "FOREIGN KEY(num_matr) REFERENCES etudiant(num_matr) "
                + ")";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
    }
    
    public void insertMatieres(MatieresModele matiere)
    {
        String sql = "INSERT INTO matiere(nom_matiere,coefficient,grade) VALUES ("
                + " '"+matiere.getNom_matiere()+"',"
                + " '"+matiere.getCoefficient()+"',"
                + " '"+matiere.getGrade()+"' "
                + ")";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
        
        String requete = "SELECT num_matiere FROM matiere WHERE nom_matiere='"+matiere.getNom_matiere()+"' AND coefficient ='"+matiere.getCoefficient()+"' AND grade='"+matiere.getGrade()+"' ";
        ResultSet result = access.executeSelect(requete);
        
        try {
            while(result.next())
            {
               matiere.setNum_matiere(Integer.valueOf(result.getString("num_matiere"))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        access.closeConnection();
    }
    
    public void insertEnseigner(EnseignerModele enseigne)
    {
        String sql = "INSERT INTO enseigner(num_matiere, num_prof) VALUES("
                + " '"+enseigne.getNum_matiere()+"',"
                + " '"+enseigne.getNum_prof()+"' "
                + ")";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
        access.closeConnection();
    }
    public void insertApprendre(ApprendreModele apprendre)
    {
        String sql = "INSERT INTO apprendre(grade,num_matiere) VALUES ("
                + " '"+apprendre.getGrade()+"',"
                + " '"+apprendre.getNum_matiere()+"' "
                + ")";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
        access.closeConnection();
    }
    public List<MatieresModele> findMatieres()
    {
        
        List<MatieresModele> matieres = new ArrayList<MatieresModele>();
        
        String sql = "SELECT * FROM matiere";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeSelect(sql);
        
        ResultSet res = access.executeSelect(sql);
        
        try {
            while(res.next())
            {
                MatieresModele mat = new MatieresModele();
                mat.setNum_matiere(Integer.valueOf(res.getString("num_matiere")));
                mat.setNom_matiere(res.getString("nom_matiere"));
                mat.setCoefficient(Integer.valueOf(res.getString("coefficient")));
                mat.setGrade(res.getString("grade"));
                matieres.add(mat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matieres;
    }
    
    public List<MatieresModele> findMatieresByGrade(String grade)
    {
         List<MatieresModele> matieres = new ArrayList<MatieresModele>();
        
        String sql = "SELECT * FROM matiere WHERE grade='"+grade+"'";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeSelect(sql);
        
        ResultSet res = access.executeSelect(sql);
        
        try {
            while(res.next()) 
            {
                MatieresModele mat = new MatieresModele();
                mat.setNum_matiere(Integer.valueOf(res.getString("num_matiere")));
                mat.setNom_matiere(res.getString("nom_matiere"));
                mat.setCoefficient(Integer.valueOf(res.getString("coefficient")));
                mat.setGrade(res.getString("grade"));
                matieres.add(mat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matieres;
    }
    public int findNumProf(int num_matiere)
    {
        int num_prof = 0;
        String sql = "SELECT num_prof FROM enseigner WHERE num_matiere = '"+num_matiere+"'";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeSelect(sql);
        
        ResultSet res = access.executeSelect(sql);
        
        try {
            while(res.next())
            {
                num_prof = Integer.valueOf(res.getString("num_prof"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return num_prof;
    }
    public ProfesseursModele findProfByNum(int num_prof)
    {
        ProfesseursModele prof = new ProfesseursModele();
        String sql = "SELECT * FROM professeur WHERE num_prof = '"+num_prof+"'"; 
        
         AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeSelect(sql);
        
        ResultSet res = access.executeSelect(sql);
        
        try {
            while(res.next())
            {
                prof.setNum_prof(res.getString("num_prof"));
                prof.setNom_prof(res.getString("nom_prof"));
                prof.setPrenom_prof(res.getString("prenom_prof"));
                prof.setNum_tel_prof(Integer.valueOf(res.getString("num_tel_prof")));
                prof.setAdresse(res.getString("adresse_prof"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prof;
    }
    
    public int createAccountProf(UserModele user)
    {
        String sql = "INSERT INTO user(nom_user,password,type_user) VALUES ("
                + " '"+user.getNom_user()+"',"
                + " '"+user.getPassword()+"',"
                + " '"+user.getType_user()+"' "
                + ")";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        access.executeUpdate(sql);
        
        String requete = "SELECT id_user FROM user WHERE nom_user ='"+user.getNom_user()+"' AND password = '"+user.getPassword()+"' AND type_user ='"+user.getType_user()+"' ";
        access.executeSelect(requete);
        ResultSet resultat = access.executeSelect(requete);
        int id = 0;
        try {
            while(resultat.next())
            {
                id =Integer.valueOf(resultat.getString("id_user")) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        access.closeConnection();
        return id;
    }
    public int findIdUser(String user, String password)
    {
        
        String sql = "SELECT id_user FROM user WHERE nom_user = '"+user+"' AND password = '"+password+"'";
         AccessBdd access = new AccessBdd();
         access.loadDriver();
         access.executeSelect(sql);
        ResultSet resultat = access.executeSelect(sql);
        int id = 0;
        try {
            while(resultat.next())
            {
                  id =Integer.valueOf(resultat.getString("id_user")) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int Inscrits(String grade) 
    {
        int nbre = 0;
        String sql = "SELECT id FROM "+grade+"" ;
         AccessBdd access = new AccessBdd();
         access.loadDriver();
          ResultSet resultat = access.executeSelect(sql);
        try {
            while(resultat.next())
            {
                nbre++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbre;
    }
}
