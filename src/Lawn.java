import java.awt.*;

/**
 * data set for lawn. Right now it holds a 2D array of integers. Could be expanded to treat each point as a class
 * inherited from a generic terrain interface
 *
 * 0,0 is the north west corner of the lawn. the x coordinate corresponds to east-west traversal. The y coordinate
 * corresponds to North-South traversal.
 */
public class Lawn {
    public static final int PAVEMENT = 0;
    public static final int CUT_GRASS = 1;
    public static final int GRASS = 2;
    public static final int TRAP = 9;
    public static final int OBSTACLE = 10;

    private int data[][];

    public Lawn(int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("height or width is out of bounds");
        data = new int[width][height];
        for (int i=0; i < data.length; ++i) {
            for (int j=0; j < data[0].length; ++j) {
                data[i][j]=GRASS;
            }
        }
    }

    public int get(Point p) {
        if (p.getX() < 0 || p.getY() < 0)
            return OBSTACLE;
        return get((int)(p.getX()+0.5), (int)(p.getY()+0.5));
    }

    public int get(int x, int y) {
        if (   (x >= 0)
            && (y >= 0)
            && (x < getWidth())
            && (y < getHeight()))
            return data[x][y];
        return OBSTACLE;
    }

    public void set(Point p, int terrain) throws Exception {
        set((int)(p.getX()+0.5), (int)(p.getY()+0.5), terrain);
    }

    public void set(int x, int y, int terrain) throws Exception {
        if (   (x < 0)
            || (y < 0)
            || (x >= getWidth())
            || (y >= getHeight()))
            throw new IllegalArgumentException("outside array bounds");

        data[x][y] = terrain;
    }

    public void cutGrass(Point p) {
        cutGrass((int) (p.getX() + 0.5), (int) (p.getY() + 0.5));
    }

    public void cutGrass(int x, int y) {
        if (   (x < 0)
            || (y < 0)
            || (x >= getWidth())
            || (y >= getHeight()))
            throw new IllegalArgumentException("outside array bounds");

        if ( data[x][y] == GRASS
            || data[x][y] == CUT_GRASS )
            data[x][y] = CUT_GRASS;
    }

    public int getWidth() {
        return data.length;
    }

    public int getHeight() {
        return data[0].length;
    }

    public boolean isAllCut() {
        for (int[] col : data) {
            for (int element : col) {
                if (element == GRASS) {
                    return false;
                }
            }
        }
        return true;
    }
}
