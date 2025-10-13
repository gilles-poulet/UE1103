package be.iramps.ue1103.BL;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.junit.jupiter.api.Nested;

// @Disabled
@DisplayName("Test de la classe Cours")
public class TestCours {
    private static Cours cours;
    private static Cours mockedCours;

    @BeforeAll
    static void setup() {
        TestCours.cours = new Cours(1, "Systèmes d'exploitation");
        // Préparation d'un objet mocked pour les fonctions intégrées.
        TestCours.mockedCours = Mockito.spy(cours);
    }
    @AfterEach
    public void tearDown(){
        cours.getInscrit().clear();
    }

    @Nested
    @DisplayName("Calcul des personnes inscrites")
    class calculInscrit {

        @DisplayName("Calcul des personnes inscrites: Validation simple")
        @Test
        public void calculInscritSimple() {
            // Préparation spécifique pour ce test
            //#region Définition des status
            Status etudiant = new Status(0, "Etudiant");
            Status chargeCours = new Status(1, "Chargé de cours");
            Status administratif = new Status(2, "Administratif");
            //#endregion

            //#region Définition des personnes
            Personne gpoulet = new Personne(89, "Poulet", "Gilles", chargeCours);
            Personne dmairesse = new Personne(6, "Mairesse", "David", administratif);
            Personne jmartin = new Personne(934, "Martin", "Julien", etudiant);
            Personne abernard = new Personne(1320, "Bernard", "Alice", etudiant);
            Personne pthomas = new Personne(373, "Thomas", "Paul", etudiant);
            Personne srodriguez = new Personne(1842, "Rodriguez", "Sophie", etudiant);

            //#endregion

            // Test de valeurs simples, le test doit les verifier toutes:

            Assertions.assertAll(
                    () -> {
                        cours.getInscrit().add(gpoulet);
                        Assertions.assertEquals(0, cours.getNbreInscrit(etudiant.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(chargeCours.getNom()));
                        Assertions.assertEquals(0, cours.getNbreInscrit(administratif.getNom()));
                    },
                    () -> {
                        cours.getInscrit().add(dmairesse);
                        Assertions.assertEquals(0, cours.getNbreInscrit(etudiant.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(chargeCours.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(administratif.getNom()));
                    },
                    () -> {
                        cours.getInscrit().add(pthomas);
                        Assertions.assertEquals(1, cours.getNbreInscrit(etudiant.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(chargeCours.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(administratif.getNom()));
                    },
                    () -> {
                        cours.getInscrit().add(srodriguez);
                        cours.getInscrit().add(jmartin);
                        cours.getInscrit().add(abernard);
                        Assertions.assertEquals(4, cours.getNbreInscrit(etudiant.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(chargeCours.getNom()));
                        Assertions.assertEquals(1, cours.getNbreInscrit(administratif.getNom()));
                    }
            );
        }

        @Disabled
        @DisplayName("Calcul des personnes inscrites: validation nom de section incorrect")
        @ParameterizedTest
        @ValueSource(strings = { "03-admin", "", "a", "administratif-technicologistique" })
        public void calculInscritNomSection(String status) {
          Assertions.assertThrows(Exception.class, () -> cours.getNbreInscrit(status));
        }
    }

    @Nested
    @DisplayName("Calcul de la date des laboratoires")
    class DateDebutLabo {
        @DisplayName("Calcul de la date des laboratoires: Validation simple")
        @Test
        public void calculDateOk(){
            ArrayList<Seance> seances = new ArrayList<>();
            Local local = new Local(0, "PS02", Lieu.HELHA, LocalType.INF);
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 15)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 16)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 17)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 18)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 19)));
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LocalDate.of(2025, 9,17),cours.getDateDebutLabo(seances,0.5f));
                },
                () -> {
                    Assertions.assertEquals(LocalDate.of(2025, 9,15),cours.getDateDebutLabo(seances,1f));
                },
                () -> {
                    Assertions.assertEquals(LocalDate.of(2025, 9,16),cours.getDateDebutLabo(seances,0.66f));
                },
                () -> {
                    Assertions.assertEquals(LocalDate.of(2025, 9,19),cours.getDateDebutLabo(seances,0.00001f));
                },
                () -> {
                    Assertions.assertEquals(LocalDate.of(2025, 9,18),cours.getDateDebutLabo(seances,0.37f));
                }
            );
        }

        @DisplayName("Calcul de la date des laboratoires: Validation pas de laboratoire")
        @Test
        public void calculDatePasLaboratoire(){
            ArrayList<Seance> seances = new ArrayList<>();
            Local local = new Local(0, "PS02", Lieu.HELHA, LocalType.INF);
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 15)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 16)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 17)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 18)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 19)));
            Assertions.assertNull(cours.getDateDebutLabo(seances,0.0f));
        }

        @DisplayName("Calcul de la date des laboratoires: Validation des exceptions")
        @Test
        public void calculDateException(){
            ArrayList<Seance> seances = new ArrayList<>();
            Local local = new Local(0, "PS02", Lieu.HELHA, LocalType.INF);
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 15)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 16)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 17)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 18)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 19)));
            Assertions.assertAll(
                () -> {
                    Assertions.assertThrows(Exception.class, () -> cours.getDateDebutLabo(seances, 1.2f));
                },
                () -> {
                    Assertions.assertThrows(Exception.class, () -> cours.getDateDebutLabo(seances, 9999999999999f));
                },
                () -> {
                    Assertions.assertThrows(Exception.class, () -> cours.getDateDebutLabo(seances, -5.5f));
                }
            );
        }
    }

    @Nested
    @DisplayName("Calcul du taux moyen de participation")
    class TauxMoyenParticipation {
        @DisplayName("Calcul du taux moyen de participation: Validation simple")
        @Test
        public void calculTauxMoyenParticipationSimple(){
            ArrayList<Seance> seances = new ArrayList<>();
            Local local = new Local(0, "PS02", Lieu.HELHA, LocalType.INF);
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 15)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 16)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 17)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 18)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 19)));
            
            Status etudiant = new Status(0, "Etudiant");
            Status chargeCours = new Status(1, "Chargé de cours");

            Personne gpoulet = new Personne(0, "Poulet", "Gilles", chargeCours);
            Personne jghislan = new Personne(10, "Ghislan", "Jérome", etudiant);
            Personne ktherain = new Personne(2, "Therain", "Kévin", etudiant);
            Personne cfran = new Personne(8, "Fran", "Cindy", etudiant);
            Personne tdupond = new Personne(65, "Dupond", "Thierry", etudiant);
                
            cours.getInscrit().add(gpoulet);
            cours.getInscrit().add(jghislan);
            cours.getInscrit().add(ktherain);
            cours.getInscrit().add(cfran);
            cours.getInscrit().add(tdupond);

            Mockito.doReturn(4).when(mockedCours).getNbreInscrit( etudiant.getNom());
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(0,cours.getTauxMoyenParticipation(seances, etudiant.getNom()));
                },
                () -> {
                    seances.get(0).getPresents().add(gpoulet);
                    seances.get(0).getPresents().add(jghislan);
                    seances.get(0).getPresents().add(ktherain);
                    seances.get(0).getPresents().add(cfran);
                    seances.get(0).getPresents().add(tdupond);
                    Assertions.assertEquals(0.2f,cours.getTauxMoyenParticipation(seances, etudiant.getNom()),0.001f);
                },
                () -> {
                    for (Seance s : seances){
                        s.getPresents().add(gpoulet);
                        s.getPresents().add(jghislan);
                        s.getPresents().add(ktherain);
                        s.getPresents().add(cfran);
                        s.getPresents().add(tdupond);
                    }
                    Assertions.assertEquals(1,cours.getTauxMoyenParticipation(seances, etudiant.getNom()));
                }
           );
        }

    }

    @Nested
    @DisplayName("Calcul du taux d'absence d'une personne inscrite")
    class TauxAbsence {
        
    }   

    @Nested
    @DisplayName("Filtre des séances utiles au cours")
    class FiltreSeance {
        

        @DisplayName("Filtre des séances: Validation simple")
        @Test
        public void calculDateSeancesOk(){
            ArrayList<Seance> seances = new ArrayList<>();
            Local local = new Local(0, "PS02", Lieu.HELHA, LocalType.INF);
            Cours other = new Cours(0, "other");
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 16)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 17)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 18)));
            seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 19)));
            Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(4,cours.filtreSeance(seances).size());
                },
                () -> {
                    seances.add(new Seance(0, other, local, LocalDate.of(2025, 9, 15)));
                    Assertions.assertEquals(4,cours.filtreSeance(seances).size());
                },
                () -> {
                    seances.add(new Seance(0, cours, local, LocalDate.of(2025, 9, 15)));
                    Assertions.assertEquals(5,cours.filtreSeance(seances).size());
                }
            );
        }
    }
}
