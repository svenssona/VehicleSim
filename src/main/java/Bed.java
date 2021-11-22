import java.util.Stack;

/**
 * Object class for constructing a loading bed with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
class Bed <T extends Loadable> {

    private double bedAngle = 0;
    private final double maxAngle;
    private final double minAngle;
    private final Stack<T> loadedObjects;
    private final int capacity;

    /**
     * Creates a bed with specified max angle in the interval [0, maxAngle].
     * @param maxAngle
     */
    public Bed(double maxAngle, int capacity) {
        this.maxAngle = maxAngle;
        this.capacity = capacity;
        minAngle = 0;
        loadedObjects = new Stack<>();
    }

    public Bed(double maxAngle, int capacity, double minAngle ) {
        this.maxAngle = maxAngle;
        this.capacity = capacity;
        this.minAngle = minAngle;
        loadedObjects = new Stack<>();
    }

    /**
     * Returns the bed angle.
     */
    public double getBedAngle() {
        return bedAngle;
    }

    /**
     *
     * @return Returns the bed max angle.
     */
    public double getMaxAngle() {
        return this.maxAngle;
    }

    /**
     *
     * @return Returns the beds min angle.
     */
    public double getMinAngle() {
        return this.minAngle;
    }

    /**
     *
     * @return Returns the capacity of the bed.
     */
    public int getCapacity() {
        return capacity;
    }

    /** 
     *
     * @return Returns the loaded objects.
     */
    public Stack<T> getCargo() {
        return this.loadedObjects;
    }

    /**
     * Raises the trucks loading bed a desired amount caps out at maxAngle degrees.
     * @param deltaAngle
     */
    public void raiseBed(double deltaAngle) {
        double newAngle = this.bedAngle + deltaAngle;
        // Statement makes sure we can't raise past our max angle.
        this.bedAngle = newAngle < this.maxAngle ? newAngle : this.maxAngle;
    }

    /**
     * Lowers the trucks loading bed a desired amount.
     * @param deltaAngle
     */
    public void lowerBed(double deltaAngle) {
        double newAngle = this.bedAngle - deltaAngle;
        // Statement makes sure we can't lower past our min angle.
        this.bedAngle = newAngle > this.minAngle ? newAngle : this.minAngle;
    }
    // TODO Implement position and direction for all beds.
    /**
     * Loads a loadable object to our bed stack.
     * @param cargo A loadable object
     */
    public void loadCargo(T cargo) {
        // Checks that the ramp is lowered and that the loading deck is not full.
        if (this.getBedAngle() == getMinAngle() && loadedObjects.size() <= getCapacity()) {
            loadedObjects.push(cargo);
        }
    }

    /**
     * Unloads the cargo from the loading bed a given direction from the carrier.
     * @param carrierDirection {0 = North, 1 = West, 2 = South, 3 = East}
     * @return Returns the unloaded cargo.
     * @throws IllegalStateException If the bed is not at the lower position then we can't unload.
     */
    public T unloadCargo(int carrierDirection) throws IllegalStateException {
        if (this.getBedAngle() == getMinAngle()) {
            double[] newPosition = loadedObjects.peek().getPosition();
            // Handles placing cargo one unit behind the carrier.
            switch (carrierDirection) {
                case 0: newPosition[1] += -1; break;
                case 1: newPosition[0] += 1; break;
                case 2: newPosition[1] += 1; break;
                case 3: newPosition[0] += -1; break;
            }
            // Sets the top object of the stack to the new position for unloading.
            loadedObjects.peek().setPosition(newPosition);
            return loadedObjects.pop();
        } else {
            throw new IllegalStateException();
        }
    }
}
