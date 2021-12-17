import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Object class for constructing a Volvo240 with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public final class Volvo240 extends Vehicle implements LoadableCar {

    private final static double trimFactor = 1.25;
    private boolean isLoaded;

    /**
     * Constructs a 100 horse-power, four-doors, black Volvo240 with start position in (0, 0).
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240", new Point2D.Double(0, 0));
        isLoaded = false;
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor() {
        int wheelLock = isLoaded ? 0 : 1;
        return this.getEnginePower() * 0.01 * trimFactor * wheelLock;
    }

    /**
     * Returns whether the object is loaded.
     * @return Returns whether the object is loaded.
     */
    @Override
    public boolean getLoadState() {
        return isLoaded;
    }

    /**
     * Sets if the object is loaded or not.
     * @param loadState Sets if the object to a loaded or offloaded state (true/false).
     */
    @Override
    public void setLoadState(boolean loadState) {
        this.isLoaded = loadState;
    }
}
