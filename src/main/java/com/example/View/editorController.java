package com.example.View;

import com.example.Teams.Team;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ViewModel.ViewModel.*;

public class editorController implements Initializable{
    @FXML
    TextField myName;
    @FXML
    TextField myScore;
    @FXML
    TextField myDate;
    @FXML
    Button mySave;
    int index;

    Team setTeam;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Team teamInfo = getClickedTeam();
        setTeam = teamInfo;
        index = teamInfo.getIndex();
        updateStage(teamInfo);
    }

    @FXML
    public void sendNewData(){
        String name = myName.getText();
        boolean nameUpdated = setName(name);
        String score = myScore.getText();
        boolean scoreUpdated = setScore(score);
        if(!nameUpdated && !scoreUpdated){
            myDate.setText(setTeam.getTimeStamp());
        } else {
            Team newTeam = new Team(index, name, score);
            myDate.setText(newTeam.getTimeStamp());
            setTeam = newTeam;
            updateStages(newTeam);
        }
    }

    public void updateStage(Team teamInfo){
        myName.setText(teamInfo.getName());
        myScore.setText(teamInfo.getScore());
        myDate.setText(teamInfo.getTimeStamp());
    }

    private boolean setName(String name) {
        if(name.equals(setTeam.getName())){
            myName.setText(name);
            return false;
        }
        if(name.length() >= 5 && name.length() <= 50){
            if(name.chars().allMatch(Character::isLetterOrDigit)){
                myName.setText(name);
            }
        } else {        //TOO long or short or is empty set back to original value
            myName.setText(setTeam.getName());
            return false;
        }
        return true;
    }

    private boolean setScore(String score) {
        int scoreValue;
        try{
            scoreValue = Integer.parseInt(score);
        } catch (NumberFormatException error){
            System.out.println("Error: number format problem");
            myScore.setText(setTeam.getScore());
            return false;
        }
        if(score.equals(setTeam.getScore())){
            myScore.setText(score);
            return false;
        }
        if (scoreValue >= 0 && scoreValue <= 2000){
            myScore.setText(score);
        } else {
            myScore.setText(setTeam.getScore());
            return false;
        }
        return true;
    }
}

