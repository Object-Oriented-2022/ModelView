package com.example.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.Model.Model.getTimeStamp;
import static com.example.ViewModel.ViewModel.getClickedTeam;

public class editorController implements Initializable{
    @FXML
    TextField myName;

    @FXML
    TextField myScore;

    @FXML
    TextField myDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] teamInfo = getClickedTeam();

        myName.setText(teamInfo[0]);
        myScore.setText(teamInfo[1]);
        if(teamInfo.length < 2){
            myDate.setText(getTimeStamp());
        } else {
            myDate.setText(teamInfo[2]);
        }

    }
}

