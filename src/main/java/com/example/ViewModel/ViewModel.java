package com.example.ViewModel;

import com.example.Teams.Team;
import com.example.View.editorController;
import com.example.View.scoreboardController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


import static com.example.Model.Model.*;
import static com.example.Facade.loadEditor;

//implements observer method
public class ViewModel {

    private static Team clickedTeam;

    private static ArrayList<LinkedList<editorController>> stages = new ArrayList<>();

    private static scoreboardController scoreboardController;

    public static String[] populateScoreboard(){
        ArrayList<Team> teams = getTeams();
        String[] scoreboardInfo = new String[5];
        int i = 0;
        for (Team team : teams) {
            stages.add(new LinkedList<>());
            String row = String.format("%-30s", team.getName()) + team.getScore();
            scoreboardInfo[i] = row;
            i++;
        }
        return scoreboardInfo;
    }

    public static void openEditorView(int index) throws IOException {
        clickedTeam = getTeam(index);
        editorController controller = loadEditor();
        stages.get(index).add(controller);
    }

    public static Team getClickedTeam(){
        return clickedTeam;
    }

    public static void updateStages(Team newInfo){
        int index = newInfo.getIndex();
        for(int i = 0; i < stages.get(index).size(); i++){
            stages.get(index).get(i).updateStage(newInfo);
        }
        setTeam(newInfo);
        scoreboardController.updateScoreboard();
    }
    public static void setScoreboardController(scoreboardController controller) {
        scoreboardController = controller;
    }

}
