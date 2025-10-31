package be.iramps.ue1103.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * Classe permettant de voir le logo et
 * le nom de la personne connectée au programme.
 */
public class ViewMenuEditProfile {
    private final HBox container;

    /**
     * Constructeur de la vue concernant le menu d'édition
     * du profile.
     * 
     * @param name de la personne connectée
     */
    public ViewMenuEditProfile(String name) {
        container = new HBox(20);
        container.setAlignment(Pos.CENTER_RIGHT);
        container.setId("edit-profile");

        // Préparation du spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Préparation du logo
        Image logo = new Image(getClass().getResource("/images/avatar.jpg").toExternalForm());
        ImageView logoView = new ImageView(logo);
        logoView.setPreserveRatio(true);
        logoView.setFitHeight(40);

        // Préparation du label
        Label nameLabel = new Label(name);
        nameLabel.setPadding(new Insets(0, 20, 0, 0));

        // Préparation du container
        container.getChildren().addAll(spacer, logoView, nameLabel);
    }

    /**
     * Renvoi le conteneur lié à cette vue.
     * 
     * @return le conteneur
     */
    public HBox getEditProfile() {
        return this.container;
    }
}
