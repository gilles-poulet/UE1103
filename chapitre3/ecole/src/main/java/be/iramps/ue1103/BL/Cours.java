package be.iramps.ue1103.BL;

import java.util.ArrayList;
import java.util.Collections;

import be.iramps.ue1103.Helper.SortDate;

/**
 * Classe permettant la modélisation d'un cours
 */
public class Cours {
    private final int id;
    private String nom;
    private final ArrayList<Personne> inscrit;

    /**
     * @param id  Identifiant du cours
     * @param nom Nom du cours
     */
    public Cours(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.inscrit = new ArrayList<Personne>();
    }

    /**
     * Retourne l'identifiant dans la persistance
     * de données associé au status
     * 
     * @return int
     */

    public int getId() {
        return this.id;
    }

    /**
     * Retourne le nom associé au status
     * 
     * @return String
     */

    public String getNom() {
        return this.nom;
    }

    /**
     * Nom est l'appellation humaine utilisée
     * pour identifier le status
     * 
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la liste des personnes (étudiants et
     * chargé de cours) inscrite au cours
     * 
     * @return nom
     */

    public ArrayList<Personne> getInscrit() {
        return inscrit;
    }

    /**
     * Retourne la date de début de laboratoire d'un cours suivant le nombre
     * de séances disponibles et le pourcentage de cours accordés aux laboratoires
     * 
     * @param seances
     * @param pourcentageLabo doit être compris entre 0 et 1.
     * @return java.time.LocalDate ou null si aucun laboratoire ne doit être prévu.
     */
    public java.time.LocalDate getDateDebutLabo(ArrayList<Seance> seances, float pourcentageLabo) {
        if (pourcentageLabo == 0) {
            return null;
        }
        ArrayList<Seance> seancesCours = this.filtreSeance(seances);
        Collections.sort(seancesCours, new SortDate());
        int result = seancesCours.size() - (int) Math.ceil(seancesCours.size() * pourcentageLabo);
        return seancesCours.get(result).getDate();
    }

    /**
     * Retourne le nombre d'étudiants inscrits au cours
     * possédant le status défini
     * 
     * @param String status doit être compris entre 3 et 20 caractères
     * @return int positif
     */
    public int getNbreInscrit(String status) {
        int nbreInscrit = 0;
        for (Personne p : this.inscrit) {
            if (p.getStatut().getNom().equals(status)) {
                nbreInscrit++;
            }
        }
        return nbreInscrit;
    }

    /**
     * Retourne le taux moyen de participation au cours suivant le nombre
     * d'étudiants inscrits et le nombre de séances.
     * 
     * @param seance
     * @param String statusEtudiant doit être compris entre 3 et 20 caractères
     * @return float entre 0 et 1
     */
    public float getTauxMoyenParticipation(ArrayList<Seance> seances, String statutEtudiant) {
        ArrayList<Float> pourcentageParticipation = new ArrayList<>();
        ArrayList<Seance> seancesCours = this.filtreSeance(seances);

        for (Personne p : this.inscrit) {
            if (!p.getStatut().getNom().equals(statutEtudiant)) {
                continue;
            }
            int participation = 0;
            for (Seance s : seances) {
                if (s.getPresents().contains(p)) {
                    participation++;
                }
            }
            pourcentageParticipation.add(Float.valueOf((float) participation / seancesCours.size()));
        }
        return pourcentageParticipation.stream().reduce(0.0f, Float::sum) / this.getNbreInscrit(statutEtudiant);
    }

    /**
     * Retourne le taux d'absence d'un étudiant pour le cours suivant
     * les séances fournies
     * 
     * @param seance   La liste de séance prise en compte
     * @param etudiant L'étudiant concerné
     * @return float ou -1 si ce n'est pas un étudiant
     */
    public float getTauxAbsence(ArrayList<Seance> seances, Personne etudiant) {
        if (!etudiant.getStatut().getNom().equals("Etudiant")) {
            return -1f;
        }
        int participation = 0;
        for (Seance s : seances) {
            if (s.getPresents().contains(etudiant) && s.getCours().equals(this)) {
                participation++;
            }
        }
        return 1.0f - (float) participation / seances.size();
    }

    /**
     * Retourne le hash de l'objet, ce qui permet de valider
     * que deux objets sont identiques.
     * 
     * @return result
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }

    /**
     * Retourne un boolean indiquant si l'objet obj est considéré
     * égal à l'objet courant.
     * 
     * @param obj
     * @return true si l'objet est identique, false dans le cas
     *         contraire
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cours other = (Cours) obj;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        return true;
    }

    /**
     * Retourne l'ensemble des séances en rapport avec
     * le cours actuel.
     * 
     * @param seances
     * @return ArrayList<Seance>
     */
    public ArrayList<Seance> filtreSeance(ArrayList<Seance> seances) {
        ArrayList<Seance> seancesCours = new ArrayList<>();
        for (Seance seance : seances) {
            if (seance.getCours().equals(this)) {
                seancesCours.add(seance);
            }
        }
        return seancesCours;
    }
}
