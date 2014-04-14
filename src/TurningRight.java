/**
 * State for turning right
 */
public class TurningRight extends MowerState {
    private static TurningRight instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new TurningRight();
        return instance;
    }

    public MowerState enterState(Mower mower) {
        mower.turnLeft();
        return MovingForward.getInstance();
    }
}
