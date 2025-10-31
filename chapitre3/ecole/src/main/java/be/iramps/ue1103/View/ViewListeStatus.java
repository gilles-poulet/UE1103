package be.iramps.ue1103.View;

import java.util.HashSet;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import be.iramps.ue1103.BL.Status;

/**
 * Classe contenant les composants pour
 * afficher la liste des status.
 */
public class ViewListeStatus {
    private final VBox container;

    /**
     * Constructeur de la vue.
     * Prépare la VBox associée.
     */
    public ViewListeStatus() {
        container = new VBox(20);

        // Préparation de la table .
        TableView<StatusFX> listStatus = new TableView<StatusFX>();
        listStatus.setPadding(new Insets(0, 20, 0, 0));
        ObservableList<TableColumn<StatusFX, ?>> columns = listStatus.getColumns();
        listStatus.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        // VBox.setVgrow(listStatus, Priority.ALWAYS);

        // Préparation de la colonne de suppression
        TableColumn<StatusFX, Boolean> loadedColumn = new TableColumn<StatusFX, Boolean>("Delete");
        loadedColumn.setCellValueFactory(new PropertyValueFactory<>("delete")); // Correspond à deleteProperty
        loadedColumn.setCellFactory(tc -> new CheckBoxTableCell<>());
        columns.add(loadedColumn);

        // Préparation de la colonne de suppression
        TableColumn<StatusFX, Boolean> idColumn = new TableColumn<StatusFX, Boolean>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id")); // Correspond à idProperty
        columns.add(idColumn);

        // Préparation de la colonne de nom
        TableColumn<StatusFX, Boolean> nameColumn = new TableColumn<StatusFX, Boolean>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); // Correspond à nameProperty
        columns.add(nameColumn);
        ObservableList<StatusFX> items = FXCollections.observableArrayList(
                new StatusFX(new Status(0, "Etudiant"), false),
                new StatusFX(new Status(2, "Chargé de cours"), false),
                new StatusFX(new Status(45, "Personnel administratif"), false));
        listStatus.setItems(items);
        listStatus.setEditable(true);

        // Prépration du groupe de boutons.
        HBox buttonGroup = new HBox(10);
        Button deleteButton = new Button("Supprimer");
        buttonGroup.getChildren().addAll(new Button("Ajouter"), new Button("Modifier"), deleteButton);

        // Ajout d'un évènement sur le bouton de suppression.
        deleteButton.setOnAction(e -> {
            HashSet<StatusFX>del = new HashSet<StatusFX>();
            for (StatusFX status : listStatus.getItems()) {
                if (status.deleteProperty().get()) {
                    del.add(status);
                }
            }
            listStatus.getItems().removeAll(del);
        });

        // Ajout des composants dans la vue
        container.getChildren().addAll(buttonGroup, listStatus);
    }

    /**
     * Renvoi le conteneur lié à cette vue.
     * 
     * @return le conteneur
     */
    public VBox getListeStatus() {
        return this.container;
    }

    /**
     * Classe interne permetant l'affichage et la suppression des
     * status en utilisant des propriétés.
     */
    public class StatusFX {

        private final SimpleObjectProperty<Status> status = new SimpleObjectProperty<>();
        private final BooleanProperty delete = new SimpleBooleanProperty();

        /**
         * Constructeur permettant de créer un status
         * lié à javaFX.
         * 
         * @param statusOjbect status associé à cet objet
         * @param del          boolean indiquant si l'objet est à supprimer
         *                     ou non.
         */
        public StatusFX(Status statusOjbect, boolean del) {
            status.set(statusOjbect);
            delete.set(del);
        }

        /**
         * Retourne le nom du status emballé dans un
         * objet reconnu par JavaFX.
         * 
         * @return SimpleStringProperty
         */
        public StringProperty nameProperty() {
            return new SimpleStringProperty(status.getValue().getNom());
        }

        /**
         * Retourne l'id du status emballé dans un
         * objet reconnu par JavaFX.
         * 
         * @return SimpleIntegerProperty
         */
        public IntegerProperty idProperty() {
            return new SimpleIntegerProperty(status.getValue().getId());
        }

        /**
         * Retourne l'état de suppression de l'objet.
         * 
         * @return BooleanProperty
         */
        public BooleanProperty deleteProperty() {
            return delete;
        }
    }

}
