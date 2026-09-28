package com.mycompany.java_miniproject;

import java.time.LocalDate;

/**
 * Classe abstraite représentant une personne.
 * Elle ne peut pas être instanciée directement.
 */
public abstract class Personne {

    private String nom;
    private String prenom;
    private String sexe;
    private LocalDate dateNaissance;
    private String nationalite;

    public Personne() {
    }

    public Personne(String nom, String prenom, String sexe,
                    LocalDate dateNaissance, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
    }

    /** Méthode abstraite : chaque sous-classe donne sa propre description. */
    public abstract String getDescription();

    @Override
    public String toString() {
        return prenom + " " + nom;
    }

    // Getters et setters : à générer avec Alt+Insert

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    
}
