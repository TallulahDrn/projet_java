package com.mycompany.java_miniproject;

import java.time.LocalDate;

/**
 * Voyageur enregistré à l'aéroport. Hérite de Personne.
 */
public class Voyageur extends Personne {

    private int id;
    private String numPasseport;
    private String email;
    private String telephone;
    private String numVol;
    private String destination;
    private LocalDate dateVol;
    private String classe;
    private int nbBagages;
    private boolean repasSpecial;
    private boolean assistancePmr;
    private String remarques;
    private String photo;

    public Voyageur() {
    }

    public Voyageur(String nom, String prenom, String sexe, LocalDate dateNaissance,
                    String nationalite, String numPasseport, String email, String telephone,
                    String numVol, String destination, LocalDate dateVol, String classe,
                    int nbBagages, boolean repasSpecial, boolean assistancePmr,
                    String remarques, String photo) {
        super(nom, prenom, sexe, dateNaissance, nationalite); // appelle le constructeur de Personne
        this.numPasseport = numPasseport;
        this.email = email;
        this.telephone = telephone;
        this.numVol = numVol;
        this.destination = destination;
        this.dateVol = dateVol;
        this.classe = classe;
        this.nbBagages = nbBagages;
        this.repasSpecial = repasSpecial;
        this.assistancePmr = assistancePmr;
        this.remarques = remarques;
        this.photo = photo;
    }

    /** Redéfinition de la méthode abstraite (polymorphisme). */
    @Override
    public String getDescription() {
        return toString() + " - vol " + numVol + " vers " + destination + " (" + classe + ")";
    }

    // Getters et setters : à générer avec Alt+Insert

    public int getId() {
        return id;
    }

    public String getNumPasseport() {
        return numPasseport;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNumVol() {
        return numVol;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDateVol() {
        return dateVol;
    }

    public String getClasse() {
        return classe;
    }

    public int getNbBagages() {
        return nbBagages;
    }

    public boolean isRepasSpecial() {
        return repasSpecial;
    }

    public boolean isAssistancePmr() {
        return assistancePmr;
    }

    public String getRemarques() {
        return remarques;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumPasseport(String numPasseport) {
        this.numPasseport = numPasseport;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateVol(LocalDate dateVol) {
        this.dateVol = dateVol;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setNbBagages(int nbBagages) {
        this.nbBagages = nbBagages;
    }

    public void setRepasSpecial(boolean repasSpecial) {
        this.repasSpecial = repasSpecial;
    }

    public void setAssistancePmr(boolean assistancePmr) {
        this.assistancePmr = assistancePmr;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}