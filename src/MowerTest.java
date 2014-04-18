import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

/**
 * Test Class to test mower functionality. Will present differnt Lawns to the Mower and have it find a path through them.
 */
public class MowerTest {

    @Test
    public void testCreate() throws Exception {
        Mower mower = new Mower();
        assertNotNull(mower);

        Point p = new Point(0,0);
        Point result = mower.getLocation();
        assertEquals(result, p);
    }

    @Test
    public void testMowGrass() throws Exception {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(2,2);
        mower.setLawn(lawn);
        mower.mowGrass();
        assertEquals(lawn.get(new Point(0, 0)), Lawn.CUT_GRASS);
    }


    @Test
    public void testTurnAndMove() throws Exception {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(5,5);
        mower.setLawn(lawn);
        assertEquals(mower.getX(),0);
        assertEquals(mower.getY(),0);
        assertEquals(mower.getDirection(),East.getInstance());

        mower.moveForward();
        assertEquals(mower.getX(),1);
        assertEquals(mower.getY(),0);

        mower.turnRight();
        mower.moveForward();
        assertEquals(mower.getX(),1);
        assertEquals(mower.getY(), 1);
        assertEquals(mower.getDirection(), South.getInstance());

        mower.moveForward();
        mower.moveForward();
        mower.turnAround();
        assertEquals(mower.getX(),1);
        assertEquals(mower.getY(),3);
        assertEquals(mower.getDirection(),North.getInstance());

        mower.moveForward();
        mower.turnLeft();
        mower.moveForward();
        assertEquals(mower.getX(), 0);
        assertEquals(mower.getY(),2);
        assertEquals(mower.getDirection(),West.getInstance());
    }

    void printMowerState(Mower mower) {
        int mowX = mower.getX();
        int mowY = mower.getY();

        Lawn lawn = mower.lawn;

        for (int j=0; j < lawn.getHeight(); ++j) {
            for (int i=0; i < lawn.getWidth(); ++i) {
                System.out.print(lawn.get(i, j));
                if ((i == mowX) && (j == mowY)) {
                    System.out.print(mower.direction.printArrow());
                }
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        System.out.println("------------------------");
    }

    @Test
    public void testMowerOpenLawn() throws Exception {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(20,20);
        mower.setLawn(lawn);

        mower.timerEvent(150);

        while(mower.state != Sleeping.getInstance()) {
            mower.enterState();
            if (mower.state == Percepting.getInstance()) {
                printMowerState(mower);
                Thread.sleep(300);
            }
        }
        printMowerState(mower);
    }

    @Test
    public void testMowerSmallObjects() throws Exception {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(20,20);
        lawn.set(1,0,10);
        lawn.set(4,7,10);
        lawn.set(9,8,10);
        lawn.set(12,17,10);
        lawn.set(19,16,10);
        mower.setLawn(lawn);

        mower.timerEvent(150);

        while(mower.state != Sleeping.getInstance()) {
            mower.enterState();
            if (mower.state == Percepting.getInstance()) {
                printMowerState(mower);
                Thread.sleep(300);
            }
        }
        printMowerState(mower);
    }

    @Test
    public void testMowerLargeObjects() throws Exception {
        Mower mower = new Mower();
        Lawn lawn = new Lawn(20,20);
        mower.setLawn(lawn);
        lawn.set(1,0,10);
        lawn.set(2,0,10);
        lawn.set(1,1,10);
        lawn.set(2,1,10);
        lawn.set(4,7,10);
        lawn.set(5,7,10);
        lawn.set(4,8,10);
        lawn.set(5,8,10);

        lawn.set(9,8,10);
        lawn.set(10,8,10);
        lawn.set(9,9,10);
        lawn.set(10,9,10);

        lawn.set(12,17,10);
        lawn.set(13,17,10);
        lawn.set(12,18,10);
        lawn.set(13,18,10);

        lawn.set(18,16,10);
        lawn.set(19,16,10);
        lawn.set(18,17,10);
        lawn.set(19,17,10);

        mower.timerEvent(150);

        while(mower.state != Sleeping.getInstance()) {
            mower.enterState();
            if (mower.state == Percepting.getInstance()) {
                printMowerState(mower);
                Thread.sleep(100);
            }
        }
        printMowerState(mower);
    }
}
