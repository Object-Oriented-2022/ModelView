package com.example.Model;

import com.example.Teams.Team;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Model {

    /*
    Teaching: a Database of books
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final String timeStamp = dateFormat.format(new Date());

    private static ArrayList<Team> teams = new ArrayList<>(){
        {
            add(new Team("Highly Irresistible Lions", "45", timeStamp));
            add(new Team("Immovable Tigers", "75", timeStamp));
            add(new Team("Super Duper Bears", "100", timeStamp));
            add(new Team("Incomparable Otters", "30", timeStamp));
            add(new Team("Resplendent Ocelot", "8", timeStamp));
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

    public static void setTeam(String name, String score, String timeStamp, int index) {
        Team newInfo = new Team(name, score, timeStamp);
        teams.set(index, newInfo);
    }

    public static String getTimeStamp() {
        return dateFormat.format(new Date());
    }
}
