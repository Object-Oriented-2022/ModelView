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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Team teamInfo = getClickedTeam();
        index = teamInfo.getIndex();
        updateStage(teamInfo);
    }

    @FXML
    public void sendNewData(){
        String name = myName.getText();
        String score = myScore.getText();
        Team team = new Team(index, name, score);
        myDate.setText(team.getTimeStamp());
        updateStages(team);
    }

    public void updateStage(Team teamInfo){
        myName.setText(teamInfo.getName());
        myScore.setText(teamInfo.getScore());
        myDate.setText(teamInfo.getTimeStamp());
    }
}

