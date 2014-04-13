package Direction;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

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
        north = Direction.getNorth();
        east = Direction.getEast();
        south = Direction.getSouth();
        west = Direction.getWest();
    }

    @Test
    public void testNorth() throws Exception {
        Direction dir = Direction.getNorth();
        assertNotNull(dir);

        Direction result ;
        result = dir.turnLeft();
        assertEquals(result,west);
        result = dir.turnRight();
        assertEquals(result,east);
        result = dir.turnAround();
        assertEquals(result,south);

        Point p = new Point(0,0);
        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(p);
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
        Direction dir = Direction.getEast();
        assertNotNull(dir);

        Direction result ;
        result = dir.turnLeft();
        assertEquals(result,north);
        result = dir.turnRight();
        assertEquals(result,south);
        result = dir.turnAround();
        assertEquals(result,west);

        Point p = new Point(0,0);
        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(p);
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
        Direction dir = Direction.getSouth();
        assertNotNull(dir);

        Direction result ;
        result = dir.turnLeft();
        assertEquals(result,east);
        result = dir.turnRight();
        assertEquals(result,west);
        result = dir.turnAround();
        assertEquals(result,north);

        Point p = new Point(0,0);
        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(p);
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
        Direction dir = Direction.getWest();
        assertNotNull(dir);

        Direction result ;
        result = dir.turnLeft();
        assertEquals(result,south);
        result = dir.turnRight();
        assertEquals(result,north);
        result = dir.turnAround();
        assertEquals(result,east);

        Point p = new Point(0,0);
        double tolerance = 0.01;
        Direction.Neighbors neighbors = dir.getNeighbors(p);
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
