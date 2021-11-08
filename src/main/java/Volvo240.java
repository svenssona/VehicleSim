import java.awt.Color;

/**
 * Object class for constructing a Volvo240 with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Constructs a 100 horse-power, four-doors, black Volvo240 with start position in (0, 0).
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        xPos = 0.0;
        yPos = 0.0;
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * @param amount by which the speed increases.
     */
    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    /**
     * @param amount by which the speed decreases.
     */
    void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
