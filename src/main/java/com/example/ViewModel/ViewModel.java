package com.example.ViewModel;

import com.example.HelloApplication;
import com.example.Teams.Team;
import com.example.View.editorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


import static com.example.Model.Model.*;

public class ViewModel {

    private static Team clickedTeam;

    private static ArrayList<LinkedList<editorController>> stages = new ArrayList<>();

    public static String[] populateScoreboard(){
        ArrayList<Team> teams = getTeams();
        String[] scoreboardInfo = new String[5];
        int i = 0;
        for (Team team : teams) {
            stages.add(new LinkedList<>()); //populate AL with EMPTY linked list not null
            String row = String.format("%-30s", team.getName()) + team.getScore();
            scoreboardInfo[i] = row;
            i++;
        }
        return scoreboardInfo;
    }

    //push to facade (stage scene fxml loader)
    public static void openEditorView(int index) throws IOException {
        clickedTeam = getTeam(index);
        //TODO: move to FACADE
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Editor.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 440, 150);

        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
        System.out.println(fxmlLoader.getController().toString());
        editorController controller = fxmlLoader.getController();
        stages.get(index).add(controller);
    }

    public static Team getClickedTeam(){
        return clickedTeam;
    }

    public static void updateStages(Team newInfo){
        System.out.println(newInfo.toString());
        int index = newInfo.getIndex();
        for(int i = 0; i < stages.get(index).size(); i++){
            stages.get(index).get(i).updateStage(newInfo);
        }

        setTeam(newInfo);
        HelloApplication.controller.updateScoreboard();
    }
}
