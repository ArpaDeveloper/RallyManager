package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *Program to manage RallyChampionships
 *@author Aarni Viljanen
 *@version 1.0
 */

public class RallyChampionship 
{
    public static void main( String[] args )
    {

        System.out.println("===== Arpa's RallyManager =====");
        System.out.println("5 hours of debugging can save you 5 minutes of reading the manual.");
        //1. Create and configure the ChampionshipManager singleton
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();

        //2.Create and register drivers with appropriate cars
        Driver driver1 = new Driver("Kalle Rovanpera", "Finland", new GravelCar("Toyota", "Yaris", 220, 2.0));
        championshipManager.registerDriver(driver1);
        Driver driver2 = new Driver("Ott Tanak", "Estonia", new GravelCar("Nissan", "Micra", 200, 1.7));
        championshipManager.registerDriver(driver2);
        Driver driver3 = new Driver("Thierry Neuville", "Belgium", new GravelCar("Ford", "Tempo", 250, 1.4));
        championshipManager.registerDriver(driver3);
        Driver driver4 = new Driver("Takamoto Katsuta", "Japan", new GravelCar("Honda", "Civic", 150, 2.6));
        championshipManager.registerDriver(driver4);

        //3. Simulate at least two races with different surfaces
        Random random = new Random();

        //Gravel Race
        RallyRaceResult gravelRace = new RallyRaceResult("Open Rally Finland", "Janakkala");
        simulateRace(List.of(driver1, driver2, driver3, driver4), gravelRace, random);
        championshipManager.addRaceResult(gravelRace);
        
        //4. Demonstrate car switching between races
        driver1.setCar(new AsphaltCar("Toyota", "Corolla", 300, 1.5));
        driver2.setCar(new AsphaltCar("Nissan", "Skyline", 350, 1.3));
        driver3.setCar(new AsphaltCar("Ford", "Focus", 270, 1.9));
        driver4.setCar(new AsphaltCar("Honda", "Civic Type R", 380, 1.1));
       
        //Asphalt Race
        RallyRaceResult asphaltRace = new RallyRaceResult("Street Race", "Kioto Highway");
        simulateRace(List.of(driver1, driver2, driver3, driver4), asphaltRace, random);
        championshipManager.addRaceResult(asphaltRace);

     
        //5. Display championship standings, statistics, and race results !ChatGPT was used to help me make the loops to print

        System.out.println("===== Leaderboard =====");
        List<Driver> standings = championshipManager.getDriverStandings();
        for (int i = 0; i < standings.size(); i++) {
            Driver driver = standings.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }
        System.out.println("");
       
        System.out.println("===== Championship Leader =====");
        Driver leadingDriver = championshipManager.getLeadingDriver();
        System.out.println("Leading Driver: " + leadingDriver.getName() + " with " + leadingDriver.getPoints() + " points");
        System.out.println("");

        System.out.println("===== Championship Statistics =====");
        System.out.println("Total Drivers: "+ championshipManager.getTotalDrivers());
        System.out.println("Total Races: "+ ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Points Per Driver: "+ChampionshipStatistics.calculateAveragePointsPerDriver(ChampionshipManager.getInstance().getDriverStandings()));
        System.out.println("Most Successful Country: " +ChampionshipStatistics.findMostSuccessfulCountry(ChampionshipManager.getInstance().getDriverStandings()));
        System.out.println("Total Championship Points: "+championshipManager.getTotalChampionshipPoints());
        System.out.println("");

        System.out.println("===== Race Results =====");

        //Gravel race
        System.out.println("Race: "+gravelRace.getRaceName()+" ("+gravelRace.getLocation()+")");
        List<Driver> sortedDrivers = gravelRace.getResults();

        //Loop to print the race numbers !helped by ChatGPT
        for (int i = 0; i < sortedDrivers.size(); i++) {
            Driver driver = sortedDrivers.get(i);
            int points = gravelRace.getDriverPoints(driver); 
            System.out.println("Position " + (i + 1) + ": " + driver.getName() + " " + points + " points");
        }    
        System.out.println("");

        //Asphalt race
        System.out.println("Race: "+asphaltRace.getRaceName()+" ("+asphaltRace.getLocation()+")");
        sortedDrivers = asphaltRace.getResults();

        //Loop to print the race numbers !helped by ChatGPT
        for (int i = 0; i < sortedDrivers.size(); i++) {
            Driver driver = sortedDrivers.get(i);
            int points = asphaltRace.getDriverPoints(driver); 
            System.out.println("Position " + (i + 1) + ": " + driver.getName() + " " + points + " points");
        }      
        System.out.println("");

        //6. Show performance calculations for different car types
        System.out.println("===== Car Performance Ratings =====");
        System.out.println("");
    }
    //ChatGPT help!
    private static void simulateRace(List<Driver> drivers, RallyRaceResult raceResult, Random random){

        Map<Driver, Double> driverScores = new HashMap<>();

        for(Driver driver : drivers){
            double drivers_raceScore = random.nextInt(100) + driver.getCar().calculatePerformance();
            driverScores.put(driver, drivers_raceScore);
        }
        List<Map.Entry<Driver, Double>> sortedEntries = new ArrayList<>(driverScores.entrySet());
        sortedEntries.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        for (int i = 0; i < sortedEntries.size(); i++) {
            Driver driver = sortedEntries.get(i).getKey();
            int points = 0;
            switch (i) {
                case 0: points = 25; break;
                case 1: points = 18; break;
                case 2: points = 15; break;
                case 3: points = 12; break;
                default: points = 0; break;
            }
            raceResult.recordResult(driver, i + 1, points);
        }

    }

    //Print raceResultsmethod
}
