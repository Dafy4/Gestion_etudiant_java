/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ORDI
 */
public class ProfesseursModele {
    private int id_user;
    private String num_prof;
    private String nom_prof;
    private String prenom_prof;
    private int num_tel_prof;
    private String adresse;

     public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getNum_prof() {
        return num_prof;
    }

    public void setNum_prof(String num_prof) {
        this.num_prof = num_prof;
    }

    public String getNom_prof() {
        return nom_prof;
    }

    public void setNom_prof(String nom_prof) {
        this.nom_prof = nom_prof;
    }

    public String getPrenom_prof() {
        return prenom_prof;
    }

    public void setPrenom_prof(String prenom_prof) {
        this.prenom_prof = prenom_prof;
    }

    public int getNum_tel_prof() {
        return num_tel_prof;
    }

    public void setNum_tel_prof(int num_tel_prof) {
        this.num_tel_prof = num_tel_prof;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
