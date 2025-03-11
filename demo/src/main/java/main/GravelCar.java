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
   
    @Override
    public double calculatePerformance(){
        if(super.getHorsepower() <= 200){
            return super.getHorsepower() * suspensionTravel;
        }
        else{
            return super.getHorsepower() * suspensionTravel - 20.0;
        }
    }
}
