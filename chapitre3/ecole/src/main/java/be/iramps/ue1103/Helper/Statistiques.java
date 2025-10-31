package be.iramps.ue1103.Helper;

import java.util.ArrayList;
import be.iramps.ue1103.BL.Local;
import be.iramps.ue1103.BL.Seance;

/**
 * Classe permettant regroupant les fonction
 * de statistiques diverses.
 */
public class Statistiques {
    /**
     * Retourne le pourcentage de locaux qui sont des laboratoires
     * sur l'ensemble des locaux.
     * @param locaux
     * @return float compris entre 0 et 1.
     */
    public static float getPourcentageLocalLabo( ArrayList<Local> locaux){
        return 0.0f;
    }

    /**
     * Retourne le pourcentage des séances de cours qui se déroulent
     * dans un laboratoire informatiques.
     * @param seances
     * @return float compris entre 0 et 1.
     */
    public static float getPourcentageCoursLabo ( ArrayList<Seance> seances){
        return 0.0f;
    }

    /**
     * Calcule le taux d'occupation par local selon les séances.
     * Utilise la première et la dernière date trouvée pour le calcul.
     * @param seances
     * @param locaux
     * @return String[Local][Taux d'occupation]
     */
    public static String[][] getTauxOccupation( ArrayList<Seance> seances,  ArrayList<Local> locaux){
        return null;
    }
    
}