
/**
 * Base Class for MowerState State Pattern
 *
 * This state is designed to control Mower operations
 * several states do so little they would be easier to implement using a simple function call, however,
 * if the mower simulation increases in the future to simulate wheels or the like, then those states
 * would quickly expand to be more detailed.
 */
public abstract class MowerState {
    public MowerState timerEvent(Mower mower, int dayOfTheYear) { return this; }

    // used for automatic transitions
    public MowerState enterState(Mower mower) { return this; }
}
