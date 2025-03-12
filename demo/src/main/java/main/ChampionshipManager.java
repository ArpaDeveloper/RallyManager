package main;

import java.util.ArrayList;
import java.util.List;

/**
*This is the single instance to hold drivers, racer and their totals
*
*@author Aarni Viljanen
*@version 1.0
*
*@param instance is the only instance of this class
*@param drivers is the list of drivers
*@param racers is the list of races
*@param totalDrivers is the list of total drivers
*@param totalRacers is the list of total races
*/
public class ChampionshipManager {
    
    //This makes sure there is only one instance of this class
    private static ChampionshipManager instance;
    //Variables
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers;
    private static int totalRaces;

    //Constructor must be private to prevent instantiation from outside of the class
    private ChampionshipManager() {
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
        this.totalDrivers = 0;
        this.totalRaces = 0;
    }
    
    //Getters
    public static ChampionshipManager getInstance(){
        //Only create instance if it doesn't exists
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }
    
    public static int getTotalRaces() {
        return totalRaces;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    /**
    *Method to register drivers
    */
    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    /**
    *Method to add races result
    */
    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }

    /**
    *Method to get driver standings
    *
    *@param sortedDrivers is the list of drivers sorted by position
    */
    public List<Driver> getDriverStandings(){
        List<Driver> sortedDrivers = new ArrayList<>(drivers);
        sortedDrivers.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return sortedDrivers;
    }

    /**
    *Method to get leading driver
    *Help of !ChatGPT was used
    *
    *@param sortedDrivers is the list of drivers sorted by position
    */
    public static Driver getLeadingDriver(){
        //Call the instance
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        List<Driver> sortedDrivers = championshipManager.getDriverStandings();
        //Get the first one (cleading driver) of the sorted list
        return sortedDrivers.isEmpty() ? null : sortedDrivers.get(0);
    }

    /**
    *Method to get total championship points
    *
    *@param totalPoints is used to store the total points
    */
    public static int getTotalChampionshipPoints(){
        int totalPoints = 0;
        //Call the instance
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        //Loop through the list of drivers and add total points
        for(Driver driver : championshipManager.drivers){
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }

}

