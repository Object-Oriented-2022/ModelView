package com.example.ViewModel;

import com.example.HelloApplication;
import com.example.Teams.Team;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.example.Model.Model.*;

public class ViewModel {

    private static ArrayList<String> editorTeam = new ArrayList<>();
    private static ArrayList<Team> teams = new ArrayList<>();

    public static String[] populateScoreboard(){
        teams = getTeams();
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
        editorTeam.addAll(Arrays.asList(clickedTeam));

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Editor.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 440, 150);
        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<String> getClickedTeam(){
        return editorTeam;
    }

    private static void clearList(){
        editorTeam.clear();
    }

    public static String newTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static void updateStages(Team newInfo){
        System.out.println(newInfo.toString());
        //search by previous date?

        //need to grab stage info
        //need to set each stage to newInfo

    }
}
