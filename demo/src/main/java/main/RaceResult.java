package main;

import java.util.List;

/**
*This interface defines methods that RallyRaceResult can use
*
*@author Aarni Viljanen
*@version 1.0
*/
public interface RaceResult {
    //Methods
    public void recordResult(Driver driver, int position, int points);
    public int getDriverPoints(Driver driver);
    public List<Driver> getResults();
}
