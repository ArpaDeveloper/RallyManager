package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void recordResult(Driver driver, int position, int points){
        results.put(driver, points);
        driver.addPoints(points);
    }

    public int getDriverPoints(Driver driver){
        return results.getOrDefault(driver, 0);
    }

    //ChatGPT help
    public List<Driver> getResults(){
       // Create a list from the map entries (key=Driver, value=Points)
       List<Map.Entry<Driver, Integer>> resultList = new ArrayList<>(results.entrySet());

       // Sort the list by points (descending order)
       resultList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

       // Extract the drivers from the sorted entries
       List<Driver> sortedDrivers = new ArrayList<>();
       for (Map.Entry<Driver, Integer> entry : resultList) {
           sortedDrivers.add(entry.getKey());
       }

       return sortedDrivers;
    }
}
