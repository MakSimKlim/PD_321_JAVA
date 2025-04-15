package org.example.academyfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

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
    private TableView tableDirections;

    @FXML
    protected void onLoadButtonClick() throws SQLException
    {
        //String connectionString = "jdbc:sqlserver://VANYACOMP:1433;"
        String connectionString = "jdbc:sqlserver://EVEREST:1433;"
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
    @FXML
    protected void loadDirections() throws SQLException
    {
        //String connectionString = "jdbc:sqlserver://VANYACOMP:1433;"
        String connectionString = "jdbc:sqlserver://EVEREST:1433;"
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

        //https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/
        //https://forums.oracle.com/ords/apexds/post/how-fill-a-tableview-with-a-resultset-3022

        for(int i=0; i<set.getMetaData().getColumnCount();i++)
        {
            final int j=i;
            TableColumn col = new TableColumn(set.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList,String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });
            tableDirections.getColumns().add(col);
        }
        //конструкция двумерного динамического массива "Список списков"
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        while(set.next())
        {
            //читаем строку из базы
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1; i<=set.getMetaData().getColumnCount();i++)
            {
                row.add(set.getString(i));
            }
            //добавляем коллекцию
            data.add(row);
        }
        //tableDirections.getItems().clear();
        tableDirections.setItems(data);


        connection.close();
    }


}
