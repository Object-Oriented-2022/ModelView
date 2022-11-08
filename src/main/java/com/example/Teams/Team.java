package com.example.Teams;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Team {
    private String name;
    private String score;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String timeStamp;

    public Team(String name, String score) {
        this.name = name;
        this.score = score;
        this.timeStamp = dateFormat.format(new Date());
    }

    public Team(String name, String score, String timeStamp) {
        this.name = name;
        this.score = score;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {
        this.timeStamp = dateFormat.format(new Date());
    }

    @Override
    public String toString() {
        return name + "\t" + score + "\t" + timeStamp;
    }

}
