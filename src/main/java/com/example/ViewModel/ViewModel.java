package com.example.ViewModel;

import com.example.Model.Model;
import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewModel implements Initializable {
    //public ListView<String> list = new ListView<>();
    @FXML
    public ListView myListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myListView.getItems().addAll(Model.getTeams());
    }
}
