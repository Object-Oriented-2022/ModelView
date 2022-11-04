package com.example.View;

import com.example.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class scoreboardController implements Initializable{
    @FXML
    private Label label;

    @FXML
    public ListView myListView;

    /*Learning: scoreboard click event "Action event"
     */
    @FXML
    public void handleMouseClick(MouseEvent event){
        int clickedIndex = myListView.getSelectionModel().getSelectedIndex();
        System.out.println("clicked on " + clickedIndex);
        //openEditorView(clickedIndex);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(Model.getTeams());
    }
}
