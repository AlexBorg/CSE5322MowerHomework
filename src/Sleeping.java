/**
 * State for the mower to sleep. Wakes if the date passed is within
 * seasonal bounds and enough time has passed since the last mowing.
 */
public class Sleeping extends MowerState {
    private static Sleeping instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new Sleeping();
        return instance;
    }

    public MowerState timerEvent(Mower mower, int dayOfTheYear) {
        if (   (  ((dayOfTheYear > 140) && (dayOfTheYear < 220)) // high growth season
                && (Math.abs(dayOfTheYear - mower.dayOfLastMowing) > 6))
            && (  ((dayOfTheYear > 100) && (dayOfTheYear < 250))
                && (Math.abs(dayOfTheYear - mower.dayOfLastMowing) > 13))) {
            return mower.state = Cutting.getInstance();
        }
        return this;
    }
}
