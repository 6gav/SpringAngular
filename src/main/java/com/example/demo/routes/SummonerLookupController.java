package com.example.demo.routes;

import com.example.demo.models.Mastery;
import com.example.demo.models.Summoner;
import com.example.demo.utilities.HttpUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class SummonerLookupController {
    private String API_KEY = "RGAPI-122f6f63-75c4-45a3-9752-e44acb5d5abb";

    //Lookup URLs
    //SummonerName/APIKEY
    private String summonerUrl = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/%s?api_key=%s";

    //SummonerID/ChampionID/APIKEY
    private String masteryUrl = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/%s/by-champion/%s?api_key=%s";



    @GetMapping(value = "/Summoner", produces = "application/json")
    public String SearchSummoner(@RequestParam(name="name", defaultValue="Gavin")String name) {

        return HttpUtils.ConvertToJson(GetSummoner(name));
    }

    @GetMapping(value="/Mastery", produces = "application/json")
    public String SearchMastery(@RequestParam(name="name", required = false)String name, @RequestParam(name="champion", required = false)String champion){

        return HttpUtils.ConvertToJson(GetMastery(name, champion));
    }

    private Mastery GetMastery(String name, String champion) {

        Summoner summoner = GetSummoner(name);

        String masteryTarget = String.format(masteryUrl, summoner.getId(), champion, API_KEY);

        Map<String, Object> result = HttpUtils.HttpGet(masteryTarget);

        System.out.println(result.get("championLevel"));

        int championLevel = (int)result.get("championLevel");
        int championPoints = (int)result.get("championPoints");
        return new Mastery(championLevel, championPoints);
    }


    private Summoner GetSummoner(String name) {
        String target = String.format(summonerUrl, name, API_KEY);

        Map<String, Object> result = HttpUtils.HttpGet(target);

        if(result == null){
            return null;
        }

        String summonerName = (String) result.get("name");
        String id = (String) result.get("id");
        int iconId = (int) result.get("profileIconId");
        int level = (int) result.get("summonerLevel");

        Summoner newSummoner = new Summoner(summonerName, id, iconId, level);

        return newSummoner;
    }
}
