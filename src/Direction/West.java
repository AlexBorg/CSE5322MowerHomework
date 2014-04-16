package Direction;

import java.awt.*;

/**
 * Direction.West direction State
 */
public class West extends Direction {
    private static West instance = null;
    public static Direction getInstance() {
        if (instance == null)
            instance = new West();
        return instance;
    }

    public Direction turnLeft() {
        return getSouth();
    }

    public Direction turnRight() {
        return getNorth();
    }

    public Direction turnAround() {
        return getEast();
    }

    public Point moveForward(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        return new Point(x-1,y);
    }

    public String printArrow() {
        return "\u2190";
    }

    public Direction.Neighbors getNeighbors(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        Neighbors neighbors = new Neighbors();
        neighbors.left =    new Point(x    , y + 1);
        neighbors.fore =    new Point(x - 1, y    );
        neighbors.right =   new Point(x    , y - 1);
        neighbors.leftAft = new Point(x + 1, y + 1);
        return neighbors;
    }
}
