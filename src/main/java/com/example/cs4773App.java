package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.Facade.loadScoreboard;

public class cs4773App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        loadScoreboard(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}