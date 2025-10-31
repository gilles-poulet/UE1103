package be.iramps.ue1103.BL;

/**
 * Classe permettant la modélisation d'un status d'une personne au sein
 * d'un établissement scolaire.
 */
public class Status {    
    private final int id;
    private String nom;


    /**
     * Construit un nouveau status
     * @param id  Identifiant du status
     * @param nom Nom du status
     */
    public Status(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    /**
     * Retourne l'identifiant dans la persistance
     * de données associé au status
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne le nom associé au status
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Nom est l'appellation humaine utilisée
     * pour identifier le status. 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }    
}
