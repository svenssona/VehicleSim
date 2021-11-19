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
    private final Bed bed = new Bed(maxAngle, minAngle);
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


    /**
     * Adds a loadable object to the car transport bed.
     * @param cargo
     */
    public void loadCargo(T cargo) {
        // Checks that the ramp is lowered, that the loading deck is not full and that we are in position to load.
        if (this.getBedAngle() == CarTransport.getMinAngle()
                && loadedCars.size() <= CarTransport.getCapacity()
                && Car.distance(this.position, cargo.getPosition()) <= 2) {
            loadedCars.push(cargo);
        }
    }

    /**
     * Unloads a car from the car transport.
     * @return The unloaded car.
     */
    public T unloadCargo() throws IllegalStateException {
        if (this.getBedAngle() == CarTransport.getMinAngle()) {
            // Handles placing the cargo 1 unit behind the Cartransport.
            double[] newPosition = this.position.clone();
            switch (this.direction) {
                case 0: newPosition[1] += -1; break;
                case 1: newPosition[0] += 1; break;
                case 2: newPosition[1] += 1; break;
                case 3: newPosition[0] += -1; break;
            }
            loadedCars.peek().setPosition(newPosition);
            return loadedCars.pop();
        } else {
            throw new IllegalStateException();
        }
    }

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

    /**
     * Raises the trucks loading bed a desired amount caps out at 70 degrees.
     */
    public void raiseBed() {
        if (this.getCurrentSpeed() == 0) {
            this.bed.raiseBed(CarTransport.maxAngle - CarTransport.minAngle);
        }
    }

    /**
     * Lowers the trucks loading bed a desired amount.
     */
    public void lowerBed() {
        this.bed.lowerBed(CarTransport.maxAngle - CarTransport.minAngle);
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
