package com.example.ViewModel;

import com.example.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.Model.Model.getTeam;

public class ViewModel {

    @FXML
    private static String[] team;

    public static void openEditorView(int index) throws IOException {
        String clickedTeam = getTeam(index);
        team = clickedTeam.split(" ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Editor.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 440, 150);
        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static String[] getClickedTeam(){
        return team;
    }
}
