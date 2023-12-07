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
public class MatieresModele {
    private int num_matiere;
    private String grade;
    private String nom_matiere;
    private int coefficient;

    public int getNum_matiere() {
        return num_matiere;
    }

    public void setNum_matiere(int num_matiere) {
        this.num_matiere = num_matiere;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}
