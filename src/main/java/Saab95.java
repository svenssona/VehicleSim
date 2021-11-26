import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Object class for constructing a Saab95 with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
public class Saab95 extends Car implements Loadable{

    private boolean turboOn;

    /**
     * Constructs a 125 horse-power, two-door, red SAAB95 with start position in (0, 0).
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95", new Point2D.Double(0,0));
        this.turboOn = false;
    }

    public void setTurbo(boolean TurboOn) {
        this.turboOn = TurboOn;
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
}
