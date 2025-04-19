module org.example.academyfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;
    requires jdk.jdi;

    opens org.example.academyfx to javafx.fxml;
    exports org.example.academyfx;
    exports org.openjfx.academyfx;
    opens org.openjfx.academyfx to javafx.fxml;
}