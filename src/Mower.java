import Direction.Direction;

import java.awt.*;

/**
 * Core Element of the Homework. This class controls all Mower Functionality
 */
public class Mower {
    private Point p = new Point(0,0);
    private Direction direction = Direction.getEast();

    private Lawn lawn = null;

    public void mowGrass() {
        lawn.cutGrass(p);
    }

    public Point getLocation() {return p;}
    public int getX() {return (int)(p.getX() + 0.5);}
    public int getY() {return (int)(p.getY() + 0.5);}
    public Direction getDirection() {return direction;}

    public Direction turnLeft() {
        return direction = direction.turnLeft();
    }

    public Direction turnRight() {
        return direction = direction.turnRight();
    }

    public Direction  turnAround() {
        return direction = direction.turnAround();
    }

    public Point moveForward() {
        return p = direction.moveForward(p);
    }

    public void setLawn(Lawn lawnIn) {
        lawn = lawnIn;
    }

}
