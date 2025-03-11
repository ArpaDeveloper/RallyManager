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
        RallyRaceResult gravelRace = new RallyRaceResult("Open Rally Finland", "Janakkala");
        //Luck + Performance -> Rally Position 
        Random random = new Random();
        double driver1_score_r1 = random.nextInt(100) + driver1.getCar().calculatePerformance();
        double driver2_score_r1 = random.nextInt(100) + driver2.getCar().calculatePerformance();
        double driver3_score_r1 = random.nextInt(100) + driver3.getCar().calculatePerformance();
        double driver4_score_r1 = random.nextInt(100) + driver4.getCar().calculatePerformance();
        
        //Make a hashmap for the scores !ChatGPT help used here
        Map<Driver, Double> driverScores = new HashMap<>();
        driverScores.put(driver1, driver1_score_r1);
        driverScores.put(driver2, driver2_score_r1);
        driverScores.put(driver3, driver3_score_r1);
        driverScores.put(driver4, driver4_score_r1);
       
        // Sort the list based on the scores (highest to lowest)
        List<Map.Entry<Driver, Double>> sortedEntries = new ArrayList<>(driverScores.entrySet());
        sortedEntries.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        //Loop through the list to get drivers position and then assign points
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

            //Record the result for each driver !ChatGPT help stops here
            gravelRace.recordResult(driver, i + 1, points);
        }
        //Add the race results
        championshipManager.addRaceResult(gravelRace);

        //4. Demonstrate car switching between races
        driver1.setCar(new AsphaltCar("Toyota", "Corolla", 300, 1.5));
        driver2.setCar(new AsphaltCar("Nissan", "Skyline", 350, 1.3));
        driver3.setCar(new AsphaltCar("Ford", "Focus", 270, 1.9));
        driver4.setCar(new AsphaltCar("Honda", "Civic Type R", 380, 1.1));

        RallyRaceResult asphaltRace = new RallyRaceResult("Street Race", "Kioto Highway");
        //Luck + Performance -> Rally Position 
        double driver1_score_r2 = random.nextInt(100) + driver1.getCar().calculatePerformance();
        double driver2_score_r2 = random.nextInt(100) + driver2.getCar().calculatePerformance();
        double driver3_score_r2 = random.nextInt(100) + driver3.getCar().calculatePerformance();
        double driver4_score_r2 = random.nextInt(100) + driver4.getCar().calculatePerformance();
        
        //!ChatGPT help used here
        driverScores.put(driver1, driver1_score_r2);
        driverScores.put(driver2, driver2_score_r2);
        driverScores.put(driver3, driver3_score_r2);
        driverScores.put(driver4, driver4_score_r2);
       
        sortedEntries = new ArrayList<>(driverScores.entrySet());
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
            asphaltRace.recordResult(driver, i + 1, points);
        }

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
        if (leadingDriver != null) {
            System.out.println("Leading Driver: " + leadingDriver.getName() + " with " + leadingDriver.getPoints() + " points");
        } else {
            System.out.println("No drivers available.");
        }
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
    }
}
