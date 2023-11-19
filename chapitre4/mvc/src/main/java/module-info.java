module be.iramps.ue1103.mvc {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens be.iramps.ue1103.mvc to javafx.fxml;
    exports be.iramps.ue1103.mvc.View;
}
