package com.example.demo.models;

public class Mastery {
    private int championLevel;
    private int championPoints;

    public Mastery(int championLevel, int championPoints) {
        this.championLevel = championLevel;
        this.championPoints = championPoints;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(int championPoints) {
        this.championPoints = championPoints;
    }
}
