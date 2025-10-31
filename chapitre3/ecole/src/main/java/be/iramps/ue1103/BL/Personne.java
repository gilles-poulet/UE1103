package be.iramps.ue1103.BL;

/**
 * Classe permettant la modélisation d'une personne
 * ayant trait à l'établissement scolaire.
 */
public class Personne {
    private final int id;
    private String nom;
    private String prénom;
    private Status statut;

    /**
     * Construit une personne
     * @param id  Identifiant de la personne
     * @param nom Nom de la personne
     * @param prenom Prenom de la seance
     * @param statut Statut de la personne au sein de l'établissement
     */
    public Personne(int id, String nom, String prénom, Status statut) {
        this.nom = nom;
        this.prénom = prénom;
        this.id = id;
        this.statut = statut;
    }

    /**
     * Retourne l'identifiant dans la persistance
     * de données associé à la personne
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne le nom de famille de la personne
     * @return String 
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Nom (de famille) est l'appellation humaine utilisée
     * pour identifier les personnes d'une même famille 
     * (au sens large). 
     * @param nom minimum 2 caractères
     */
    public void setNom(String nom) {
        this.nom = nom;
    }    

    /**
     * Retourne le prénom de la personne
     * @return String 
     */
    public String getPrénom() {
        return prénom;
    }

    /**
     * Prénom est l'appellation humaine utilisée pour 
     * identifier une personne précise d'un même famille.
     * @param prenom minimum 2 caractères
     */
    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    /**
     * Retourne le status de la personne au sein
     * de l'établissement
     * @return Status 
     */
    public Status getStatut() {
        return statut;
    }

    /**
     * Status indique la fonction (au sens large)
     *  au sein de l'établissement scolaire
     * @param statut
     */
    public void setStatut(Status statut) {
        this.statut = statut;
    }
}
