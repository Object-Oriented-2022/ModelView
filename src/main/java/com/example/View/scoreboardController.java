package com.example.View;

import com.example.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ViewModel.ViewModel.openEditorView;

public class scoreboardController implements Initializable{

    @FXML
    public ListView<String> myListView;

    /*Learning: scoreboard click event "Action event"
     */
    @FXML
    public void handleMouseClick(MouseEvent event) throws IOException {
        int clickedIndex = myListView.getSelectionModel().getSelectedIndex();
        openEditorView(clickedIndex);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(Model.getTeams());
    }
}
