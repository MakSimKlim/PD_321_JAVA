package org.openjfx.academyfx_mvc.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.academyfx_mvc.Connector;
import org.openjfx.academyfx_mvc.Model.Human;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class HumanViewController {
    @FXML
    private TableView<Human> tableHumans;

    /*
    @FXML
    private TableColumn<Human, Integer> id;
    @FXML
    private TableColumn<Human, String> lastName;
    @FXML
    private TableColumn<Human, String> firstName;
    @FXML
    private TableColumn<Human, String> middleName;
    @FXML
    private TableColumn<Human, Date> birthDate;*/

    // Колонки из human-columns.fxml
    @FXML
    private TableColumn<Human, Integer> colId;
    @FXML
    private TableColumn<Human, String> colLastName;
    @FXML
    private TableColumn<Human, String> colFirstName;
    @FXML
    private TableColumn<Human, String> colMiddleName;
    @FXML
    private TableColumn<Human, Date> colBirthDate;

    protected final ObservableList<Human> list = FXCollections.observableArrayList();

    @FXML
    protected void initialize()
    {
        /*
        id.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        lastName.setCellValueFactory(data -> data.getValue().lastNameProperty());
        firstName.setCellValueFactory(data -> data.getValue().firstNameProperty());
        middleName.setCellValueFactory(data -> data.getValue().middleNameProperty());
        birthDate.setCellValueFactory(data -> data.getValue().birthDateProperty());
        */
        /*
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        */
        colId.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        colLastName.setCellValueFactory(data -> data.getValue().lastNameProperty());
        colFirstName.setCellValueFactory(data -> data.getValue().firstNameProperty());
        colMiddleName.setCellValueFactory(data -> data.getValue().middleNameProperty());
        colBirthDate.setCellValueFactory(data -> data.getValue().birthDateProperty());


        //load();
    }
    public void getDataFromBase()
    {
        try{
            Statement statement = Connector.getConnection().createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Students,Teachers");
            while(set.next())
                list.add(new Human(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), (Date) set.getObject(5)));
            tableHumans.setItems(list);
            set.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}