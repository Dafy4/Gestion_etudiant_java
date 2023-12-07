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
public class GradeModele {
    String grade;
    String organisation_annee_scolaire;
    int effectifs;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getOrganisation_annee_scolaire() {
        return organisation_annee_scolaire;
    }

    public void setOrganisation_annee_scolaire(String organisation_annee_scolaire) {
       this.organisation_annee_scolaire = organisation_annee_scolaire;
    }

    public int getEffectifs() {
        return effectifs;
    }

    public void setEffectifs(int effectifs) {
        this.effectifs = effectifs;
    }
}
