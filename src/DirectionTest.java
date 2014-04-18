import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the direction state
 */
public class DirectionTest {
    protected Direction north = null;
    protected Direction east = null;
    protected Direction south = null;
    protected Direction west = null;

    @Before
    public void setPointers() {
        north = North.getInstance();
        east = East.getInstance();
        south = South.getInstance();
        west = West.getInstance();
    }

    @Test
    public void testNorth() throws Exception {
        Direction dir = North.getInstance();
        assertNotNull(dir);

        Mower mower = new Mower();
        Direction result ;
        result = dir.turnLeft(mower);
        assertEquals(result,west);
        result = dir.turnRight(mower);
        assertEquals(result,east);
        result = dir.turnAround(mower);
        assertEquals(result,south);

        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(mower);
        assertEquals(neighbors.left.getX(), -1.0, tolerance);
        assertEquals(neighbors.left.getY(),  0.0, tolerance);

        assertEquals(neighbors.fore.getX(),  0.0, tolerance);
        assertEquals(neighbors.fore.getY(), -1.0, tolerance);

        assertEquals(neighbors.right.getX(), 1.0, tolerance);
        assertEquals(neighbors.right.getY(), 0.0, tolerance);

        assertEquals(neighbors.leftAft.getX(), -1.0, tolerance);
        assertEquals(neighbors.leftAft.getY(),  1.0, tolerance);
    }

    @Test
    public void testEast() throws Exception {
        Direction dir = East.getInstance();
        assertNotNull(dir);

        Mower mower = new Mower();
        Direction result ;
        result = dir.turnLeft(mower);
        assertEquals(result,north);
        result = dir.turnRight(mower);
        assertEquals(result,south);
        result = dir.turnAround(mower);
        assertEquals(result,west);

        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(mower);
        assertEquals(neighbors.left.getX(),  0.0, tolerance);
        assertEquals(neighbors.left.getY(), -1.0, tolerance);

        assertEquals(neighbors.fore.getX(),  1.0, tolerance);
        assertEquals(neighbors.fore.getY(),  0.0, tolerance);

        assertEquals(neighbors.right.getX(), 0.0, tolerance);
        assertEquals(neighbors.right.getY(), 1.0, tolerance);

        assertEquals(neighbors.leftAft.getX(), -1.0, tolerance);
        assertEquals(neighbors.leftAft.getY(), -1.0, tolerance);
    }

    @Test
    public void testSouth() throws Exception {
        Direction dir = South.getInstance();
        assertNotNull(dir);

        Mower mower = new Mower();
        Direction result ;
        result = dir.turnLeft(mower);
        assertEquals(result,east);
        result = dir.turnRight(mower);
        assertEquals(result,west);
        result = dir.turnAround(mower);
        assertEquals(result,north);

        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(mower);
        assertEquals(neighbors.left.getX(),  1.0, tolerance);
        assertEquals(neighbors.left.getY(),  0.0, tolerance);

        assertEquals(neighbors.fore.getX(),  0.0, tolerance);
        assertEquals(neighbors.fore.getY(),  1.0, tolerance);

        assertEquals(neighbors.right.getX(),-1.0, tolerance);
        assertEquals(neighbors.right.getY(), 0.0, tolerance);

        assertEquals(neighbors.leftAft.getX(),  1.0, tolerance);
        assertEquals(neighbors.leftAft.getY(), -1.0, tolerance);
    }

    @Test
    public void testWest() throws Exception {
        Direction dir = West.getInstance();
        assertNotNull(dir);

        Mower mower = new Mower();
        Direction result ;
        result = dir.turnLeft(mower);
        assertEquals(result,south);
        result = dir.turnRight(mower);
        assertEquals(result,north);
        result = dir.turnAround(mower);
        assertEquals(result,east);

        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(mower);
        assertEquals(neighbors.left.getX(),  0.0, tolerance);
        assertEquals(neighbors.left.getY(),  1.0, tolerance);

        assertEquals(neighbors.fore.getX(), -1.0, tolerance);
        assertEquals(neighbors.fore.getY(),  0.0, tolerance);

        assertEquals(neighbors.right.getX(), 0.0, tolerance);
        assertEquals(neighbors.right.getY(),-1.0, tolerance);

        assertEquals(neighbors.leftAft.getX(), 1.0, tolerance);
        assertEquals(neighbors.leftAft.getY(), 1.0, tolerance);
    }

}
