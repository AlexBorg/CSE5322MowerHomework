import java.awt.*;

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
        mower.history.add((Point)mower.p.clone());
        if (mower.p.getX() == 0.0 && mower.p.getY() == 0.0)
            mower.timesVisitedOriginSinceLastCut++;
        mower.moveForward();
        return Cutting.getInstance();
    }
}
