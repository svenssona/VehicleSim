import java.awt.Color;

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
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
        position = new double[] {0,0};
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
