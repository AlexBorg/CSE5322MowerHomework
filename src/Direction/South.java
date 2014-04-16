package Direction;

import java.awt.*;

/**
 * Direction.South direction State
 */
public class South extends Direction {
    private static South instance = null;
    public static Direction getInstance() {
        if (instance == null)
            instance = new South();
        return instance;
    }

    public Direction turnLeft() {
        return getEast();
    }

    public Direction turnRight() {
        return getWest();
    }

    public Direction turnAround() {
        return getNorth();
    }

    public Point moveForward(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        return new Point(x,y+1);
    }

    public String printArrow() {
        return "\u2193";
    }

    public Direction.Neighbors getNeighbors(final Point start) {
        int x = (int)(start.getX() + 0.5);
        int y = (int)(start.getY() + 0.5);
        Neighbors neighbors = new Neighbors();
        neighbors.left =    new Point(x + 1, y    );
        neighbors.fore =    new Point(x    , y + 1);
        neighbors.right =   new Point(x - 1, y    );
        neighbors.leftAft = new Point(x + 1, y - 1);
        return neighbors;
    }

}
