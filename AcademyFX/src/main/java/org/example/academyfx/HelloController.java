package org.example.academyfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private DatePicker age;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String data = lastName.getText() + " " + firstName.getText() + " " + age.getValue();
        welcomeText.setText(data);
        //welcomeText.setText("Welcome to JavaFX Application!");
        Alert alert = new Alert(Alert.AlertType.INFORMATION, data, ButtonType.OK);
        alert.setTitle("Hello, " + firstName.getText());
        alert.show();
    }
}