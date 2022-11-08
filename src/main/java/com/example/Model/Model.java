package com.example.Model;

import com.example.Teams.Team;


import java.util.ArrayList;


public class Model {

    /*
    Teaching: a Database of books
     */

    private static ArrayList<Team> teams = new ArrayList<>(){
        {
            add(new Team("Highly Irresistible Lions", "45"));
            add(new Team("Immovable Tigers", "75"));
            add(new Team("Super Duper Bears", "100"));
            add(new Team("Incomparable Otters", "30"));
            add(new Team("Resplendent Ocelot", "8"));
        }
    };

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static String[] getTeam(int index) {
        Team team = teams.get(index);
        return new String[]{
                team.getName(),
                team.getScore(),
                team.getTimeStamp()
        };
    }

    public static void setTeam(String name, String score, int index) {
        Team newInfo = new Team(name, score);
        teams.set(index, newInfo);
    }

}
