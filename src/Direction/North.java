package Direction;

import java.awt.*;

/**
 * Direction.North direction State
 */
public class North extends Direction {
    private static North instance = null;
    public static Direction getInstance() {
        if (instance == null)
            instance = new North();
        return instance;
    }

    public Direction turnLeft() {
        return getWest();
    }

    public Direction turnRight() {
        return getEast();
    }

    public Direction turnAround() {
        return getSouth();
    }

    public Point moveForward(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        return new Point(x,y-1);
    }

    public String printArrow() {
        return "\u2191";
    }

    public Neighbors getNeighbors(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        Neighbors neighbors = new Neighbors();
        neighbors.left =    new Point(x - 1, y    );
        neighbors.fore =    new Point(x    , y - 1);
        neighbors.right =   new Point(x + 1, y    );
        neighbors.leftAft = new Point(x - 1, y + 1);
        return neighbors;
    }
}
