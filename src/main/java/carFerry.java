import java.awt.*;

public class carFerry <T extends Loadable> extends Car {

    private final static double maxAngle = 85;
    private final static double minAngle = -25;
    private final static int capacity = 10;

    /**
     * Constructs the legendary Car-ferry NightCruiser420 with 1000 hp. It can take up to 10 cars.
     */
    public carFerry() {
        nrDoors = 1;
        color = Color.black;
        enginePower = 1000;
        modelName = "NightCruiser420";
        stopEngine();
        position = new double[] {0, 0};
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    @Override
    double speedFactor() {
        return enginePower * 0.1;
    }
}
