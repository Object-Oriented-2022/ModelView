package com.example.ViewModel;

import com.example.Model.Model;
import com.example.Teams.Team;
import com.example.View.Observable;
import com.example.View.editorController;
import com.example.View.scoreboardController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.Facade.*;
import static com.example.Model.Model.*;

public class ViewModel implements Observer {

    private static Team clickedTeam;
    private static ArrayList<LinkedList<Observable>> editors = new ArrayList<>();
    private static ArrayList<Observable> models = new ArrayList<>();
    private static ArrayList<Observable> scoreboards = new ArrayList<>();

    public ViewModel(){}

    public static void addScoreboardController(scoreboardController scoreboard){
        scoreboards.add(scoreboard);
    }

    public static String[] populateScoreboard(scoreboardController scoreboard){
        Model model = getModel();
        models.add(model);
        register(model);
        ArrayList<Team> teams = model.getTeams();
        String[] scoreboardInfo = convertToStringArray(teams);
        initializeEditors(scoreboardInfo.length);
        register(scoreboard);
        return scoreboardInfo;
    }

    private static void initializeEditors(int length) {
        for (int i = 0; i < length; i++){
            editors.add(new LinkedList<>());
        }
    }

    private static void register(Observable object){
        object.addObserver(new ViewModel());
    }

    public static void openEditorView(int index) throws IOException {
        clickedTeam = getTeam(index);
        editorController editor = loadEditor();
        register(editor);
        editors.get(index).add(editor);
    }

    public static Team getClickedTeam(){
        return clickedTeam;
    }

    @Override
    public void update(Observable object, Team newTeam) {
        int index = newTeam.getIndex();
        Team team = checkedTeam(newTeam, getTeam(index));
        for(int i = 0; i < editors.get(index).size(); i++){
            editors.get(index).get(i).update(team);
        }
        updateAllObservables(team);
    }

    private void updateAllObservables(Team newTeam) {
        for(int i = 0; i < models.size(); i++){
            models.get(i).update(newTeam);
            Model model = (Model) models.get(i);
            ArrayList<Team> teams = model.getTeams();
            scoreboards.get(i).update(convertToStringArray(teams));
        }
    }
}


