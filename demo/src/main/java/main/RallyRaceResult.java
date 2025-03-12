package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*This is class is used to save the Results of the races
*
*@author Aarni Viljanen
*@version 1.0
*
*@param raceName is the name of the race
*@param location is the location of the race
*@param results is a used to store the driver and points
*/
public class RallyRaceResult implements RaceResult {

    //Variables
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    //Constructor
    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    //Getters
    public String getRaceName(){
        return raceName;
    }
    public String getLocation(){
        return location;
    }

    /**
    *Method to save the results of the race
    *@param driver is the driver whose results we are saving
    *@param position is the position that driver got in the race
    *@param points are points that the driver got from the race
    */
    public void recordResult(Driver driver, int position, int points){
        results.put(driver, points);
        driver.addPoints(points); //Call driver.addPoints() to add points to drivers total
    }
    
    /**
    *Method to get drivers points
    */
    public int getDriverPoints(Driver driver){
        //Return drivers points or 0 if non are found
        return results.getOrDefault(driver, 0);
    }

    /**
    *Method to get the results of the race
    *ChatGPT help was used in this method
    *
    *@param resultList is list to store the driver and points
    *@param sortedDrivers is a sorted list of the drivers and points
    */
    public List<Driver> getResults(){
       //Create a list from the map entries (key=Driver, value=Points)
       List<Map.Entry<Driver, Integer>> resultList = new ArrayList<>(results.entrySet());
       
       //Sort the list by points (descending order)
       resultList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
       
       //Extract the drivers from the sorted entries
       List<Driver> sortedDrivers = new ArrayList<>();
       for (Map.Entry<Driver, Integer> entry : resultList) {
           sortedDrivers.add(entry.getKey());
       }
       return sortedDrivers;
    }
}
