/**
 * State for turning left
 */
public class TurningLeft extends MowerState {
    private static TurningLeft instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new TurningLeft();
        return instance;
    }

    public MowerState enterState(Mower mower) {
        mower.turnLeft();
        return MovingForward.getInstance();
    }
}
