import java.awt.Color;

/**
 * Object class for constructing a Scania super with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
public class Scania extends Car{

    private final static double trimFactor = 1.5;
    private double bedAngle = 0;

    /**
     * Constructs a 300 horse-power, two-door, blue Scania with start position in (0, 0).
     */
    public Scania(){
        nrDoors = 2;
        color = Color.blue;
        enginePower = 300;
        modelName = "Scania-super";
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

    public void raiseBed(double deltaAngle) {
        if (this.getCurrentSpeed() == 0) {
            newAngle = bedAngle + deltaAngle;
            bedAngle = newAngle < 70 ? newAngle : 70;
        }
    }

    public void lowerBed(double deltaAngle) {
        newAngle = bedAngle - deltaAngle;
        bedAngle = newAngle > 0 ? newAngle : 0;
    }

    @Override
    public void gas(double amount) {
        if (this.bedAngle == 0) {
            super.gas(amount)
        }
    }
}
