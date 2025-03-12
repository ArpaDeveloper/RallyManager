package main;

import java.util.ArrayList;
import java.util.List;

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
    
    //Getter
    public static ChampionshipManager getInstance(){
        //Only create instance if it doesn't exists
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings(){
        List<Driver> sortedDrivers = new ArrayList<>(drivers);
        sortedDrivers.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return sortedDrivers;
    }

    //Help of !ChatGPT
    public static Driver getLeadingDriver(){
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        List<Driver> sortedDrivers = championshipManager.getDriverStandings();
        return sortedDrivers.isEmpty() ? null : sortedDrivers.get(0);
    }

    public static int getTotalChampionshipPoints(){
        int totalPoints = 0;
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        for(Driver driver : championshipManager.drivers){
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }
}

