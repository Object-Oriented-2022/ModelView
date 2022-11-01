package com.example.Teams;

public class Teams {
    private String name;
    private String score;
    private String timeStamp;

    public Teams(String name, String score, String timeStamp) {
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

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Teams{" +
                name + "\t" + score + "\t" + timeStamp;
    }
}
