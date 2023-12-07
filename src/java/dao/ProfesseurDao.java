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
import modele.EnseignerModele;
import modele.MatieresModele;

/**
 *
 * @author ORDI
 */
public class ProfesseurDao {
    public int getNumProfByIdUser(int id_user)
    {
        int num = 0;
        
        String sql = "SELECT num_prof FROM professeur WHERE id_user = '"+id_user+"' ";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        ResultSet res = access.executeSelect(sql);
        
        try {
            while(res.next())
            {
                num = Integer.valueOf(res.getString("num_prof"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    
    public List<EnseignerModele> findNuMatiere(int num_prof)
    {
        List<EnseignerModele> enseigner = new ArrayList<EnseignerModele>();
        EnseignerModele enseignerM = new EnseignerModele();
        
        String sql = "SELECT num_matiere FROM enseigner WHERE num_prof = '"+num_prof+"'";
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        ResultSet res = access.executeSelect(sql);
        
        try {
            while(res.next())
            {
                enseignerM.setNum_enseigner(Integer.valueOf(res.getString("num_matiere")));
                enseignerM.setNum_enseigner(Integer.valueOf(res.getString("num_enseigner")) );
                enseigner.add(enseignerM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enseigner;
    }
    /*
    public List<MatieresModele> findMatieres(List<EnseignerModele> listeNumMatieres)
    {
        List<MatieresModele> matieres = new ArrayList<MatieresModele>();
        
        
        String sql = "SELECT * FROM matiere WHERE num_matiere = '"+num_matiere+"'";
        return matieres;
    }
    */
}
