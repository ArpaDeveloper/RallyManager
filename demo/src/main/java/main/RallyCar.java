package main;

/**
*This is a super class RallyCar that different types of cars use
*
*@author Aarni Viljanen
*@version 1.0
*
*@param make is the manufacturer of the car
*@param model is the model of the car
*@param horsepower is the horsepower of the car
*/
public abstract class RallyCar {

    //Variables
    private String make;
    private String model;
    private int horsepower;

    //Constructor
    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    //Getters
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getHorsepower(){
        return horsepower;
    }

    //Method to calculate performance
    public abstract double calculatePerformance();

}
