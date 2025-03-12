package main;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ChampionshipStatistics {

  public static double calculateAveragePointsPerDriver(List<Driver> drivers){
    int totalPoints = 0;
    for (Driver driver : drivers) {
      totalPoints += driver.getPoints(); 
    }
    return (double) totalPoints / drivers.size();
  }

  //!Help of ChatGPT
  public static String findMostSuccessfulCountry(List<Driver> drivers){
    Map<String, Integer> countryPointsMap = new HashMap<>();

    for(Driver driver : drivers){
      String country = driver.getCountry();
      int points = driver.getPoints();
      countryPointsMap.put(country, points);
    }
    String mostSuccessfulCountry = null;
    int maxPoints = 0;

    for (Map.Entry<String, Integer> entry : countryPointsMap.entrySet()) {
        if (entry.getValue() > maxPoints) {
            maxPoints = entry.getValue();
            mostSuccessfulCountry = entry.getKey();
        }
    }

    return mostSuccessfulCountry;
  }
//Help ends

  public static int getTotalRacesHeld(){
   return ChampionshipManager.getTotalRaces();
  }
}
