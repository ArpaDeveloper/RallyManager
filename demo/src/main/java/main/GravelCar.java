package main;

/**
*This class extends RallyCar to make GravelCar
*
*@author Aarni Viljanen
*@version 1.0
*
*@param suspensionTravel is the modifier for GravelCar performance
*/
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
    
    /**
    *Method to calculate GravelCars performance
    */
    @Override
    public double calculatePerformance(){
        //If horsepower is over 200 then get 50 bonus performance
        if(super.getHorsepower() >= 200){
            return super.getHorsepower() * suspensionTravel + 50.0;
        }//Else lose 50 performance
        else{
            return super.getHorsepower() * suspensionTravel - 50.0;
        }
    }
}
