package com.mycompany.java_miniproject;

import javax.swing.SwingUtilities;

public class Java_miniproject {

    public static void main(String[] args) {
        // Lance l'interface graphique : on commence par la fenêtre de connexion
        SwingUtilities.invokeLater(() -> new FenetreConnexion().setVisible(true));
    }
}