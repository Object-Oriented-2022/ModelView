package com.example.View;

import com.example.Teams.Team;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> teamInfo = getClickedTeam();
        myName.setText(teamInfo.get(0));
        myScore.setText(teamInfo.get(1));
        if(teamInfo.size() == 2){
            myDate.setText(newTimeStamp());
        } else {
            myDate.setText(teamInfo.get(2));
        }
    }

    @FXML
    public void sendNewData(){
        String name = myName.getText();
        String score = myScore.getText();
        String date = newTimeStamp();
        myDate.setText(date);
        updateStages(new Team(name, score, date));
    }

}

