package com.example.Teams;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Team {
    private int index;
    private String name;
    private String score;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String timeStamp;

    public Team(int index, String name, String score) {
        this.index = index;
        this.name = name;
        this.score = score;
        this.timeStamp = dateFormat.format(new Date());
    }

    public Team(int index, String name, String score, String timeStamp) {
        this.index = index;
        this.name = name;
        this.score = score;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return name + "\t" + score + "\t" + timeStamp;
    }

    public int getIndex() {
        return index;
    }
}
