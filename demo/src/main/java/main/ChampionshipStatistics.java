package main;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
*This class has the methods to calculate Championship statistics
*
*@author Aarni Viljanen
*@version 1.0
*/
public class ChampionshipStatistics {

  /**
  *This method is used to calculate average points per driver
  *
  *@param totalPoints is the totalpoints of the driver
  */
  public static double calculateAveragePointsPerDriver(List<Driver> drivers){
    int totalPoints = 0;
    //Loop through the drivers and add to totalpoints
    for (Driver driver : drivers) {
      totalPoints += driver.getPoints(); 
    }
    //Divide the totalpoints by the amount of drivers to get average
    return (double) totalPoints / drivers.size();
  }

  /**
  *This method is used to find the country with most points
  *Help of ChatGPT was used in this method
  *
  *@param drivers is the list of the drivers
  */
  public static String findMostSuccessfulCountry(List<Driver> drivers){
    //Map to store country and its points
    Map<String, Integer> countryPointsMap = new HashMap<>();
    //Loop through drivers to get the country and its points and add it to map
    for(Driver driver : drivers){
      String country = driver.getCountry();
      int points = driver.getPoints();
      //Works even with multiple same country drivers
      countryPointsMap.put(country, countryPointsMap.getOrDefault(country, 0) + points); 
    }
    String mostSuccessfulCountry = null;
    int maxPoints = 0;
    //Loop through the map to get the country with most points
    for (Map.Entry<String, Integer> entry : countryPointsMap.entrySet()) {
        if (entry.getValue() > maxPoints) {
            maxPoints = entry.getValue();
            mostSuccessfulCountry = entry.getKey();
        }
    }
    return mostSuccessfulCountry;
  }//ChatGPT help ends

  /**
  *Method to get the total race count
  */
  public static int getTotalRacesHeld(){
   return ChampionshipManager.getTotalRaces();
  }
}
