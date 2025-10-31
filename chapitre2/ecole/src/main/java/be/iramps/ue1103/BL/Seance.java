package be.iramps.ue1103.BL;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe permettant la modélisation d'une séance de cours.
 */
public class Seance {
    private final int id;
    private Cours cours;
    private Local local;
    private final ArrayList<Personne> presents;
    private java.time.LocalDate date;

    /**
     * Construit une nouvelle seance
     * @param id  Identifiant de la séance
     * @param cours Cours associé à la séance
     * @param local Local où se donne la séance
     * @param date Date à laquelle la séance se donne
     */
    public Seance(int id, Cours cours, Local local, LocalDate date) {
        this.id = id;
        this.cours = cours;
        this.local = local;
        this.date = date;
        this.presents = new ArrayList<Personne>();
    }

    /**
     * Retourne l'identifiant dans la persistance
     * de données associé à la séance
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retourne la date à laquelle la séance à
     * lieu
     * @return LocalDate
     */
    public java.time.LocalDate getDate() {
        return date;
    }

    /**
     * Date correspond à la date à laquelle
     * la séance à lieu 
     * @param date
     */
    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }

    /**
     * Retourne le cours associé à la séance
     * @return Cours
     */
    public Cours getCours() {
        return cours;
    }

    /**
     * Cours représente les informations nécessaires
     * a son traitement, telle que son nom ou 
     * les personnes inscrites dedans
     * @param Cours Le cours associé à la séance
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    /**
     * Retourne le local où se
     * donnera la séance
     * @return Local
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Local représente les informations nécessaires
     * à son traitement, telle que son type ou son 
     * numéro
     * @param Local
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Retourne la liste des personnes présentes à la séance
     * @return ArrayListe<Personne> doit contenir au minimum 
     * une personne de type "Enseignant" et une de type "Etudiant"
     */
    public ArrayList<Personne> getPresents() {
        return presents;
    }
}
