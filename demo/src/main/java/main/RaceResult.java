package main;

import java.util.List;

public interface RaceResult {

    /**
     *This interface defines methods that RallyRaceResult can use
     */
    public void recordResult(Driver driver, int position, int points);
    public int getDriverPoints(Driver driver);
    public List<Driver> getResults();
}
