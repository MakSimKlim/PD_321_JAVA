package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

//*** Как установить JavaFX ***
//скачать JavaFX SDK с офф.сайта https://gluonhq.com/products/javafx/
//Run->Edit Configuration ->  Add "Application"
//VM Options вставить (с указанием пути распаковки JavaFX SDK):
// --module-path "E:\Parents\Soft\JAVA\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics --add-exports=javafx.graphics/com.sun.glass.utils=ALL-UNNAMED

public class Main extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception
    {
        System.out.println("Hello, JavaFX!");
    }
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello, World!");
    }
}