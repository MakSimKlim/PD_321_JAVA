package org.example.academyfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class HelloController {
   /* @FXML
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
    */
    @FXML
    private ComboBox cbDirections;
    @FXML
    private Button load;
    @FXML
    private Button check;
    @FXML
    protected void onLoadButtonClick() throws SQLException
    {
        String connectionString = "jdbc:sqlserver://VANYACOMP:1433;"
                + "database=PD_212;"
                + "user=PHP;"
                + "password=111;"
                + "ConnectTimeout=30;"
                + "Encrypt=True;"
                + "TrustServerCertificate=True;"
                + "ApplicationIntent=ReadWrite;"
                + "MultiSubnetFailover=False;";

        Connection connection = DriverManager.getConnection(connectionString);

        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery("SELECT * FROM Directions");
        while (set.next())
        {
            cbDirections.getItems().add(set.getString("direction_name"));
        }
        set.close();
        connection.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, connectionString, ButtonType.OK);
        alert.show();
    }
    @FXML
        protected void onCheckButtonClick()
        {
            String msg = cbDirections.getValue().toString();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
            alert.show();
        }

}
