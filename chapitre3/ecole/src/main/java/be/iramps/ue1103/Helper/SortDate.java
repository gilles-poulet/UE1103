package be.iramps.ue1103.Helper;

import java.util.Comparator;
import be.iramps.ue1103.BL.Seance;

/**
 * Classe d'aide pour le tri des séances.
 */
public class SortDate implements Comparator<Seance> {
    /**
     * Compare et trie deux séances suivant leur date.
     * @return true si la date de a est plus grande, false
     *   dans le cas contraire
     */
    @Override
    public int compare(Seance a, Seance b)
    {
        return a.getDate().compareTo(b.getDate());
    }
}

