module es.aritzherrero.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.aritzherrero.scenebuilder to javafx.fxml;
    exports es.aritzherrero.scenebuilder;
}