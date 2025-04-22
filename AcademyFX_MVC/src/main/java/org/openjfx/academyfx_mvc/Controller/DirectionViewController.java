package org.openjfx.academyfx_mvc.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.openjfx.academyfx_mvc.Connector;
import org.openjfx.academyfx_mvc.Model.Direction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DirectionViewController {
    @FXML
    private TableView<Direction> tableDirections;
    @FXML
    private TableColumn<Direction, Integer> directionId;
    @FXML
    private TableColumn<Direction, String> directionName;
    private final ObservableList<Direction> list = FXCollections.observableArrayList();
    @FXML
    private void initialize()
    {
        directionId.setCellValueFactory(data->data.getValue().directionIdProperty().asObject());
        directionName.setCellValueFactory(data->data.getValue().directionNameProperty());
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Directions");
            while(set.next())
                list.add(new Direction(set.getInt(1),set.getString(2)));
            tableDirections.setItems(list);
            set.close();
            statement.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
