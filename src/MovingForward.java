/**
 * State where the mower percepts its surroundings and decides how to move.
 */
public class MovingForward extends MowerState {
    private static MovingForward instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new MovingForward();
        return instance;
    }

    public MowerState enterState(Mower mower) {
        mower.moveForward();
        return Cutting.getInstance();
    }
}
