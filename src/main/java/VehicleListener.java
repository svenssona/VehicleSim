import java.util.List;

/**
 * Implementor of this Interface makes them able to observe our model.
 */
interface VehicleListener {
    void updateVehicles(List<Vehicle> vehicles);
}
