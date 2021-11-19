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
    private Bed bed = new Bed(maxAngle, minAngle);
    private Stack<T> loadedCars;

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
     * Adds a car to the car transport.
     * @param cargo
     */
    public void loadCar(T cargo){
        if (this.getBedAngle() == CarTransport.getMinAngle() && loadedCars.size() <= CarTransport.getCapacity()) {
            loadedCars.push(cargo);
        }
    }

    /**
     * Unloads a car from the car transport.
     * @return The unloaded car.
     */
    public T unloadCar() throws IllegalStateException {
        if (this.getBedAngle() == CarTransport.getMinAngle()) {
            return loadedCars.pop();
        }
        throw new IllegalStateException();
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

    public double getBedAngle() {
        return this.bed.getBedAngle();
    }
}
