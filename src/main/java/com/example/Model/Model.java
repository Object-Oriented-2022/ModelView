package com.example.Model;
import com.example.Teams.Team;
import java.util.ArrayList;

public class Model {

    private static ArrayList<Team> teams = new ArrayList<>(){
        {
            add(new Team(0, "Highly Irresistible Lions", "45"));
            add(new Team(1,"Immovable Tigers", "75"));
            add(new Team(2,"Super  Duper Bears", "100"));
            add(new Team(3,"Incomparable Otters", "30"));
            add(new Team(4,"Resplendent Ocelot", "8"));
        }
    };

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static Team getTeam(int index) {
        return teams.get(index);
    }

    public static void setTeam(Team team){
        teams.set(team.getIndex(), team);
    }
}
