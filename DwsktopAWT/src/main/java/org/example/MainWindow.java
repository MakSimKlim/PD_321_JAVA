package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends Frame{
    //Label results;
    Label lblLastName = new Label("Last name: ");
    Label lblFirstName = new Label("First name: ");
    Label lblBirthDate = new Label("Birth date: ");
    Label results = new Label("Results");

    TextField textLastName = new TextField();
    TextField textFirstName = new TextField();
    TextField textBirthDate = new TextField();

    public MainWindow() throws HeadlessException {

        this.setBounds(200,200,400,300);
        this.setTitle("AWT-Abstract Window Toolkit");
        //Button button = new Button("Button");
        //button.setBounds(50,50,100,50);
        //add(button);
        //this.setLayout(null);

        Button btnSubmit = new Button("Submit");
        Button btnReset = new Button("Reset");

        /*
        lblLastName.setBounds(50,50,100,32);
        lblFirstName.setBounds(50,100,100,32);
        lblBirthDate.setBounds(50,150,100,32);

        textLastName.setBounds(200,50,100,32);
        textFirstName.setBounds(200,100,100,32);
        textBirthDate.setBounds(200,150,100,32);

        btnSubmit.setBounds(50,200,100,50);
        btnReset.setBounds(200,200,100,50);
        */

        this.add(lblLastName);
        this.add(textLastName);

        this.add(lblFirstName);
        this.add(textFirstName);

        this.add(lblBirthDate);
        this.add(textBirthDate);

        this.add(btnSubmit);
        this.add(btnReset);

        this.add(results);

        btnSubmit.addActionListener(this::btnSubmitHandler);//подписка на события

        GridLayout grid = new GridLayout(5,2,30,30);
        //this.setLayout(null);
        this.setLayout(grid);
        this.setVisible(true);
    }
    public void btnSubmitHandler(ActionEvent e)
    {
        String results = textLastName.getText() + " " + textFirstName.getText() + " " + textBirthDate.getText();
        this.results.setText(results);

    }
}
