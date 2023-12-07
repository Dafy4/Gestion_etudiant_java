/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.AccessBdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.UserModele;

/**
 *
 * @author ORDI
 */
public class AuthentificationDao {
    public boolean verifUser(UserModele user) throws SQLException
    {   
        boolean authentification = false;
        String sql = "SELECT * FROM user WHERE nom_user = '" + user.getNom_user() + "' AND " 
                + "password = '" + user.getPassword() + "' ";
        
        AccessBdd access = new AccessBdd();
        access.loadDriver();
        ResultSet resultat = access.executeSelect(sql);
        
        while(resultat.next())
        {
            authentification = true;
            /*Prend le type d'utilisateur de la personne qui se connecte*/
            user.setType_user(resultat.getString("type_user"));
        }
        access.closeConnection();
        return authentification;
    }
    
    
}
