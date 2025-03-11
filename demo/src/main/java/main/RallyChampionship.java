package main;

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
        //Create a Main class with a main method that:
        //1. Creates and configures the ChampionshipManager singleton
        //2. Create and register drivers with appropriate cars
        //3. Simulate at least two races with different surfaces
        //4. Display championship standings, statistics, and race results
        //5. Demonstrate car switching between races
        //6. Show performance calculations for different car types

        //1. Create and configure the ChampionshipManager singleton
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();

        //2.Create and register drivers with appropriate cars
        Driver driver1 = new Driver("Kalle Rovanpera", "Finland", new GravelCar("Toyota", "Yaris", 220.0, 2.1));
        Driver driver2 = new Driver("Ott Tanak", "Estonia", new GravelCar("Nissan", "Micra", 200.0, 1.7));
        Driver driver3 = new Driver("Thierry Neuville", "Belgium", new GravelCar("Ford", "Tempo", 250.0, 1.4));
        Driver driver4 = new Driver("Takamoto Katsuta", "Japan", new GravelCar("Honda", "Civic", 150.0, 3.4));
        
        ChampionshipManager.registerDriver(driver1);
        ChampionshipManager.registerDriver(driver2);
        ChampionshipManager.registerDriver(driver3);
        ChampionshipManager.registerDriver(driver4);

        //3. Simulate at least two races with different surfaces
        RallyRaceResult gravelRace = new RallyRaceResult("Open Rally Finland", "Janakkala");
        //luck + performance -> position
        Random random = new Random();
        double driver1_score = random.nextInt(100) + driver1.getCar().calculatePerformance();
        double driver2_score = random.nextInt(100) + driver2.getCar().calculatePerformance();
        double driver3_score = random.nextInt(100) + driver3.getCar().calculatePerformance();
        double driver4_score = random.nextInt(100) + driver4.getCar().calculatePerformance();
       
        championshipManager.addRaceResult(gravelRace);

        //5. Demonstrate car switching between races
        driver1.setCar(new AsphaltCar("Toyota", "Corolla", 300.0, 1.6));
        driver2.setCar(new AsphaltCar("Nissan", "Skyline", 350.0, 1.3));
        driver3.setCar(new AsphaltCar("Ford", "Focus", 270.0, 1.9));
        driver4.setCar(new AsphaltCar("Honda", "Civic Type R", 400.0, 1.1));
    }
}
