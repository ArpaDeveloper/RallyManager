package main;

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
