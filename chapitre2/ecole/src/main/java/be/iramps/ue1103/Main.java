package be.iramps.ue1103;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import be.iramps.ue1103.BL.Cours;
import be.iramps.ue1103.BL.Lieu;
import be.iramps.ue1103.BL.Local;
import be.iramps.ue1103.BL.LocalType;
import be.iramps.ue1103.BL.Personne;
import be.iramps.ue1103.BL.Seance;
import be.iramps.ue1103.BL.Section;
import be.iramps.ue1103.BL.Status;
import be.iramps.ue1103.Helper.GeneratedIgnoreJacoco;


@GeneratedIgnoreJacoco
public class Main {
    public static void main(String[] args) throws Exception {
        //#region Définition des sections
        Section informatiqueGestion = new Section(0, "Informatique de gestion");
        Section droit = new Section(1, "Droit");
        //#endregion

        //#region Définition des cours
        Cours systemeExploitation = new Cours(1, "Systèmes d'exploitation");
        Cours baseReseau = new Cours(2, "Base des réseaux");
        Cours droitCommercial = new Cours(5, "Droit commercial");
        //#endregion

        //#region Défnition des locaux
        Local ps02 = new Local(0, "PS02", Lieu.SAINT_LUC, LocalType.INF);
        Local l3223 = new Local(1, "3223", Lieu.HELHA, LocalType.STD);
        Local l2166 = new Local(2, "2166", Lieu.SAINT_LUC, LocalType.INF);
        //#endregion

        //#region Définition des status
        Status etudiant = new Status(0, "Etudiant");
        Status chargeCours = new Status(1, "Chargé de cours");
        Status administratif = new Status(2, "Administratif");
        //#endregion

        //#region Définition des personnes
        Personne gpoulet = new Personne(89, "Poulet", "Gilles", chargeCours);
        Personne egodissart = new Personne(7, "Godissart", "Emmanuel", chargeCours);
        Personne dmairesse = new Personne(6, "Mairesse", "David", administratif);
        Personne tdupont = new Personne(566, "Dupont", "Tristan", chargeCours);
        Personne jmartin = new Personne(934, "Martin", "Julien", etudiant);
        Personne abernard = new Personne(1320, "Bernard", "Alice", etudiant);
        Personne gmoreau = new Personne(1987, "Moreau", "Gabriel", etudiant);
        Personne elambert = new Personne(1505, "Lambert", "Emma", etudiant);
        Personne pthomas = new Personne(373, "Thomas", "Paul", etudiant);
        Personne srodriguez = new Personne(1842, "Rodriguez", "Sophie", etudiant);
        //#endregion

        //#region Association des sections et des cours
        informatiqueGestion.getCours().add(systemeExploitation);
        informatiqueGestion.getCours().add(baseReseau);
        droit.getCours().add(droitCommercial);
        //#endregion

        //#region Inscription des étudiants et chargé de cours au cours
        systemeExploitation.getInscrit().add(gpoulet);
        systemeExploitation.getInscrit().add(abernard);
        systemeExploitation.getInscrit().add(gmoreau);
        systemeExploitation.getInscrit().add(elambert);
        systemeExploitation.getInscrit().add(dmairesse);

        baseReseau.getInscrit().add(egodissart);
        baseReseau.getInscrit().add(abernard);
        baseReseau.getInscrit().add(elambert);
        baseReseau.getInscrit().add(srodriguez);

        droitCommercial.getInscrit().add(tdupont);
        droitCommercial.getInscrit().add(pthomas);
        droitCommercial.getInscrit().add(jmartin);
        //#endregion

        //#region Définition des séances pour le cours de systèmes d'exploitation
        Seance se1 = new Seance(78, systemeExploitation, l2166, java.time.LocalDate.of(2025,9,15));
        se1.getPresents().add(gpoulet);
        se1.getPresents().add(abernard);
        se1.getPresents().add(gmoreau);
        se1.getPresents().add(elambert);

        Seance se2 = new Seance(79, systemeExploitation, ps02, java.time.LocalDate.of(2025,9,22));
        se2.getPresents().add(gpoulet);
        se2.getPresents().add(elambert);

        Seance se3 = new Seance(80, systemeExploitation, ps02, java.time.LocalDate.of(2025,9,29));
        se3.getPresents().add(gpoulet);
        se3.getPresents().add(abernard);
        se3.getPresents().add(elambert);

        Seance se4 = new Seance(81, systemeExploitation, ps02, java.time.LocalDate.of(2025,10,6));
        se4.getPresents().add(gpoulet);
        se4.getPresents().add(gmoreau);
        se4.getPresents().add(elambert);

        Seance se5 = new Seance(82, systemeExploitation, ps02, java.time.LocalDate.of(2025,10,13));
        se5.getPresents().add(gpoulet);
        se5.getPresents().add(abernard);
        se5.getPresents().add(elambert);

        Seance se6 = new Seance(83, systemeExploitation, ps02, java.time.LocalDate.of(2025,10,20));
        se6.getPresents().add(gpoulet);
        se6.getPresents().add(gmoreau);
        se6.getPresents().add(elambert);

        Seance se7 = new Seance(84, systemeExploitation, ps02, java.time.LocalDate.of(2025,10,27));
        se7.getPresents().add(gpoulet);
        se7.getPresents().add(elambert);

        Seance se8 = new Seance(85, systemeExploitation, ps02, java.time.LocalDate.of(2025,11,3));
        se8.getPresents().add(gpoulet);
        se8.getPresents().add(abernard);
        se8.getPresents().add(gmoreau);
        se8.getPresents().add(elambert);

        Seance se9 = new Seance(86, systemeExploitation, ps02, java.time.LocalDate.of(2025,11,10));
        se9.getPresents().add(gpoulet);
        se9.getPresents().add(elambert);

        Seance se10 = new Seance(87, systemeExploitation, l2166, java.time.LocalDate.of(2025,11,17));
        se10.getPresents().add(gpoulet);
        se10.getPresents().add(gmoreau);
        se10.getPresents().add(elambert);
        ArrayList<Seance> seancesSystemeExploitation = new ArrayList<>();
        seancesSystemeExploitation.add(se1);
        seancesSystemeExploitation.add(se2);
        seancesSystemeExploitation.add(se3);
        seancesSystemeExploitation.add(se4);
        seancesSystemeExploitation.add(se5);
        seancesSystemeExploitation.add(se6);
        seancesSystemeExploitation.add(se7);
        seancesSystemeExploitation.add(se8);
        seancesSystemeExploitation.add(se9);
        seancesSystemeExploitation.add(se10);
        //#endregion

        //#region Définition des séances pour le cours de bases des réseaux
        Seance br1 = new Seance(88, baseReseau, ps02, java.time.LocalDate.of(2025,9,15));
        br1.getPresents().add(egodissart);
        br1.getPresents().add(abernard);

        Seance br2 = new Seance(89, baseReseau, l2166, java.time.LocalDate.of(2025,9,17));
        br2.getPresents().add(egodissart);
        br2.getPresents().add(elambert);
        br2.getPresents().add(srodriguez);

        Seance br3 = new Seance(90, baseReseau, l2166, java.time.LocalDate.of(2025,9,22));
        br3.getPresents().add(egodissart);
        br3.getPresents().add(abernard);
        br3.getPresents().add(srodriguez);

        Seance br4 = new Seance(91, baseReseau, l2166, java.time.LocalDate.of(2025,9,24));
        br4.getPresents().add(egodissart);
        br4.getPresents().add(elambert);

        Seance br5 = new Seance(92, baseReseau, l2166, java.time.LocalDate.of(2025,9,29));
        br5.getPresents().add(egodissart);
        br5.getPresents().add(srodriguez);

        Seance br6 = new Seance(93, baseReseau, l2166, java.time.LocalDate.of(2025,10,1));
        br6.getPresents().add(egodissart);
        br6.getPresents().add(abernard);
        br6.getPresents().add(elambert);

        Seance br7 = new Seance(94, baseReseau, l2166, java.time.LocalDate.of(2025,10,6));
        br7.getPresents().add(egodissart);
        br7.getPresents().add(srodriguez);

        Seance br8 = new Seance(95, baseReseau, l2166, java.time.LocalDate.of(2025,10,8));
        br8.getPresents().add(egodissart);
        br8.getPresents().add(abernard);

        Seance br9 = new Seance(96, baseReseau, l2166, java.time.LocalDate.of(2025,10,13));
        br9.getPresents().add(egodissart);
        br9.getPresents().add(elambert);
        br9.getPresents().add(srodriguez);

        Seance br10 = new Seance(97, baseReseau, l2166, java.time.LocalDate.of(2025,10,15));
        br10.getPresents().add(egodissart);
        br10.getPresents().add(abernard);
        
        ArrayList<Seance> seancesBaseReseau = new ArrayList<>();
        seancesBaseReseau.add(br1);
        seancesBaseReseau.add(br2);
        seancesBaseReseau.add(br3);
        seancesBaseReseau.add(br4);
        seancesBaseReseau.add(br5);
        seancesBaseReseau.add(br6);
        seancesBaseReseau.add(br7);
        seancesBaseReseau.add(br8);
        seancesBaseReseau.add(br9);
        seancesBaseReseau.add(br10);
        //#endregion

        //#region Définition des séances pour le cours de droit commercial
        Seance dc1 = new Seance(98, droitCommercial, l3223, java.time.LocalDate.of(2025,9,15));
        dc1.getPresents().add(tdupont);
        dc1.getPresents().add(pthomas);

        Seance dc2 = new Seance(99, droitCommercial, l3223, java.time.LocalDate.of(2025,9,18));
        dc2.getPresents().add(tdupont);
        dc2.getPresents().add(jmartin);

        Seance dc3 = new Seance(100, droitCommercial, l3223, java.time.LocalDate.of(2025,9,22));
        dc3.getPresents().add(tdupont);
        dc3.getPresents().add(pthomas);
        dc3.getPresents().add(jmartin);

        Seance dc4 = new Seance(101, droitCommercial, l3223, java.time.LocalDate.of(2025,9,25));
        dc4.getPresents().add(tdupont);
        dc4.getPresents().add(jmartin);

        Seance dc5 = new Seance(102, droitCommercial, l3223, java.time.LocalDate.of(2025,9,29));
        dc5.getPresents().add(tdupont);
        dc5.getPresents().add(pthomas);

        Seance dc6 = new Seance(103, droitCommercial, l3223, java.time.LocalDate.of(2025,10,2));
        dc6.getPresents().add(tdupont);
        dc6.getPresents().add(pthomas);
        dc6.getPresents().add(jmartin);

        Seance dc7 = new Seance(104, droitCommercial, l3223, java.time.LocalDate.of(2025,10,6));
        dc7.getPresents().add(tdupont);
        dc7.getPresents().add(jmartin);

        Seance dc8 = new Seance(105, droitCommercial, l3223, java.time.LocalDate.of(2025,10,9));
        dc8.getPresents().add(tdupont);
        dc8.getPresents().add(pthomas);

        Seance dc9 = new Seance(106, droitCommercial, l3223, java.time.LocalDate.of(2025,10,13));
        dc9.getPresents().add(tdupont);
        dc9.getPresents().add(jmartin);
        dc9.getPresents().add(pthomas);

        Seance dc10 = new Seance(107, droitCommercial, l3223, java.time.LocalDate.of(2025,10,16));
        dc10.getPresents().add(tdupont);
        dc10.getPresents().add(pthomas);

        ArrayList<Seance> seancesDroitCommercial = new ArrayList<>();
        seancesDroitCommercial.add(dc1);
        seancesDroitCommercial.add(dc2);
        seancesDroitCommercial.add(dc3);
        seancesDroitCommercial.add(dc4);
        seancesDroitCommercial.add(dc5);
        seancesDroitCommercial.add(dc6);
        seancesDroitCommercial.add(dc7);
        seancesDroitCommercial.add(dc8);
        seancesDroitCommercial.add(dc9);
        seancesDroitCommercial.add(dc10);
        //#endregion
        Cours testing = new Cours(0, "testing");
        Collections.addAll(testing.getInscrit(), srodriguez,gpoulet,jmartin);
        System.out.println( testing.getNbreInscrit( etudiant.getNom() ) );
        System.out.println( testing.getNbreInscrit( "étudiant" ) );
        System.out.println( testing.getNbreInscrit( "") );
        System.out.println( testing.getNbreInscrit( "a" ) );
        System.out.println( testing.getNbreInscrit( "03-admin" ) );
        System.out.println( testing.getNbreInscrit( "administratif-technicologistique" ) );
        srodriguez.setStatut(new Status(0,  "" ) );
        System.out.println( testing.getNbreInscrit( etudiant.getNom() ) );
        System.out.println(" ");

        srodriguez.setStatut(etudiant);

        
        System.out.println(systemeExploitation.getNbreInscrit(etudiant.getNom()));
        System.out.println(systemeExploitation.getTauxMoyenParticipation(seancesSystemeExploitation,etudiant.getNom()));
        System.out.println(systemeExploitation.getDateDebutLabo(seancesSystemeExploitation,1f));
        System.out.println(systemeExploitation.getTauxAbsence(seancesSystemeExploitation, abernard));
        System.out.println(systemeExploitation.getTauxAbsence(seancesSystemeExploitation, gmoreau));
        System.out.println(systemeExploitation.getTauxAbsence(seancesSystemeExploitation, elambert));

        System.out.println(baseReseau.getNbreInscrit(etudiant.getNom()));
        System.out.println(baseReseau.getTauxMoyenParticipation(seancesBaseReseau,etudiant.getNom()));
        System.out.println(baseReseau.getDateDebutLabo(seancesBaseReseau,0.6f));
        System.out.println(baseReseau.getTauxAbsence(seancesBaseReseau, abernard));
        System.out.println(baseReseau.getTauxAbsence(seancesBaseReseau, srodriguez));
        System.out.println(baseReseau.getTauxAbsence(seancesBaseReseau, elambert));

        System.out.println(droitCommercial.getNbreInscrit(etudiant.getNom()));
        System.out.println(droitCommercial.getTauxMoyenParticipation(seancesDroitCommercial,etudiant.getNom()));
        System.out.println(droitCommercial.getDateDebutLabo(seancesDroitCommercial,0.0f));
        System.out.println(droitCommercial.getTauxAbsence(seancesDroitCommercial, pthomas));
        System.out.println(droitCommercial.getTauxAbsence(seancesDroitCommercial, jmartin));

    }     
}