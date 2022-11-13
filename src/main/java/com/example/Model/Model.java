package com.example.Model;
import com.example.Teams.Team;
import com.example.View.Observable;

import java.util.ArrayList;

public class Model extends Observable{

    private static ArrayList<Team> teams = new ArrayList<>();

    public Model(){
        teams.add(new Team(0, "Highly Irresistible Lions", "45"));
        teams.add(new Team(1,"Immovable Tigers", "75"));
        teams.add(new Team(2,"Super  Duper Bears", "100"));
        teams.add(new Team(3,"Incomparable Otters", "30"));
        teams.add(new Team(4,"Resplendent Ocelot", "8"));
    }


    public ArrayList<Team> getTeams() {
        return teams;
    }

    public static Team getTeam(int index) {
        return teams.get(index);
    }

    public static void setTeam(Team team){
        teams.set(team.getIndex(), team);
    }

    public static Model getModel(){
        return new Model();
    }

    @Override
    public void update(Object teamInfo) {
        setTeam((Team) teamInfo);
    }
}
