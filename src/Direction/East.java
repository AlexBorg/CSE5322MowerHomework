package Direction;

import java.awt.*;

/**
 * Direction.East direction State
 */
public class East extends Direction {
    private static East instance = null;
    public static Direction getInstance() {
        if (instance == null)
            instance = new East();
        return instance;
    }

    public Direction turnLeft() {
        return getNorth();
    }

    public Direction turnRight() {
        return getSouth();
    }

    public Direction turnAround() {
        return getWest();
    }

    public Point moveForward(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        return new Point(x+1,y);
    }

    public Neighbors getNeighbors(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        Neighbors neighbors = new Neighbors();
        neighbors.left =    new Point(x    , y - 1);
        neighbors.fore =    new Point(x + 1, y    );
        neighbors.right =   new Point(x    , y + 1);
        neighbors.leftAft = new Point(x - 1, y - 1);
        return neighbors;
    }
}
