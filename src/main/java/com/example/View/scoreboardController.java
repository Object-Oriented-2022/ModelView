package com.example.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.ViewModel.ViewModel.openEditorView;
import static com.example.ViewModel.ViewModel.populateScoreboard;

public class scoreboardController extends Observable implements Initializable{

    @FXML
    public ListView<String> myListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(populateScoreboard(new scoreboardController()));
    }

    @FXML
    public void handleMouseClick() throws IOException {
        int clickedIndex = myListView.getSelectionModel().getSelectedIndex();
        openEditorView(clickedIndex);
    }

    @Override
    public void update(Object teams) {
        myListView.getItems().setAll((String[]) teams);
    }
}