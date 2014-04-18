import java.awt.*;

/**
 * East direction State
 */
public class East extends Direction {
    private static East instance = null;
    public static Direction getInstance() {
        if (instance == null)
            instance = new East();
        return instance;
    }

    public Direction turnLeft(Mower mower) {
        return mower.direction = North.getInstance();
    }

    public Direction turnRight(Mower mower) {
        return mower.direction = South.getInstance();
    }

    public Direction turnAround(Mower mower) {
        return mower.direction = West.getInstance();
    }

    public Point moveForward(Mower mower) {
        int x = (int)(mower.p.getX() + 0.5);
        int y = (int)(mower.p.getY() + 0.5);
        return mower.p = new Point(x+1,y);
    }

    public String printArrow() {
        return "\u2192";
    }

    public Neighbors getNeighbors(Mower mower) {
        int x = (int)(mower.p.getX() + 0.5);
        int y = (int)(mower.p.getY() + 0.5);
        Neighbors neighbors = new Neighbors();
        neighbors.left =    new Point(x    , y - 1);
        neighbors.fore =    new Point(x + 1, y    );
        neighbors.right =   new Point(x    , y + 1);
        neighbors.leftAft = new Point(x - 1, y - 1);
        return neighbors;
    }
}
