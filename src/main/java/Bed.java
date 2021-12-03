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
    public void raiseBed(double deltaAngle) throws IllegalArgumentException{
        if (deltaAngle > 0) {
            double newAngle = this.bedAngle + deltaAngle;
            // Statement makes sure we can't raise past our max angle.
            this.bedAngle = newAngle < this.maxAngle ? newAngle : this.maxAngle;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Lowers the trucks loading bed a desired amount.
     * @param deltaAngle
     */
    public void lowerBed(double deltaAngle) throws IllegalArgumentException{
        if (deltaAngle > 0) {
            double newAngle = this.bedAngle - deltaAngle;
            // Statement makes sure we can't lower past our min angle.
            this.bedAngle = newAngle > this.minAngle ? newAngle : this.minAngle;
        } else {
            throw new IllegalArgumentException();
        }
    }
    // TODO Implement position and direction for all beds.
    /**
     * Loads a loadable object to the bed queue.
     * @param cargo A loadable object.
     * @param loadLast true if we should load the cargo at the back of the queue.
     * @throws IllegalStateException If the bed is not at the lower position or if the bed is full.
     */
    public void loadCargo(T cargo, boolean loadLast) throws IllegalStateException {
        // Checks that the ramp is lowered and that the loading deck is not full.
        if (this.getBedAngle() == getMinAngle() && loadedObjects.size() <= getCapacity()) {
            cargo.setLoadState(true);
            if (loadLast) {
                loadedObjects.addLast(cargo);
            } else {
                loadedObjects.addFirst(cargo);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Unloads the object in to the cargo from the loading bed at a given direction from the carrier.
     * @param carrierDirection Direction the front of the bed is facing.
     * @param unloadLast Whether to unload the last element or the first.
     * @return Returns the unloaded cargo.
     * @throws IllegalStateException If the bed is not at the lower position then we can't unload.
     */
    public T unloadCargo(Direction carrierDirection, boolean unloadLast) throws IllegalStateException {
        if (this.getBedAngle() == getMinAngle()) {
            Point2D unloadPosition = getUnloadPosition(carrierDirection, unloadLast);
            // Unloads the object of the queue to the new position for unloading.
            if (unloadLast) {
                assert loadedObjects.peekLast() != null;
                loadedObjects.peekLast().setLoadState(false);
                loadedObjects.peekLast().setPosition(unloadPosition);
                return loadedObjects.removeLast();
            } else {
                assert loadedObjects.peekFirst() != null;
                loadedObjects.peekFirst().setLoadState(false);
                loadedObjects.peekFirst().setPosition(unloadPosition);
                return loadedObjects.removeFirst();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Gets the unload position for the cargo on the bed.
     * @param carrierDirection Direction the front of the bed is facing.
     * @param unloadLast Whether to unload the last element or the first.
     * @return Returns the position to unload.
     */
    private Point2D getUnloadPosition(Direction carrierDirection, boolean unloadLast) {
        // Initializes unload position to current bed position if there exists an object to unload.
        assert loadedObjects.peekFirst() != null;
        Point2D unloadPosition = loadedObjects.peekFirst().getPosition();
        // Unloads the cargo 1 unit either behind the bed if true or in front of the bed if false.
        int unloadDirection = unloadLast ? 1 : -1;
        switch (carrierDirection) {
            case NORTH: translate(unloadPosition, 0, -unloadDirection); break;
            case WEST: translate(unloadPosition, unloadDirection, 0); break;
            case SOUTH: translate(unloadPosition, 0, unloadDirection); break;
            case EAST: translate(unloadPosition, -unloadDirection, 0); break;
        }
        return unloadPosition;
    }

    // Moves the specified point by dx and dy in x and y direction respectivly.
    private void translate(Point2D position, double dx, double dy) {
        position.setLocation(position.getX() + dx, position.getY() + dy);
    }
}
