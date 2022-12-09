package com.example.proj5;

import android.app.Application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Ifrah Sajjad, Reiya Dave
 *
 * Main class for running entire project. Our driver file.
 * */
public class HelloApplication extends Application {

    /***
     * Method for start
     * @param stage
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("RU Pizzeria GUI");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method. Method we use to launch our program.
     * @param args
     * */
    public static void main(String[] args) {
        launch();
    }
}