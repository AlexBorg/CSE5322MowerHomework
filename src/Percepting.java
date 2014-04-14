import Direction.Direction;
import Direction.East;
import Direction.West;

import java.awt.*;

/**
 * State for cutting grass
 */
public class Percepting extends MowerState {
    private static Percepting instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new Percepting();
        return instance;
    }

    // observers the area around the mower and implements clockwise rotation around the lawn.
    public MowerState enterState(Mower mower) {
        Lawn lawn = mower.lawn;

        Direction.Neighbors neighbors = mower.direction.getNeighbors(mower.getLocation());
        int left = lawn.get(neighbors.left);
        int fore = lawn.get(neighbors.fore);
        int right = lawn.get(neighbors.right);
        int leftAft = lawn.get(neighbors.leftAft);

        if (left == Lawn.GRASS)
            return mower.state = TurningLeft.getInstance();
        else if (fore == Lawn.GRASS)
            return mower.state = MovingForward.getInstance();
        else if (right == Lawn.GRASS)
            return mower.state = TurningRight.getInstance();
        else {
            boolean finished = lawn.isAllCut();
            boolean leftBlocked = ((left == Lawn.OBSTACLE) || (left == Lawn.TRAP));
            boolean foreBlocked = ((fore == Lawn.OBSTACLE) || (fore == Lawn.TRAP));
            boolean rightBlocked = ((right == Lawn.OBSTACLE) || (right == Lawn.TRAP));
            boolean leftAftBlocked = ((leftAft == Lawn.OBSTACLE) || ( leftAft == Lawn.TRAP));
            boolean beenHereBefore = false;
            for (Point p : mower.history) {
                if (p.equals(mower.p)) {
                    beenHereBefore = true;
                    break;
                }
            }
            boolean repeatVisitAndWest = beenHereBefore && mower.direction == West.getInstance();

            if (finished && (mower.getX() == 0) && (mower.getY() == 0)) {
                while (mower.direction != East.getInstance())
                    mower.turnRight();
                return mower.state = Sleeping.getInstance();
            }
            else if (leftBlocked && foreBlocked && rightBlocked) {
                return mower.state = TurningAround.getInstance();
            }
            else if (leftBlocked && !foreBlocked && !rightBlocked) {
                return mower.state = TurningRight.getInstance();
            }
            else if (leftBlocked && !foreBlocked) {
                return mower.state = MovingForward.getInstance();
            }
            else if (!leftBlocked && foreBlocked && rightBlocked) {
                return mower.state = TurningLeft.getInstance();
            }
            else if (!leftBlocked && foreBlocked && !rightBlocked && leftAftBlocked) {
                if (repeatVisitAndWest)
                    return mower.state = TurningRight.getInstance();
                return mower.state = TurningLeft.getInstance();
            }
            else if (!leftBlocked && foreBlocked && !rightBlocked && !leftAftBlocked) {
                return mower.state = TurningRight.getInstance();
            }
            else if (!leftBlocked && !foreBlocked && leftAftBlocked) {
                if (repeatVisitAndWest)
                    return mower.state = MovingForward.getInstance();
                return mower.state = TurningLeft.getInstance();
            }
            else if (!leftBlocked && !foreBlocked && !leftAftBlocked) {
                return mower.state = MovingForward.getInstance();
            }
        }

        throw new IllegalArgumentException("invalid state transition. Should be impossible");
    }
}
