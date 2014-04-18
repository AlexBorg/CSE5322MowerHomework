import java.awt.*;

/**
 * Direction State for the Mower class
 * Does not check bounds on any point based functions.
 */
public abstract class Direction {
    public abstract Direction turnLeft(Mower mower);
    public abstract Direction turnRight(Mower mower);
    public abstract Direction turnAround(Mower mower);

    public abstract Point moveForward(Mower mower);

    public abstract Neighbors getNeighbors(Mower mower);

    public abstract String printArrow();

    // these are the data points that the mower algorithm needs to traverse the lawn.
    public class Neighbors {
        public Point left;
        public Point fore;
        public Point right;
        public Point leftAft;
    }
}

