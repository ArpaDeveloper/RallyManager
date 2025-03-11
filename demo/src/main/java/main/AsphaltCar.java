package main;

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

    public double calculatePerformance(){
       horsepower * downforce;
    }
}
