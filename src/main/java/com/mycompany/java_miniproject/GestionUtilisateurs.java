package com.mycompany.java_miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Gère l'authentification à partir de la table utilisateur.
 */
public class GestionUtilisateurs {

    /** Renvoie true si le login et le mot de passe sont corrects. */
    public boolean verifierConnexion(String login, String motDePasse) throws SQLException {
        String sql = "SELECT id_utilisateur FROM utilisateur "
                + "WHERE login = ? AND mot_de_passe = SHA2(?, 256)";
        try (Connection connexion = ConnexionDB.getConnexion();
             PreparedStatement requete = connexion.prepareStatement(sql)) {
            requete.setString(1, login);
            requete.setString(2, motDePasse);
            try (ResultSet resultat = requete.executeQuery()) {
                return resultat.next(); // true si une ligne a été trouvée
            }
        }
    }
}