import Direction.Direction;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

/**
 * Test Class to test mower functionality. Will present differnt Lawns to the Mower and have it find a path through them.
 */
public class MowerTest {

    @Test
    public void testCreate() {
        Mower mower = new Mower();
        assertNotNull(mower);

        Point p = new Point(0,0);
        assertEquals(mower.getLocation(), p);
    }

    @Test
    public void testMowGrass() {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(2,2);
        mower.setLawn(lawn);
        mower.mowGrass();
        assertEquals(lawn.get(new Point(0, 0)), Lawn.CUT_GRASS);
    }


    @Test
    public void testTurnAndMove() {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(5,5);
        mower.setLawn(lawn);
        assertEquals(mower.getX(),0);
        assertEquals(mower.getY(),0);
        assertEquals(mower.getDirection(),Direction.getEast());

        mower.moveForward();
        assertEquals(mower.getX(),1);
        assertEquals(mower.getY(),0);

        mower.turnRight();
        mower.moveForward();
        assertEquals(mower.getX(),1);
        assertEquals(mower.getY(), 1);
        assertEquals(mower.getDirection(), Direction.getSouth());

        mower.moveForward();
        mower.moveForward();
        mower.turnAround();
        assertEquals(mower.getX(),1);
        assertEquals(mower.getY(),3);
        assertEquals(mower.getDirection(),Direction.getNorth());

        mower.moveForward();
        mower.turnLeft();
        mower.moveForward();
        assertEquals(mower.getX(), 0);
        assertEquals(mower.getY(),2);
        assertEquals(mower.getDirection(),Direction.getWest());
    }

}
