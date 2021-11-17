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
    private Bed bed = new Bed(70);

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

    /**
     * Raises the trucks loading bed a desired amount caps out at 70 degrees.
     * @param deltaAngle
     */
    public void raiseBed(double deltaAngle) {
        if (this.getCurrentSpeed() == 0) {
            this.bed.raiseBed(deltaAngle);
        }
    }

    /**
     * Lowers the trucks loading bed a desired amount.
     * @param deltaAngle
     */
    public void lowerBed(double deltaAngle) {
        this.bed.lowerBed(deltaAngle);
    }

    /**
     * Increases the speed of the truck given that our loading bed is safely lowered to 0 degrees.
     * @param amount Factor increasing the speed, must be in the interval [0,1].
     */
    @Override
    public void gas(double amount) {
        if (this.bed.getBedAngle() == 0) {
            super.gas(amount);
        }
    }

    public double getBedAngle() {
        return this.bed.getBedAngle();
    }
}
