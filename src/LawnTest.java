import java.awt.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the Lawn Class
 */
public class LawnTest {

    @Test(expected = Exception.class)
    public void testCreate() throws Exception {
        Lawn lawn = new Lawn(5,5);
        assertNotNull(lawn);

        assertEquals(lawn.getWidth(),5);
        assertEquals(lawn.getHeight(),5);

        //expect exception
        lawn = new Lawn(0,0);

        assertNull(lawn);
    }

    @Test
    public void testGet() throws Exception {
        Lawn lawn = new Lawn(5,5);
        assertNotNull(lawn);
        // default terrain should be grass
        assertEquals(lawn.get(0,0),Lawn.GRASS);
        assertEquals(lawn.get(1,1),Lawn.GRASS);
        assertEquals(lawn.get(new Point(4,0)),Lawn.GRASS);
        assertEquals(lawn.get(new Point(0,4)),Lawn.GRASS);

        // out of bounds should return obstacle
        assertEquals(lawn.get(new Point(-1,-1)),Lawn.OBSTACLE);
        assertEquals(lawn.get(new Point(5,5)),Lawn.OBSTACLE);
        assertEquals(lawn.get(5,0),Lawn.OBSTACLE);
        assertEquals(lawn.get(9999,2458259),Lawn.OBSTACLE);
    }

    @Test(expected = Exception.class)
    public void testSet() throws Exception {
        Lawn lawn = new Lawn(5,5);
        assertNotNull(lawn);

        lawn.set(3,3,Lawn.TRAP);

        assertEquals(lawn.get(3, 3), Lawn.TRAP);
        assertEquals(lawn.get(3,2),Lawn.GRASS); // don't change other items.

        assertEquals(lawn.get(new Point(5,5)),Lawn.OBSTACLE);

        lawn.set(new Point(4,4), Lawn.PAVEMENT);
        assertEquals(lawn.get(4, 4), Lawn.PAVEMENT);

        //Expect exception from this
        lawn.set(5,6,Lawn.GRASS);
        assertFalse(true);
    }

    @Test
    public void testCutGrass() throws Exception {
        Lawn lawn = new Lawn(2,2);
        assertNotNull(lawn);

        assertEquals(lawn.isAllCut(), false);

        assertEquals(lawn.get(0,0),Lawn.GRASS);
        lawn.cutGrass(0,0);
        assertEquals(lawn.get(0,0),Lawn.CUT_GRASS);
        assertEquals(lawn.get(1,1),Lawn.GRASS); // don't change other items.

        lawn.cutGrass(0,1);
        lawn.cutGrass(1,0);
        lawn.cutGrass(new Point(1,1));
        assertEquals(lawn.isAllCut(), true);
    }

}
