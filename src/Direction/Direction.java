package Direction;

import java.awt.*;

/**
 * Direction.Direction State for the Mower class
 * Does not check bounds on any point based functions.
 */
public abstract class Direction {
    public abstract Direction turnLeft();
    public abstract Direction turnRight();
    public abstract Direction turnAround();

    public abstract Point moveForward(final Point start);

    public abstract Neighbors getNeighbors(final Point start);

    // these are the data points that the mower algorithm needs to traverse the lawn.
    public class Neighbors {
        Point left;
        Point fore;
        Point right;
        Point leftAft;
    }

    public static Direction getNorth() {
        return North.getInstance();
    }

    public static Direction getEast() {
        return East.getInstance();
    }

    public static Direction getSouth() {
        return South.getInstance();
    }

    public static Direction getWest() {
        return West.getInstance();
    }
}

