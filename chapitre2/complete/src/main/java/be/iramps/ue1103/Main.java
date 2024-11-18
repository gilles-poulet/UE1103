package be.iramps.ue1103;

import java.util.Locale;

import be.iramps.ue1103.Pret.Pret;
import be.iramps.ue1103.Pret.Projet;

public class Main {
    public static void main(String[] args) {
        // Préparation pour le projet hypothécaire
        Projet projet = new Projet();

        // Tests de résultats: calculTVAFraisTransformation
        double[] array = new double[7];
        array[0] = 90_000.00;
        array[1] = -90_000.00;
        array[2] = 0;
        array[3] = 100_000.00;
        array[4] = 59_595.00;
        array[5] = 92_123.89;
        array[6] = 1.00;
        System.out.println("Calcul TVA");
        for (double d : array) {
            projet.setFraisTransformation(d);
            System.out.println(String.format("%.2f  =>  %.2f",d,projet.calculTVAFraisTransformation()));
        }
        // Le compilateur renvoi une erreur, la méthode setPrixHabitation n'autorise que les doubles.
        // projet.setFraisTransformation("Une chaine de caractère");


        // Tests de résultats: calculAbattement
        array = new double[11];
        array[0] = 350_000.00;
        array[1] = -350_000.00;
        array[2] = 0;
        array[3] = 19_000.00;
        array[4] = 500_000.00;
        array[5] = 365_000.00;
        array[6] = 363_363.36;
        array[7] = 420_000.00;
        array[8] = 419_999.99;
        array[9] = 375_623.59;
        array[10] = 478_987.65;
        System.out.println("Calcul Abattement");
        for (double d : array) {
            projet.setPrixHabitation(d);
            System.out.println(String.format("%.2f => %.2f ",d,projet.calculAbattement()));
        }

        // Le compilateur renvoi une erreur, la méthode setPrixHabitation n'autorise que les doubles.
        //projet.setPrixHabitation("Une chaine de caractère");

        projet.setPrixHabitation(90_000);
        projet.setRevenuCadastral(458);
        projet.setFraisNotaireAchat(4_150); // Prix forfétaire pour un bien de 195.000,00 €. Varie selon le montant,
                                            // bien entendu.
        projet.setFraisTransformation(30_000);

        double apportPersonnel = projet.calculApportMinimal();
        double montantEmprunt = projet.calculResteAEmprunter();

        // Résultat du projet:
        System.out
                .println(String.format(Locale.FRENCH, "Total projet:\t %(,11.2f EUR", projet.calculTotalProjetAchat()));
        System.out.println(String.format(Locale.FRENCH, "\tApport personnel:\t %(,11.2f EUR", apportPersonnel));
        System.out.println(String.format(Locale.FRENCH, "\tReste à emprunter:\t %(,11.2f EUR", montantEmprunt));
        System.out.println();

        // Préparation pour l'emprunt
        Pret pret = new Pret();
        pret.setFraisDossierBancaire(500); // Prix forfétaire, varie.
        pret.setFraisNotaireCredit(5_475); // Une hypothèque induit un acte notarié. Prix forfétaire sur 195.000,00 €
        pret.setNombreAnnees(15);
        pret.setTauxAnnuel(0.04); // Moyenne en 2023

        double apportBancaire = pret.calculRestantDu(montantEmprunt);

        System.out.println(
                String.format(Locale.FRENCH, "Total emprunt:\t %(,11.2f EUR", pret.calculTotalProjet(montantEmprunt)));
        System.out.println(String.format(Locale.FRENCH, "\tMensualités:\t\t %(,11.2f EUR",
                pret.calculMensualites(montantEmprunt)));
        System.out.println(String.format(Locale.FRENCH, "\tTotal des intérets:\t %(,11.2f EUR",
                pret.calculTotalInterets(montantEmprunt)));
        System.out.println(String.format(Locale.FRENCH, "\tRestant dû:\t\t %(,11.2f EUR", apportBancaire));
        System.out.println();

        // Apport personnel total
        System.out.println(
                String.format(Locale.FRENCH, "Apport personnel total: %(,11.2f EUR", apportBancaire + apportPersonnel));

    }
}