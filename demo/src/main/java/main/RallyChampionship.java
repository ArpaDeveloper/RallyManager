package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
*Program to manage RallyChampionships
*
*This is the main class that's used to call the different files and print results
*Here we declare the properties of the drivers and cars
*This class contains a method to simulate the races
*
*@author Aarni Viljanen
*@version 1.0
*/
public class RallyChampionship 
{
    public static void main( String[] args )
    {
        //1.Creates and configures the ChampionshipManager singleton
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        
        //2.Create and register drivers with appropriate cars
        Driver driver1 = new Driver("Kalle Rovanpera", "Finland", new GravelCar("Toyota", "Yaris", 200, 2.0));
        championshipManager.registerDriver(driver1);
        Driver driver2 = new Driver("Ott Tanak", "Estonia", new GravelCar("Nissan", "Micra", 200, 1.6));
        championshipManager.registerDriver(driver2);
        Driver driver3 = new Driver("Thierry Neuville", "Belgium", new GravelCar("Ford", "Tempo", 220, 1.4));
        championshipManager.registerDriver(driver3);
        Driver driver4 = new Driver("Takamoto Katsuta", "Japan", new GravelCar("Honda", "Civic", 170, 2.6));
        championshipManager.registerDriver(driver4);
        
        //3. Simulate at least two races with different surfaces
        Random random = new Random();
        //Gravel Race
        RallyRaceResult gravelRace = new RallyRaceResult("Open Rally Finland", "Janakkala");
        simulateRace(List.of(driver1, driver2, driver3, driver4), gravelRace, random);
        championshipManager.addRaceResult(gravelRace);

        //4. Demonstrate car switching between races
        driver1.setCar(new AsphaltCar("Toyota", "Corolla", 280, 1.5));
        driver2.setCar(new AsphaltCar("Nissan", "Skyline", 340, 1.3));
        driver3.setCar(new AsphaltCar("Ford", "Focus", 250, 1.9));
        driver4.setCar(new AsphaltCar("Honda", "Civic Type R", 380, 1.2));
        //Asphalt Race
        RallyRaceResult asphaltRace = new RallyRaceResult("Street Race", "Kioto Highway");
        simulateRace(List.of(driver1, driver2, driver3, driver4), asphaltRace, random);
        championshipManager.addRaceResult(asphaltRace);

        //5. Display championship standings, statistics, and race results
        //ChatGPT was used to help make the loops
        System.out.println("===== Arpa's RallyManager =====");
        System.out.println("5 hours of debugging can save you 5 minutes of reading the manual.");
        System.out.println("");
       
        //print Leaderboard
        System.out.println("===== Leaderboard =====");
        List<Driver> standings = championshipManager.getDriverStandings();
        for (int i = 0; i < standings.size(); i++) {
            Driver driver = standings.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }
        System.out.println("");
       
        //print Championship Leader
        System.out.println("===== Championship Leader =====");
        Driver leadingDriver = championshipManager.getLeadingDriver();
        System.out.println("Leading Driver: " + leadingDriver.getName() + " with " + leadingDriver.getPoints() + " points");
        System.out.println("");

        //print Championship Statistics
        System.out.println("===== Championship Statistics =====");
        System.out.println("Total Drivers: "+ championshipManager.getTotalDrivers());
        System.out.println("Total Races: "+ ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Points Per Driver: "+ChampionshipStatistics.calculateAveragePointsPerDriver(ChampionshipManager.getInstance().getDriverStandings()));
        System.out.println("Most Successful Country: " +ChampionshipStatistics.findMostSuccessfulCountry(ChampionshipManager.getInstance().getDriverStandings()));
        System.out.println("Total Championship Points: "+championshipManager.getTotalChampionshipPoints());
        System.out.println("");

        //print Race Results
        System.out.println("===== Race Results =====");
        //Gravel Race Results
        printRaceResults(List.of(driver1, driver2, driver3, driver4), gravelRace);
        System.out.println("");
        //Asphalt Race Results
        printRaceResults(List.of(driver1, driver2, driver3, driver4), asphaltRace);
        System.out.println("");

        //6. Show performance calculations for different car types
        //Make 2 new cars (gravel and asphalt) with same stats and print their performances
        System.out.println("===== Car Performance Ratings =====");
        GravelCar testGravelCar;
        AsphaltCar testAsphaltCar;
        testGravelCar = new GravelCar("Car", "Gravel", 190, 1.5);
        testAsphaltCar = new AsphaltCar("Car", "Asphalt", 190, 1.5);
        System.out.println("Gravel Car Performance: "+testGravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: "+testAsphaltCar.calculatePerformance());
        System.out.println("");
    }

    /**
    *Method to simulate the races
    *This was made with help of ChatGPT
    *There was no clear description where/how the races where supposed to be simulated
    * @param drivers is the list of drivers
    * @param raceResult is used to store the race results
    * @param random is random instance to generate the luck factor
    */
    private static void simulateRace(List<Driver> drivers, RallyRaceResult raceResult, Random random){
        
        //First we make a Map to take in the Driver and their race score
        Map<Driver, Double> driverScores = new HashMap<>();

        //We loop through the drivers and simulate their race performance
        //Random int 0-100 + Car performance = Race performance 
        for(Driver driver : drivers){
            double drivers_raceScore = random.nextInt(100) + driver.getCar().calculatePerformance();
            driverScores.put(driver, drivers_raceScore);
        }
        //Make a list of the map and then sort it to get race results
        List<Map.Entry<Driver, Double>> sortedEntries = new ArrayList<>(driverScores.entrySet());
        sortedEntries.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        //Loop through the list and give drivers points depending on the position
        for (int i = 0; i < sortedEntries.size(); i++) {
            Driver driver = sortedEntries.get(i).getKey();
            int points = 0;
            switch (i) {
                case 0: points = 25; break; //1.position -> 25 points
                case 1: points = 18; break; //2.position -> 18 points
                case 2: points = 15; break; //3.position -> 15 points
                case 3: points = 12; break; //4.position -> 12 points
                default: points = 0; break; //After -> 0 points
            }
            //Call RallyRaceResults.recordResult() to save the race results
            raceResult.recordResult(driver, i + 1, points);
        }//!ChatGPT help ends here
    }

    /**
    *Method to print the individual race results
    * @param drivers is the list of drivers
    * @param raceResult is used to store the race results (In this case accessed to print them)
    */
    private static void printRaceResults(List<Driver> drivers, RallyRaceResult raceResult){
        //I used simulateRaces() as a basis for this
        System.out.println("Race: "+raceResult.getRaceName()+" ("+raceResult.getLocation()+")");
        List<Driver> sortedDrivers = raceResult.getResults();
        //We loop through the list to print the drivers position, name and points
        for (int i = 0; i < sortedDrivers.size(); i++) {
            Driver driver = sortedDrivers.get(i);
            int points = raceResult.getDriverPoints(driver); 
            System.out.println("Position " + (i + 1) + ": " + driver.getName() + " " + points + " points");
        }      
    }

}
