package main;

public class GravelCar extends RallyCar{

    //Variables
    private double suspensionTravel;

    //Constructor
    public GravelCar(String make, String model, int horsepower, double suspensionTravel){
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    //Getter
    public double getSuspensionTravel(){
        return suspensionTravel;
    }

    public double calculatePerformance(){
        if(horsepower =< 200){
            return horsepower * suspensionTravel;
        }
        else{
            return horsepower * suspensionTravel - 20.0;
        }
    }
}
