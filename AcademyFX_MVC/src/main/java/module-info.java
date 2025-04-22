module org.openjfx.academyfx_mvc {
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

    opens org.openjfx.academyfx_mvc to javafx.fxml;
    exports org.openjfx.academyfx_mvc;
    exports org.openjfx.academyfx_mvc.Controller;
    opens org.openjfx.academyfx_mvc.Controller to javafx.fxml;
}