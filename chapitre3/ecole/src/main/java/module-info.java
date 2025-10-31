module be.iramps.ue1103 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens be.iramps.ue1103 to javafx.fxml;
    opens be.iramps.ue1103.View to javafx.base;
    exports be.iramps.ue1103;
}
