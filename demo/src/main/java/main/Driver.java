package main;

/**
*This class defines Drivers and sets their cars
*
*@author Aarni Viljanen
*@version 1.0
*
*@param name is the name of the driver
*@param country is the country where the driver is from
*@param points are the points of the driver
*@param car is the car of the driver
*/
public class Driver {

    //Variables
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    //Constructor
    public Driver(String name, String country, RallyCar car){
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    //Getters
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public int getPoints(){
        return points;
    }
    public RallyCar getCar(){
        return car;
    }

    //Setter
    public void setCar(RallyCar car){
        this.car = car;
    }

    //Method to add points
    public void addPoints(int points){
        this.points += points;
    }
}
