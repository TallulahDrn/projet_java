package com.mycompany.java_miniproject;

public class Java_miniproject {

    public static void main(String[] args) {
    try {
        for (Voyageur v : new GestionVoyageurs().lister()) {
            System.out.println(v.getDescription());
        }
    } catch (java.sql.SQLException e) {
        System.err.println("Erreur : " + e.getMessage());
    }
}
}
