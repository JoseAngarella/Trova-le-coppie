module it.jose {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens it.jose to javafx.fxml;

    exports it.jose;

    opens it.jose.controller to javafx.fxml;

    exports it.jose.controller;

    opens it.jose.model to javafx.fxml;

    exports it.jose.model;
}
