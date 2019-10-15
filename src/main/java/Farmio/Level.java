package Farmio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Level {
    ArrayList<String> narratives;
    int startMoney;
    int startWheatSeed;
    int startWheatGreen;
    int startWheatRipe;
    int startChicken;
    int startChickenEggs;
    int startCow;
    int startCowMilk;
    int endMoney;
    int endWheatSeed;
    int endWheatGreen;
    int endWheatRipe;
    int endChicken;
    int endChickenEggs;
    int endCow;
    int endCowMilk;

    public Level(JSONObject object, Farmer farmer) {
        JSONArray array = (JSONArray) object.get("narratives");
        narratives = new ArrayList<>();
        for (Object i : array) {
            narratives.add((String) i);
        }
        startMoney = farmer.getMoney();
        startWheatSeed = farmer.wheatFarm.getSeeds();
        startWheatGreen = farmer.wheatFarm.getGreenWheat();
        startWheatRipe = farmer.wheatFarm.getRipeWheat();
        startChicken = 0;
        startChickenEggs = 0;
        startCow = 0;
        startCowMilk = 0;
        endMoney = Math.toIntExact((Long) object.get("money"));
        endWheatSeed = Math.toIntExact((Long) object.get("wheat_seed"));
        endWheatGreen = Math.toIntExact((Long) object.get("wheat_green"));
        endWheatRipe = Math.toIntExact((Long) object.get("wheat_ripe"));
        endChicken = 0;
        endChickenEggs = 0;
        endCow = 0;
        endCowMilk = 0;
    }

    public ArrayList<String> getNarratives(){
        return narratives;
    }

    public String checkAnswer(){
        return "";
    }
}
