/**
 * State for cutting grass
 */
public class Cutting extends MowerState {
    private static Cutting instance = null;
    public static MowerState getInstance() {
        if (instance == null)
            instance = new Cutting();
        return instance;
    }

    public MowerState enterState(Mower mower) {
        if (mower.lawn.get(mower.p) == Lawn.GRASS) {
            mower.history.clear();
            mower.timesVisitedOriginSinceLastCut = 0;
        }
        mower.mowGrass();
        return Percepting.getInstance();
    }
}
