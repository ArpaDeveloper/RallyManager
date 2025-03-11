package main;

public class RallyRaceResult {

    //Variables
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    //Constructor
    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
    }

    //Getters
    public String getRaceName(){
        return raceName;
    }
    public String getLocation(){
        return location;
    }

    public void recordResult(Driver driver, int position, int points){

    }

    public int getDriverPoints(Driver driver){

    }

    public List<Driver> getResults(){
        
    }
}
