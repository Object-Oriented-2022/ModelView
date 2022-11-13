package com.example;

import com.example.View.editorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.ViewModel.ViewModel.setScoreboardController;

public class Facade {

    //have to cast the editorController method

    public static editorController loadEditor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(cs4773App.class.getResource("Editor.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 440, 150);

        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
        return fxmlLoader.getController();
    }

    public static void loadScoreboard(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(cs4773App.class.getResource("Scoreboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 240);
        stage.setTitle("Scoreboard");
        stage.setScene(scene);
        stage.show();
        setScoreboardController(fxmlLoader.getController());
    }
}
