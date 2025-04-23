package org.openjfx.academyfx;
//package org.example.academyfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.academyfx.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class HelloController {
    public Connector connector = null;

            //String connectionString = "jdbc:sqlserver://VANYACOMP:1433;"
            //String connectionString = "jdbc:sqlserver://EVEREST:1433;"
            //String connectionString = "jdbc:sqlserver://DELL:1433;"
            //String connectionString = "jdbc:sqlserver://localhost:1433;"
            String connectionString = String.format(    // добавлено
             "jdbc:sqlserver://%s:1433;"                // добавлено
            + "database=PD_212;"
            + "user=PHP;"
            + "password=111;"
            + "ConnectTimeout=30;"
            + "Encrypt=True;"
            + "TrustServerCertificate=True;"
            + "ApplicationIntent=ReadWrite;"
            + "MultiSubnetFailover=False;",
            System.getenv("COMPUTERNAME") // добавлено: Автоматически подставит имя текущего ПК
            );

    /*@FXML
    private Label labelStatus;*/

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
    private TextField textFieldStatus;
    @FXML
    private ComboBox cbDirections;
    @FXML
    private Button load;
    @FXML
    private Button check;
    @FXML
    private TableView<String[]> tableStudents;
    @FXML
    private TableView<String[]> tableGroups;
    @FXML
    private TableView<String[]> tableDirections;


    @FXML
    protected void onLoadButtonClick() throws SQLException
    {
        /*Connection connection = DriverManager.getConnection(connectionString);

        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery("SELECT * FROM Directions");
        while (set.next())
        {
            cbDirections.getItems().add(set.getString("direction_name"));
        }
        set.close();
        connection.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, connectionString, ButtonType.OK);
        alert.show();*/

        if (connector == null) {
            switchToConnectTab(); // Переключаем на вкладку подключения
            return;
        }

        try {
            Connection connection = connector.getConnection(); // Получаем соединение из объекта connector
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Directions");

            cbDirections.getItems().clear(); // Очищаем список перед загрузкой новых данных
            while (set.next()) {
                cbDirections.getItems().add(set.getString("direction_name")); // Добавляем элементы в ComboBox
            }

            set.close();
            statement.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Данные загружены успешно!", ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ошибка при загрузке данных: " + e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }



    }
    @FXML
    protected void onCheckButtonClick()
    {
        if (cbDirections.getValue() != null) {
            String msg = cbDirections.getValue().toString();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    protected void loadStudents() throws SQLException, Exception
    {
        if (connector == null) {
            switchToConnectTab(); // Переключаем на вкладку с подключением
            return;
        }
        try{

            Statement statement = connector.getConnection().createStatement();

            ResultSet set = statement.executeQuery("SELECT * FROM Students");

            //https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/
            //https://forums.oracle.com/ords/apexds/post/how-fill-a-tableview-with-a-resultset-3022

            // 1. Очищаем предыдущие данные и колонки
            tableStudents.getItems().clear();
            tableStudents.getColumns().clear();

            // Затем создаем новые колонки
            for(int i=0; i<set.getMetaData().getColumnCount();i++)
            {
                //создаем колонки с их названием и фабрику
                TableColumn<String[], String> column = new TableColumn<>(set.getMetaData().getColumnLabel(i+1));
                //tableStudents.getColumns().add(column);
                final int j=i;
                column.setCellValueFactory(data->new SimpleStringProperty(data.getValue()[j]));
                tableStudents.getColumns().add(column);
            }

            // Заполняем таблицу данными
            while(set.next())
            {
                Collection<String> list = new ArrayList<>();
                for(int i=1;i<=set.getMetaData().getColumnCount();i++)
                {
                    list.add(set.getString(i));
                }
                String[] arr = new String[list.size()];
                list.toArray(arr);
                tableStudents.getItems().addAll(arr);
            }

            //connection.close();
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    protected void loadGroups() throws SQLException, Exception
    {
        if (connector == null) {
            switchToConnectTab(); // Переключаем на вкладку с подключением
            return;
        }
        try{

            Statement statement = connector.getConnection().createStatement();

            ResultSet set = statement.executeQuery("SELECT * FROM Groups");

            //https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/
            //https://forums.oracle.com/ords/apexds/post/how-fill-a-tableview-with-a-resultset-3022

            // 1. Очищаем предыдущие данные и колонки
            tableGroups.getItems().clear();
            tableGroups.getColumns().clear();

            for(int i=0; i<set.getMetaData().getColumnCount();i++)
            {
                //создаем колонки с их названием и фабрику
                TableColumn<String[], String> column = new TableColumn<>(set.getMetaData().getColumnLabel(i+1));
                tableGroups.getColumns().add(column);
                final int j=i;
                column.setCellValueFactory(data->new SimpleStringProperty(data.getValue()[j]));
            }

            // Заполняем таблицу данными
            while(set.next())
            {
                Collection<String> list = new ArrayList<>();
                for(int i=1;i<=set.getMetaData().getColumnCount();i++)
                {
                    list.add(set.getString(i));
                }
                String[] arr = new String[list.size()];
                list.toArray(arr);
                tableGroups.getItems().addAll(arr);
            }

            //connection.close();
        }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    protected void loadDirections() throws SQLException, Exception
    {
        //String connectionString = "jdbc:sqlserver://VANYACOMP:1433;"
        /*
        String connectionString = "jdbc:sqlserver://EVEREST:1433;"
                + "database=PD_212;"
                + "user=PHP;"
                + "password=111;"
                + "ConnectTimeout=30;"
                + "Encrypt=True;"
                + "TrustServerCertificate=True;"
                + "ApplicationIntent=ReadWrite;"
                + "MultiSubnetFailover=False;";
        Connection connection = DriverManager.getConnection(connectionString);*/

        if (connector == null) {
            switchToConnectTab(); // Переключаем на вкладку с подключением
            return;
        }

        try{
        //Statement statement = connection.createStatement();
        //ResultSet set = statement.executeQuery("SELECT * FROM Directions");

            Statement statement = connector.getConnection().createStatement();

            ResultSet set = statement.executeQuery("SELECT * FROM Directions");

        //https://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/
        //https://forums.oracle.com/ords/apexds/post/how-fill-a-tableview-with-a-resultset-3022

            // 1. Очищаем предыдущие данные и колонки
            tableDirections.getItems().clear();
            tableDirections.getColumns().clear();

        for(int i=0; i<set.getMetaData().getColumnCount();i++)
        {
            //создаем колонки с их названием и фабрику
            TableColumn<String[], String> column = new TableColumn<>(set.getMetaData().getColumnLabel(i+1));
            tableDirections.getColumns().add(column);
            final int j=i;
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue()[j]));
        }

        // Заполняем таблицу данными
        while(set.next())
        {
            Collection<String> list = new ArrayList<>();
            for(int i=1;i<=set.getMetaData().getColumnCount();i++)
            {
                list.add(set.getString(i));
            }
            String[] arr = new String[list.size()];
            list.toArray(arr);
            tableDirections.getItems().addAll(arr);
        }

        //connection.close();
    }
        catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    private TabPane tabPane;

    @FXML
    private void switchToConnectTab() {
        // Находим вкладку "Start" с кнопкой Connect
        for (Tab tab : tabPane.getTabs()) {
            if ("Start".equals(tab.getText())) {
                tabPane.getSelectionModel().select(tab); // Переключаемся на вкладку "Start"
                break;
            }
        }

        // Alert для ясности
        Alert alert = new Alert(
                Alert.AlertType.INFORMATION,
                "Нажмите 'Connect'.",
                ButtonType.OK
        );
        alert.setHeaderText(null);
        alert.show();
    }


    @FXML
    protected void connect()
    {
        if (connector == null)
        {
           try
            {
                connector = new Connector(connectionString);
                //labelStatus.setText("Connected\n" + connector.getConnection().toString());
                textFieldStatus.setText("Connected to DataBase DONE: " + connector.getConnection().toString());
                textFieldStatus.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            }
            catch (SQLException e)
            {
                Alert error = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                error.showAndWait();
            }
        }
        else
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "Connection already established", ButtonType.OK);
            error.show();
        }
    }
    @FXML
    protected void disconnect()
    {
        if(connector != null)
        {
            try
            {
                connector.closeConnection();

                // Очистка данных из ComboBox
                cbDirections.getItems().clear();

                // Очистка данных из TableView на вкладках
                tableStudents.getItems().clear();
                tableStudents.getColumns().clear();
                tableGroups.getItems().clear();
                tableGroups.getColumns().clear();
                tableDirections.getItems().clear();
                tableDirections.getColumns().clear();

                connector = null;
                //labelStatus.setText("Disconnected");
                textFieldStatus.setText("Disconnected");
                textFieldStatus.setStyle("-fx-text-fill: red; -fx-font-weight: normal;");
            }
            catch (SQLException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
        }
    }

}
