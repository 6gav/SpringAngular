package com.example.demo.models;

public class Summoner {

    private String summonerName;
    private String id;
    private int iconId;
    private int level;
    private Mastery masteryInfo;

    public Summoner(String summonerName, String id, int iconId, int level) {
        this.summonerName = summonerName;
        this.id = id;
        this.iconId = iconId;
        this.level = level;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
