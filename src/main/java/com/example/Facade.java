package com.example;

import com.example.Teams.Team;
import com.example.View.editorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.ViewModel.ViewModel.addScoreboardController;

public class Facade {

    public static void loadScoreboard(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(cs4773App.class.getResource("Scoreboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 240);
        stage.setTitle("Scoreboard");
        stage.setScene(scene);
        stage.show();
        addScoreboardController(fxmlLoader.getController());
    }

    public static String[] convertToStringArray(ArrayList<Team> teams){
        String[] scoreboardInfo = new String[5];
        int i = 0;
        for (Team team : teams) {
            String row = String.format("%-30s", team.getName()) + team.getScore();
            scoreboardInfo[i] = row;
            i++;
        }
        return scoreboardInfo;
    }

    public static editorController loadEditor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(cs4773App.class.getResource("Editor.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 440, 150);

        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
        return fxmlLoader.getController();
    }

    public static Team checkedTeam(Team newInfo, Team oldInfo) {
        String name = checkName(newInfo.getName(), oldInfo.getName());
        String score = checkScore(newInfo.getScore(), oldInfo.getScore());
        Team newTeam = new Team(oldInfo.getIndex(), name, score);
        if (!oldInfo.getName().equals(newTeam.getName()) && !oldInfo.getScore().equals(newTeam.getScore())) {
            newTeam.setTimeStamp(oldInfo.getTimeStamp());
        }
        return newTeam;
    }
    private static String checkName(String newInfo, String oldInfo) {
        if(newInfo.equals(oldInfo)){
            return newInfo;
        }
        else if (newInfo.trim().isEmpty()) {
            return "No name provided";
        }
        else if(newInfo.length() >= 5 && newInfo.length() <= 50) {
            Pattern p = Pattern.compile("^[a-zA-Z0-9 .-]*$");
            Matcher m = p.matcher(newInfo);
            boolean b = m.matches();
            if (!b) {
                return oldInfo;
            } else{
                return newInfo;
            }
        } else {
            return oldInfo;
        }
    }
    private static String checkScore(String newInfo, String oldInfo) {
        int scoreValue;
        try{
            scoreValue = Integer.parseInt(newInfo);
        } catch (NumberFormatException error){
            System.out.println("Error: number format problem");
            return oldInfo;
        }
        if(newInfo.equals(oldInfo)){
            return oldInfo;
        }
        if (scoreValue >= 0 && scoreValue <= 2000){
            return newInfo;
        } else {
            return oldInfo;
        }
    }
}
