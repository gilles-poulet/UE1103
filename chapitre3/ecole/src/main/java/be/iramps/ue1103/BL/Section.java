package be.iramps.ue1103.BL;

import java.util.ArrayList;

/**
 * Classe permettant la modélisation d'une section (de cours).
 */
public class Section {
    private final int id;
    private String nom;
    private final ArrayList<Cours> cours;

    /**
     * Construit une nouvelle section de cours
     * @param id  Identifiant de la section
     * @param nom Nom de la section
     */
    public Section(int id, String nom ) {
        this.id = id;
        this.nom = nom;
        this.cours = new ArrayList<Cours>();
    }

    /**
     * Retourne l'identifiant dans la persistance
     * de données associé à la section
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne le nom associé à la section
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Nom est l'appellation humaine utilisée
     * pour identifier la section. 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'ensemble des cours de la section
     * @return ArrayList<Cours>
     */
    public ArrayList<Cours> getCours() {
        return cours;
    } 
}