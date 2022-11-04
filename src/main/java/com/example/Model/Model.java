package com.example.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Model {

    /*
    Teaching: a Database of books
     */
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static String timeStamp = dateFormat.format(new Date());

    private static String teams[] = {"Lyons 45", "Bears 46", "Tigers 90", "Otters 22"};

    public static String[] getTeams() {
        return teams;
    }

    public static void setTeam(String team, int index) {
        Model.teams[index] = team;
    }

    //TODO
    public static String getTimeStamp() {
        return timeStamp;
    }

    //TODO
    public static void setTimeStamp(String timeStamp) {
        Model.timeStamp = timeStamp;
    }

    //TODO
    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    //TODO
    public static void setDateFormat(SimpleDateFormat dateFormat) {
        Model.dateFormat = dateFormat;
    }
}
