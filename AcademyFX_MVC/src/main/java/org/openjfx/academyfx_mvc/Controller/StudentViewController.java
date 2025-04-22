package org.openjfx.academyfx_mvc.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.openjfx.academyfx_mvc.Connector;
import org.openjfx.academyfx_mvc.Model.Human;
import org.openjfx.academyfx_mvc.Model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class StudentViewController extends HumanViewController
{
    @FXML
    private TableView<Human> tableStudents;
    /*
    @FXML
     private TableColumn<Student, Integer> id;
     @FXML
     private TableColumn<Student, String> lastName;
     @FXML
     private TableColumn<Student, String> firstName;
     @FXML
     private TableColumn<Student, String> middleName;
     @FXML
     private TableColumn<Student, Date> birthDate;
     */
    @FXML
    private TableColumn<Student, Integer> group;

    //private final ObservableList<Student> list = FXCollections.observableArrayList();

    @FXML
    protected void initialize()
    {
        super.initialize();
        group.setCellValueFactory(data -> data.getValue().groupProperty().asObject());
        //getDataFromBase();
    }
    public void getDataFromBase()
    {
        try {
            /*id.setCellValueFactory(data -> data.getValue().idProperty().asObject());
            lastName.setCellValueFactory(data -> data.getValue().lastNameProperty());
            firstName.setCellValueFactory(data -> data.getValue().firstNameProperty());
            middleName.setCellValueFactory(data -> data.getValue().middleNameProperty());
            birthDate.setCellValueFactory(data -> data.getValue().birthDateProperty());*/

            //super.getDataFromBase();
            Statement statement = Connector.getConnection().createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Students");
            while(set.next()) list.add(new Student(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), (Date) set.getObject(5), set.getInt(6)));
            tableStudents.setItems(list);
            set.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}