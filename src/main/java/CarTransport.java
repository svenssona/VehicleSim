import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Object class for constructing a CarTransport super with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public class CarTransport<T extends LoadableCar> extends Vehicle implements HasBed {

    private final static double trimFactor = 1.5;
    private final static double maxAngle = 90;
    private final static double minAngle = -20;
    private final static int capacity = 7;
    private final Bed<T> bed; 

    /**
     * For example you can construct a 300 horse-power, two-door, blue CarTransport with start position in (0, 0).
     * @param nrDoors Number of doors that your car transport should have.
     * @param enginePower  Enter the specific engine power of your car transport.
     * @param color Color of the car transport.
     * @param modelName The specific model name for the car transport.
     * @param point Sets the initial starting point of your car transport.
     */
    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, Point2D point) {
        super(nrDoors, enginePower, color, modelName, point);
        this.bed = new Bed<>(maxAngle, capacity, minAngle);
        this.bed.raiseBed(maxAngle);
    }

    //  Methods for handling the (un)loading of the cars from the car transport.
    //TODO add exception for loadCargo aswell?
    /**
     * Adds a car to the car transport bed.
     *
     * @param cargo Takes in the car you want to load.
     */
    public void loadCargo(T cargo) {
        // Checks that we are in position to load.
        if (this.getPosition().distance(cargo.getPosition()) <= 2) {
            this.bed.loadCargo(cargo, true);
            cargo.stopEngine();
        }
    }

    /**
     * Unloads a car from the car transport.
     * @return The unloaded car.
     * @throws IllegalStateException If the bed is not at the lower position or no cars loaded then we can't unload.
     */
    public T unloadCargo() throws IllegalStateException {
        return this.bed.unloadCargo(getDirection(), true);
    }

    @Override
    public void move() {
        super.move();
        for (T cargo : this.bed.getCargo()) {
            cargo.setPosition(this.getPosition());
        }
    }

    // Getters
    /** Returns the current bed angle for our car transport.
     * @return Returns the current bed angle for our car transport.
     */
    public double getBedAngle() {
        return this.bed.getBedAngle();
    }
    /** Returns the min angle for the bed in car transport.
     * @return Min angle
     */
    public static double getMinAngle() {
        return minAngle;
    }
    /**  Returns the max angle for the bed in car transport.
     * @return Max angle
     */
    public static double getMaxAngle() { return maxAngle; }
    /** Returns the capacity of the car transport.
     * @return Capacity of the car transport.
     */
    public static int getCapacity() { return capacity; }
    /**
     * Returns the car transport.
     * @return Returns the car transport.
     */
    public Bed<T> getBed() {
        return bed;
    }

    /**
     * @return the speed factor that determines how fast the speed increases/decreases.
     */
    @Override
    double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    // The car transport can only have in two positions (down or up).
    /**
     * Raises the trucks loading bed from the min angle -> max angle.
     */
    public void raiseBed(double deltaAngle) {
        if (this.getCurrentSpeed() == 0) {
            this.bed.raiseBed(CarTransport.maxAngle - CarTransport.minAngle);
        }
    }

    /**
     * Lowers the trucks loading bed from the max angle -> min angle.
     */
    public void lowerBed(double deltaAngle) {
        if (this.getCurrentSpeed() == 0) {
            this.bed.lowerBed(CarTransport.maxAngle - CarTransport.minAngle);
        }
    }

    /**
     * Increases the speed of the truck given that our loading bed is safely lowered to 0 degrees.
     *
     * @param amount Factor increasing the speed, must be in the interval [0,1].
     */
    @Override
    public void gas(double amount) {
        System.out.println(this.bed.getBedAngle());
        if (this.bed.getBedAngle() == CarTransport.maxAngle) {
            super.gas(amount);
        }
    }
}
