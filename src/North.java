import java.awt.*;

/**
 * North direction State
 */
public class North extends Direction {
    private static North instance = null;
    public static Direction getInstance() {
        if (instance == null)
            instance = new North();
        return instance;
    }

    public Direction turnLeft(Mower mower) {
        return mower.direction = West.getInstance();
    }

    public Direction turnRight(Mower mower) {
        return mower.direction = East.getInstance();
    }

    public Direction turnAround(Mower mower) {
        return mower.direction = South.getInstance();
    }

    public Point moveForward(Mower mower) {
        int x = (int)(mower.p.getX() + 0.5);
        int y = (int)(mower.p.getY() + 0.5);
        return mower.p = new Point(x,y-1);
    }

    public String printArrow() {
        return "\u2191";
    }

    public Neighbors getNeighbors(Mower mower) {
        int x = (int)(mower.p.getX() + 0.5);
        int y = (int)(mower.p.getY() + 0.5);
        Neighbors neighbors = new Neighbors();
        neighbors.left =    new Point(x - 1, y    );
        neighbors.fore =    new Point(x    , y - 1);
        neighbors.right =   new Point(x + 1, y    );
        neighbors.leftAft = new Point(x - 1, y + 1);
        return neighbors;
    }
}
