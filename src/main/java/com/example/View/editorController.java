package com.example.View;

import com.example.Teams.Team;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ViewModel.ViewModel.*;

public class editorController extends Observable implements Initializable{
    @FXML
    TextField myName;
    @FXML
    TextField myScore;
    @FXML
    TextField myDate;
    @FXML
    Button mySave;
    int index;

    //this can go away
    //Team setTeam;

    //linked list of all the observers of this view aka linkedlist<ViewModel>
    //REGISTER method

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Team teamInfo = getClickedTeam();
        //setTeam = teamInfo;
        index = teamInfo.getIndex();
        updateStage(teamInfo);
    }

    @FXML
    public void sendNewData(){
        //iterate through linked list and call ViewModel.update(newTeam);
        Team newTeam = new Team(index, myName.getText(), myScore.getText(), myDate.getText());
        //change this to just calling update
        updateObservers(new editorController(), newTeam);
        /*
        String name = myName.getText();
        //boolean nameUpdated = setName(name);
        String score = myScore.getText();
        //boolean scoreUpdated = setScore(score);
        if(!nameUpdated && !scoreUpdated){
            myDate.setText(setTeam.getTimeStamp());
        } else {
            Team newTeam = new Team(index, name, score);
            myDate.setText(newTeam.getTimeStamp());
            setTeam = newTeam;
            updateStages(newTeam);
        }*/
    }

    public void updateStage(Team teamInfo){
        myName.setText(teamInfo.getName());
        myScore.setText(teamInfo.getScore());
        myDate.setText(teamInfo.getTimeStamp());
    }

    /** MOVE SETNAME AND SET SCORE TO facade thats called in the viewmodel
     * the checks can go there
     * will send back data to updateStage() in views
     */

/*
    private boolean setName(String name) {
        if(name.equals(setTeam.getName())){
            myName.setText(name);
            return false;
        }
        if(name.length() >= 5 && name.length() <= 50) {
            Pattern p = Pattern.compile("^[a-zA-Z0-9 .-]*$");
            Matcher m = p.matcher(name);
            boolean b = m.matches();
            if (!b) {
                myName.setText(setTeam.getName());
                return false;
            } else{
                myName.setText(name);
                return true;
            }
        } else {        //TOO long or short or is empty set back to original value
            myName.setText(setTeam.getName());
            return false;
        }
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
    }*/
}

