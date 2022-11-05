package com.example.ViewModel;

import com.example.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.Model.Model.getTeam;

public class ViewModel {

    private static ArrayList<String> teamList = new ArrayList<>();

    public static void openEditorView(int index) throws IOException {
        clearList();
        String clickedTeam = getTeam(index);
        String[] team = clickedTeam.split(" ");
        teamList.addAll(Arrays.asList(team));

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Editor.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 440, 150);
        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<String> getClickedTeam(){
        return teamList;
    }

    private static void clearList(){
        teamList.clear();
    }
}
