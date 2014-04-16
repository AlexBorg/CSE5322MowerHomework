import Direction.Direction;

import java.awt.*;
import java.util.HashSet;

/**
 * Core Element of the Homework. This class controls all Mower Functionality
 */
public class Mower {
    Point p = new Point(0,0);
    HashSet<Point> history = new HashSet<>();
    int timesVisitedOriginSinceLastCut = 0; // used when we cannot reach remaining grass

    Direction direction = Direction.getEast();
    MowerState state = Cutting.getInstance();
    Lawn lawn = null;

    int dayOfLastMowing = 0 ;

    public void mowGrass() {
        lawn.cutGrass(p);
    }

    public Point getLocation() {return p;}
    public int getX() {return (int)(p.getX() + 0.5);}
    public int getY() {return (int)(p.getY() + 0.5);}
    public Direction getDirection() {return direction;}

    public MowerState enterState() {
        return state = state.enterState(this);
    }

    public MowerState timerEvent(int dayOfTheYear) {
        return state.timerEvent(this, dayOfTheYear);
    }

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

    public void main() throws Exception {
        MowerTest tester = new MowerTest();
        tester.testMowerOpenLawn();
    }

}
