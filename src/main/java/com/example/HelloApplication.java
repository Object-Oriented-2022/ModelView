package com.example;

import com.example.View.scoreboardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static scoreboardController controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scoreboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 240);
        stage.setTitle("Scoreboard");
        stage.setScene(scene);
        stage.show();
        controller = fxmlLoader.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}