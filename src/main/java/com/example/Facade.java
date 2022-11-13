package com.example;

import com.example.Teams.Team;
import com.example.View.editorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.ViewModel.ViewModel.setScoreboardController;
import static com.example.ViewModel.ViewModel.updateStages;

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

    private static String checkName(String newInfo, String oldInfo) {
        System.out.println(newInfo);
        //no changes are made?
        if(newInfo.equals(oldInfo)){
            return newInfo;
        }
        //if empty
        else if (newInfo == null || newInfo.trim().isEmpty()) {
            return (newInfo = "No name provided");
        }
        //check for length restrictions
        else if(newInfo.length() >= 5 && newInfo.length() <= 50) {
            Pattern p = Pattern.compile("^[a-zA-Z0-9 .-]*$");
            Matcher m = p.matcher(newInfo);
            boolean b = m.matches();
            if (!b) {
                //TODO: change
                return oldInfo;
            } else{
                return newInfo;
            }
        } else {        //TOO long or short or is empty set back to original value
            return oldInfo;
        }
    }
    private static String checkScore(String newInfo, String oldInfo) {
        int scoreValue;
        try{
            scoreValue = Integer.parseInt(newInfo);
        } catch (NumberFormatException error){
            System.out.println("Error: number format problem");
            //error set back to original
            return oldInfo;
        }
        if(newInfo.equals(oldInfo)){
           //if score is hasn't changed set to original
            return oldInfo;
        }
        if (scoreValue >= 0 && scoreValue <= 2000){
            return newInfo;
        } else {
            //not inside the limit, set back to original
            return oldInfo;
        }
    }
    public static Team checkTeam(Team newInfo, Team oldInfo) {
        String name = checkName(newInfo.getName(), oldInfo.getName());
        String score = checkScore(newInfo.getScore(), oldInfo.getScore());
        Team newTeam = new Team(oldInfo.getIndex(), name, score);
        //check if no changes return original oldteam.getTimeStamp()
        if (!newInfo.getName().equals(oldInfo.getName())) {
            //myDate.setText(setTeam.getTimeStamp());
            newTeam.setTimeStamp(oldInfo.getTimeStamp());
        }
        return newTeam;
    }
}
