package com.mycompany.java_miniproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Gère les opérations sur la table voyageur (ajout, modification, suppression, liste).
 */
public class GestionVoyageurs {

    /** Ajoute un nouveau voyageur dans la base. */
    public void ajouter(Voyageur v) throws SQLException {
        String sql = "INSERT INTO voyageur (nom, prenom, sexe, date_naissance, nationalite, "
                + "num_passeport, email, telephone, num_vol, destination, date_vol, classe, "
                + "nb_bagages, repas_special, assistance_pmr, remarques, photo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connexion = ConnexionDB.getConnexion();
             PreparedStatement requete = connexion.prepareStatement(sql)) {
            remplirParametres(requete, v);
            requete.executeUpdate();
        }
    }

    /** Modifie un voyageur existant, identifié par son id. */
    public void modifier(Voyageur v) throws SQLException {
        String sql = "UPDATE voyageur SET nom = ?, prenom = ?, sexe = ?, date_naissance = ?, "
                + "nationalite = ?, num_passeport = ?, email = ?, telephone = ?, num_vol = ?, "
                + "destination = ?, date_vol = ?, classe = ?, nb_bagages = ?, repas_special = ?, "
                + "assistance_pmr = ?, remarques = ?, photo = ? WHERE id_voyageur = ?";
        try (Connection connexion = ConnexionDB.getConnexion();
             PreparedStatement requete = connexion.prepareStatement(sql)) {
            remplirParametres(requete, v);
            requete.setInt(18, v.getId()); // le 18e "?" correspond au WHERE
            requete.executeUpdate();
        }
    }

    /** Supprime le voyageur dont l'id est donné. */
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM voyageur WHERE id_voyageur = ?";
        try (Connection connexion = ConnexionDB.getConnexion();
             PreparedStatement requete = connexion.prepareStatement(sql)) {
            requete.setInt(1, id);
            requete.executeUpdate();
        }
    }

    /** Renvoie la liste de tous les voyageurs de la base. */
    public ArrayList<Voyageur> lister() throws SQLException {
        ArrayList<Voyageur> voyageurs = new ArrayList<>();
        String sql = "SELECT * FROM voyageur ORDER BY id_voyageur";
        try (Connection connexion = ConnexionDB.getConnexion();
             PreparedStatement requete = connexion.prepareStatement(sql);
             ResultSet resultat = requete.executeQuery()) {
            while (resultat.next()) {
                voyageurs.add(creerVoyageur(resultat));
            }
        }
        return voyageurs;
    }

    /** Remplit les 17 "?" communs à l'ajout et à la modification. */
    private void remplirParametres(PreparedStatement requete, Voyageur v) throws SQLException {
        requete.setString(1, v.getNom());
        requete.setString(2, v.getPrenom());
        requete.setString(3, v.getSexe());
        requete.setDate(4, Date.valueOf(v.getDateNaissance()));
        requete.setString(5, v.getNationalite());
        requete.setString(6, v.getNumPasseport());
        requete.setString(7, v.getEmail());
        requete.setString(8, v.getTelephone());
        requete.setString(9, v.getNumVol());
        requete.setString(10, v.getDestination());
        requete.setDate(11, Date.valueOf(v.getDateVol()));
        requete.setString(12, v.getClasse());
        requete.setInt(13, v.getNbBagages());
        requete.setBoolean(14, v.isRepasSpecial());
        requete.setBoolean(15, v.isAssistancePmr());
        requete.setString(16, v.getRemarques());
        requete.setString(17, v.getPhoto());
    }

    /** Transforme une ligne de la table en objet Voyageur. */
    private Voyageur creerVoyageur(ResultSet resultat) throws SQLException {
        Voyageur v = new Voyageur(
                resultat.getString("nom"),
                resultat.getString("prenom"),
                resultat.getString("sexe"),
                resultat.getDate("date_naissance").toLocalDate(),
                resultat.getString("nationalite"),
                resultat.getString("num_passeport"),
                resultat.getString("email"),
                resultat.getString("telephone"),
                resultat.getString("num_vol"),
                resultat.getString("destination"),
                resultat.getDate("date_vol").toLocalDate(),
                resultat.getString("classe"),
                resultat.getInt("nb_bagages"),
                resultat.getBoolean("repas_special"),
                resultat.getBoolean("assistance_pmr"),
                resultat.getString("remarques"),
                resultat.getString("photo"));
        v.setId(resultat.getInt("id_voyageur"));
        return v;
    }

    /** Test temporaire : affiche les voyageurs de la base (Shift+F6). */
    public static void main(String[] args) {
        try {
            for (Voyageur v : new GestionVoyageurs().lister()) {
                System.out.println(v.getDescription());
            }
        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}