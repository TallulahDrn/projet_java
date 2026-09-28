package com.mycompany.java_miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gère la connexion JDBC à la base aeroport_db.
 */
public final class ConnexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/aeroport_db"
            + "?serverTimezone=Europe/Paris&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "root";

    // Constructeur privé : on n'instancie pas cette classe
    private ConnexionDB() {
    }

    /** Ouvre une connexion à la base. */
    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
    }

    /** Test de connexion : lancer avec Shift+F6. */
    public static void main(String[] args) {
        try (Connection connexion = getConnexion()) {
            System.out.println("Connexion réussie à la base " + connexion.getCatalog());
        } catch (SQLException e) {
            System.err.println("Échec de la connexion : " + e.getMessage());
        }
    }
}