package main;

/**
*This class extends RallyCar to make AsphaltCar
*
*@author Aarni Viljanen
*@version 1.0
*
*@param downforce is the modifier for AsphaltCar performance
*/
public class AsphaltCar extends RallyCar{
  
    //Variables
    private double downforce;
   
    //Constructor
    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;
    }
    
    //Getter
    public double getDownforce(){
        return downforce;
    }
   
    /**
    *Method to calculate AsphaltCars performance
    */
    public double calculatePerformance(){
        return super.getHorsepower() * downforce;
    }
}
