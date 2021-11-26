import java.awt.geom.Point2D;
import java.util.LinkedList;

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
    private final LinkedList<T> loadedObjects;
    private final int capacity;

    /**
     * Creates a bed with specified max angle in the interval [0, maxAngle].
     * @param maxAngle Max angle for the specific bed.
     * @param capacity Max capacity for the specific bed.
     */
    public Bed(double maxAngle, int capacity) {
        this.maxAngle = maxAngle;
        this.capacity = capacity;
        minAngle = 0;
        loadedObjects = new LinkedList<>();
    }

    /**
     * Creates a bed with specified max angle in the interval [minAngle, maxAngle].
     * @param maxAngle Max angle for the specific bed.
     * @param capacity Max capacity for the specific bed.
     * @param minAngle Min angle for the specific bed.
     */
    public Bed(double maxAngle, int capacity, double minAngle ) {
        this.maxAngle = maxAngle;
        this.capacity = capacity;
        this.minAngle = minAngle;
        loadedObjects = new LinkedList<>();
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
    public LinkedList<T> getCargo() {
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
     * Loads a loadable object to the bed queue.
     * @param cargo A loadable object.
     * @param loadLast true if we should load the cargo at the back of the queue.
     */
    public void loadCargo(T cargo, boolean loadLast) {
        // Checks that the ramp is lowered and that the loading deck is not full.
        if (this.getBedAngle() == getMinAngle() && loadedObjects.size() <= getCapacity()) {
            if (loadLast) {
                loadedObjects.addLast(cargo);
            } else {
                loadedObjects.addFirst(cargo);
            }
        }
    }

    /**
     * Unloads the object in to the cargo from the loading bed a given direction from the carrier.
     * @param carrierDirection Direction the front of the bed is facing.
     * @param unloadLast Wheter to unload the last element.
     * @return Returns the unloaded cargo.
     * @throws IllegalStateException If the bed is not at the lower position then we can't unload.
     */
    public T unloadCargo(Direction carrierDirection, boolean unloadLast) throws IllegalStateException {
        if (this.getBedAngle() == getMinAngle()) {
            assert loadedObjects.peekFirst() != null;
            Point2D newPosition = loadedObjects.peekFirst().getPosition();
            // Handles placing cargo one unit behind the carrier.
            switch (carrierDirection) {
                case NORTH: translate(newPosition, 0, -1); break;
                case WEST: translate(newPosition, 1, 0); break;
                case SOUTH: translate(newPosition, 0, 1); break;
                case EAST: translate(newPosition, -1, 0); break;
            }
            // Sets the object of the queue to the new position for unloading.
            if (unloadLast) {
                loadedObjects.peekLast().setPosition(newPosition);
                return loadedObjects.removeLast();
            } else {
                assert loadedObjects.peekFirst() != null;
                loadedObjects.peekFirst().setPosition(newPosition);
                return loadedObjects.removeFirst();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    // Moves the specified point by dx and dy in x and y direction respectivly.
    private void translate(Point2D position, double dx, double dy) {
        position.setLocation(position.getX() + dx, position.getY() + dy);
    }
}
