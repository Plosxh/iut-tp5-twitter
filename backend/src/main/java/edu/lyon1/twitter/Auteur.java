package edu.lyon1.twitter;

/**
 * Created by pcharrat on 23/06/2017.
 */
import java.sql.Timestamp;


public class Auteur {

    private String handle;
    private Timestamp date;
    private String prenom;
    private String nom;

    public Auteur(String handle, Timestamp date, String prenom, String nom) {
        this.handle = handle;
        this.date = date;
        this.prenom = prenom;
        this.nom = nom;
    }
}
