package org.example;
import java.awt.*;

public class MainWindow extends Frame{
    public MainWindow() throws HeadlessException {
        this.setBounds(200,200,400,300);
        this.setTitle("AWT-Abstract Window Toolkit");
        //Button button = new Button("Button");
        //button.setBounds(50,50,100,50);
        //add(button);
        //this.setLayout(null);

        Label lblLastName = new Label("Last name: ");
        Label lblFirstName = new Label("First name: ");
        Label lblBirthDate = new Label("Birth date: ");

        TextField textLastName = new TextField();
        TextField textFirstName = new TextField();
        TextField textBirthDate = new TextField();

        Button btnSubmit = new Button("Submit");
        Button btnReset = new Button("Reset");

        lblLastName.setBounds(50,50,100,32);
        lblFirstName.setBounds(50,100,100,32);
        lblBirthDate.setBounds(50,150,100,32);

        textLastName.setBounds(200,50,100,32);
        textFirstName.setBounds(200,100,100,32);
        textBirthDate.setBounds(200,150,100,32);

        btnSubmit.setBounds(50,200,100,50);
        btnReset.setBounds(200,200,100,50);

        this.add(lblLastName);
        this.add(lblFirstName);
        this.add(lblBirthDate);

        this.add(textLastName);
        this.add(textFirstName);
        this.add(textBirthDate);

        this.add(btnSubmit);
        this.add(btnReset);

        this.setLayout(null);
        this.setVisible(true);
    }
}
