import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Object class for constructing a Saab95 with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public final class Saab95 extends Vehicle implements LoadableCar, HasTurbo {

    private boolean turboOn;
    private boolean isLoaded;

    /**
     * Constructs a 125 horse-power, two-door, red SAAB95 with start position in (0, 0).
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95", new Point2D.Double(100,0));
        this.turboOn = false;
    }

    /**
     * Sets the turbo on or off.
     * @param turboOn This is a boolean, either you have turbo on or you do not.
     */
    public void setTurbo(boolean turboOn) {
        this.turboOn = turboOn;
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor(){
        int wheelLock = isLoaded? 0 : 1;
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo * wheelLock;
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
