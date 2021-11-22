import java.awt.Color;
import java.util.Stack;

/**
 * Object class for constructing a CarTransport super with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
public class CarTransport<T extends Loadable> extends Car{

    private final static double trimFactor = 1.5;
    private final static double maxAngle = 90;
    private final static double minAngle = -20;
    private final static int capacity = 7;
    private final Bed<T> bed = new Bed(maxAngle, capacity, minAngle);
    private final Stack<T> loadedCars;

    /**
     * Constructs a 300 horse-power, two-door, blue CarTransport with start position in (0, 0).
     */
    public CarTransport(){
        nrDoors = 2;
        color = Color.blue;
        enginePower = 300;
        modelName = "CarTransport";
        stopEngine();
        position = new double[] {0,0};
        loadedCars = new Stack<>();
    }

    //  Methods for handling the (un)loading of the cars from the car transport.
    /**
     * Adds a car to the car transport bed.
     * @param cargo
     */
    public void loadCargo(T cargo) {
        // Checks that we are in position to load.
        if (Car.distance(this.position, cargo.getPosition()) <= 2) {
            this.bed.loadCargo(cargo);
        }
    }

    /**
     * Unloads a car from the car transport.
     * @return The unloaded car.
     */
    public T unloadCargo() throws IllegalStateException { return this.bed.unloadCargo(getDirection()); }

    @Override
    public void move() {
        super.move();
        for (T cargo : this.loadedCars) {
            cargo.setPosition(this.position);
        }
    }

    // Getters
    /**
     *
     * @return Returns the bed angle for our car transport.
     */
    public double getBedAngle() {
        return this.bed.getBedAngle();
    }
    /**
     * @return Min angle
     */
    public static double getMinAngle() {
        return minAngle;
    }

    /**
     * @return Max angle
     */
    public static double getMaxAngle() {
        return maxAngle;
    }

    /**
     * @return Capacity of the car transport.
     */
    public static int getCapacity() {
        return capacity;
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    // The car transport can only have in two positions (down or up).
    /**
     * Raises the trucks loading bed from the min angle -> max angle.
     */
    public void raiseBed() {
        if (this.getCurrentSpeed() == 0) {
            this.bed.raiseBed(CarTransport.maxAngle - CarTransport.minAngle);
        }
    }

    /**
     * Lowers the trucks loading bed from the max angle -> min angle.
     */
    public void lowerBed() {
        if (this.getCurrentSpeed() == 0) {
            this.bed.lowerBed(CarTransport.maxAngle - CarTransport.minAngle);
        }
    }

    /**
     * Increases the speed of the truck given that our loading bed is safely lowered to 0 degrees.
     * @param amount Factor increasing the speed, must be in the interval [0,1].
     */
    @Override
    public void gas(double amount) {
        if (this.bed.getBedAngle() == CarTransport.maxAngle) {
            super.gas(amount);
        }
    }
}
