package org.openjfx.academyfx_mvc.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import org.openjfx.academyfx_mvc.Connector;
import org.openjfx.academyfx_mvc.HelloApplication;

import java.io.IOException;

public class HelloController {
    @FXML
    private Tab tabStudents;
    @FXML
    private Tab tabGroups;
    @FXML
    private Tab tabDirections;
    @FXML
    private Tab tabHumans;
    @FXML
    private TextField textFieldStatus;

    @FXML
    private void initialize()
    {
        textFieldStatus.setText("Connected: " + Connector.getConnection().toString());
    }
    @FXML
    protected void onTabStudentsSelected()throws IOException
    {
        if(tabStudents.isSelected())
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/student-view.fxml"));
            tabStudents.setContent(fxmlLoader.load());
            StudentViewController controller = fxmlLoader.getController();
            controller.getDataFromBase();
        }
    }
    @FXML
    protected void onTabDirectionsSelected()throws IOException
    {
        if(tabDirections.isSelected())
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/direction-view.fxml"));
            tabDirections.setContent(fxmlLoader.load());
        }
    }
    @FXML
    protected void onTabHumansSelected()throws IOException
    {
        if(tabHumans.isSelected())
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/human-view.fxml"));
            tabHumans.setContent(fxmlLoader.load());
            HumanViewController controller = fxmlLoader.getController();
            controller.getDataFromBase();
        }
    }
}