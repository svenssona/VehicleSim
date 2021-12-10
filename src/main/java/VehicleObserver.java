/**
 * Interface that marks implementors as observers of the vehicle.
 */
public interface VehicleObserver {
    /**
     * Updates the observer if the publisher sends a signal.
     */
    void vehicleUpdate();
}
