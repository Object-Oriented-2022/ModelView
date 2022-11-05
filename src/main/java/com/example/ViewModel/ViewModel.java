package com.example.ViewModel;

import com.example.HelloApplication;
import com.example.Teams.Team;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.Model.Model.getTeam;
import static com.example.Model.Model.getTeams;

public class ViewModel {

    private static ArrayList<String> teamList = new ArrayList<>();

    public static String[] populateScoreboard(){
        ArrayList<Team> teams = getTeams();
        String[] scoreboardInfo = new String[5];
        int i = 0;
        for (Team team : teams) {
            String row = String.format("%-30s", team.getName()) + team.getScore();
            scoreboardInfo[i] = row;
            i++;
        }
        return scoreboardInfo;
    }

    public static void openEditorView(int index) throws IOException {
        clearList();
        String[] clickedTeam = getTeam(index);
        teamList.addAll(Arrays.asList(clickedTeam));

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
