package com.example.ViewModel;

import com.example.Teams.Team;
import com.example.View.Observable;
import com.example.View.editorController;
import com.example.View.scoreboardController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.Facade.checkedTeam;
import static com.example.Model.Model.*;
import static com.example.Facade.loadEditor;

//implements observer method
public class ViewModel implements Observer {

    private static Team clickedTeam;

    private static ArrayList<LinkedList<editorController>> stages = new ArrayList<>();
    // private static ArrayList<LinkedList<Observable>> stages = new ArrayList<>();
    private static scoreboardController scoreboardController;

    //may be able to remove
    public ViewModel(){};

    public static String[] populateScoreboard(scoreboardController controller){
        ArrayList<Team> teams = getTeams();
        String[] scoreboardInfo = new String[5];
        int i = 0;
        for (Team team : teams) {
            stages.add(new LinkedList<>());
            String row = String.format("%-30s", team.getName()) + team.getScore();
            scoreboardInfo[i] = row;
            i++;
        }
        controller.addObserver(new ViewModel());
        //stages.add(new Linked)
        return scoreboardInfo;
    }

    public static void openEditorView(int index) throws IOException {
        clickedTeam = getTeam(index);
        editorController controller = loadEditor();
        controller.addObserver(new ViewModel());
        stages.get(index).add(controller);
    }

    public static Team getClickedTeam(){
        return clickedTeam;
    }

    public static void setScoreboardController(scoreboardController controller) {
        scoreboardController = controller;
    }

    @Override
    public void update(Observable object, Team newTeam) {
        int index = newTeam.getIndex();
        Team team = checkedTeam(newTeam, getTeam(index));
        for(int i = 0; i < stages.get(index).size(); i++){
            stages.get(index).get(i).updateStage(team);
        }
        setTeam(team);
        scoreboardController.updateScoreboard();
    }
}
