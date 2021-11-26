import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Object class for constructing a Volvo240 with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
public class Volvo240 extends Car implements Loadable{

    private final static double trimFactor = 1.25;

    /**
     * Constructs a 100 horse-power, four-doors, black Volvo240 with start position in (0, 0).
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240", new Point2D.Double(0,0)),
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

}
