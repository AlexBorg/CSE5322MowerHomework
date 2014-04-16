/**
 * State for turning around
 */
public class TurningAround extends MowerState {
    private static TurningAround instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new TurningAround();
        return instance;
    }

    public MowerState enterState(Mower mower) {
        mower.turnAround();
        return Percepting.getInstance();
    }
}
