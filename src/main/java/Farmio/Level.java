package Farmio;

import Places.Farm;
import UserCode.Conditions.BooleanCondition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;





public class Level {

    ArrayList<String> narratives;
    int gold;
    int endMoney;
    int endWheatSeed;
    int endWheatGreen;
    int endWheatRipe;
    int endChicken;
    int endChickenEggs;
    int endCow;
    int endCowMilk;
    int deadline;

    public Level(JSONObject object, Farmer farmer) {
        JSONArray array = (JSONArray) object.get("narratives");
        narratives = new ArrayList<>();
        for (Object i : array) {
            narratives.add((String) i);
        }

        //need to check against the json object
        gold = farmer.getMoney();
        endMoney = Math.toIntExact((Long) object.get("money"));
        endWheatSeed = Math.toIntExact((Long) object.get("wheat_seed"));
        endWheatGreen = Math.toIntExact((Long) object.get("wheat_green"));
        endWheatRipe = Math.toIntExact((Long) object.get("wheat_ripe"));
        endChicken = 0;
        endChickenEggs = 0;
        endCow = 0;
        endCowMilk = 0;
        deadline = Math.toIntExact((Long) object.get("deadline"));
    }

    public ArrayList<String> getNarratives(){
        return narratives;
    }


    public boolean allDone(Farmer farmer){
       int gold = farmer.getMoney();

       //Wheat Farm

       int WheatSeed = farmer.wheatFarm.getSeeds();
       int WheatGreen = farmer.wheatFarm.getGreenWheat();
       int WheatRipe = farmer.wheatFarm.getRipeWheat();

       //Cow Farm

       return (gold == endMoney )  && (WheatGreen == endWheatGreen)  && (WheatRipe == endWheatRipe) && (endWheatSeed == WheatSeed);
    }

    public boolean checkDeadlineExceeded(int currentDay){
        return deadline <= currentDay;
    }


    public levelState checkAnswer(Farmer farmer){
        assert farmer != null;
        int day = farmer.getDay();
        levelState currentLevelState;
        if(checkDeadlineExceeded(day)){
            currentLevelState =  levelState.FAILED;
        }
        else {
            if (allDone(farmer)) {
                 currentLevelState = levelState.ALLDONE;
            }
            else{
                currentLevelState = levelState.NOTDONE;
            }
        }
        return currentLevelState;
    }



        /*
        farmio.getUi().show("Checking answers now");
        return true;
         */

    enum levelState{
        ALLDONE, NOTDONE, FAILED;
    }

}
