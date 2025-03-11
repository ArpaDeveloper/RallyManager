package main;

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
