package be.iramps.ue1103.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import be.iramps.ue1103.App;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/*
 * Classe permettant de voir le menu de navigation
 * du programme.
 */
public class ViewMenu {
    private final VBox container;

    /**
     * Constructeur de la vue concernant le menu
     * de gauche permettant la navigation entre
     * les différentes vues (listes).
     * 
     * @param main
     */
    public ViewMenu(App main) {
        container = new VBox(10);
        container.getChildren().add(new Region());
        container.getChildren().add(this.getLabel("Cours"));
        container.getChildren().add(this.getLabel("Locaux"));
        container.getChildren().add(this.getLabel("Personnes"));
        container.getChildren().add(this.getLabel("Status", main, "setStatusContent"));
        container.setId("menu");

    }

    /**
     * Renvoi le conteneur lié à cette vue.
     * 
     * @return le conteneur
     */
    public VBox getMenu() {
        return this.container;
    }

    /**
     * Génère un HBox avec un label avec un spacer.
     * Le spacer permet de prendre la place
     * nécessaire quand le container grandit.
     * 
     * @param text Texte du label
     * @return le HBox
     */
    private HBox getLabel(String text) {
        HBox box = new HBox();
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Label label = new Label(text);
        box.getChildren().addAll(label, spacer);
        return box;
    }

    /**
     * Génère un HBox avec un label avec un spacer.
     * Le spacer permet de prendre la place
     * nécessaire quand le container grandit.
     * 
     * Utilise application.method via la réflexion
     * afin d'avoir une certaine généricité.
     * 
     * @param text        Texte du label
     * @param application L'application actuelle
     * @param method      La méthode a utiliser
     * @return le HBox
     */
    private HBox getLabel(String text, App application, String method) {
        HBox box = this.getLabel(text);
        box.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                try {
                    // Ces deux lignes permettent d'executer une méthode particulière.
                    Method methodApplication = application.getClass().getMethod(method);
                    methodApplication.invoke(application);

                    /*
                     * Diverses exceptions peuvent être lancées. Si elles le sont, le
                     * programme doit être arrêté.
                     */
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    System.exit(1);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    System.exit(2);
                } catch (SecurityException e) {
                    e.printStackTrace();
                    System.exit(3);
                }
            }

        });
        return box;
    }

}
