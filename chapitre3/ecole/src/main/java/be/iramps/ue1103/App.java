package be.iramps.ue1103;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import be.iramps.ue1103.View.ViewMenuEditProfile;
import be.iramps.ue1103.View.ViewListeStatus;
import be.iramps.ue1103.View.ViewMenu;

/**
 * JavaFX App standard.
 */
public class App extends Application {

    private Scene scene;
    private Pane principal;

    /**
     * Panel gérant 2 composants: le composant d'édition
     * de profil et le contenu.
     */
    private VBox rightPanel;

    /**
     * Prépare le stage en y intégrant la scène principale.
     */
    @Override
    public void start(Stage stage) throws IOException {

        // Préparation de la scène
        this.principal = new HBox(20);
        scene = new Scene(principal, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/CSS/styles.css").toExternalForm());

        // Préparation du panneaux de droite (Login et Contenu)
        this.rightPanel = new VBox(20);
        HBox editProfil = new ViewMenuEditProfile("Gilles Poulet").getEditProfile();
        this.rightPanel.getChildren().add(editProfil);
        HBox.setHgrow(rightPanel, Priority.ALWAYS);
        this.setStatusContent();

        // Ajout des conteneurs
        principal.getChildren().addAll(new ViewMenu(this).getMenu(), this.rightPanel);

        // Préparation du stage
        stage.setTitle("Gestion des locaux");
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Démarre l'application JAVAFX.
     * 
     * @param args Arguments passés par la ligne de commande.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Affiche la liste des status dans le panel de
     * droite.
     */
    public void setStatusContent() {
        if (this.rightPanel.getChildren().size() > 1) {
            this.rightPanel.getChildren().removeLast();
        }
        this.rightPanel.getChildren().add(new ViewListeStatus().getListeStatus());
    }

}