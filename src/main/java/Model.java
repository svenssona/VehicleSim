import java.util.List;
import java.util.ArrayList;

/**
 * Model that holds the global list of current vehicles and updates its observers when something happens.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public class Model {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<VehicleListener> listeners = new ArrayList<>();

    /**
     * Returns a defensive copy of the list in Model.
     * @return Returns a defensive copy of the list in Model.
     */
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    /**
     * Adds an observer to our list of listeners.
     * @param listener The new VehicleListener that wants to observe the model.
     */
    public void addListener(VehicleListener listener) {
        this.listeners.add(listener);
        listener.updateVehicles(this.vehicles);
    }

    /**
     * This is adds to the list of all the current vehicles in our model.
     * @param vehicle The new Vehicle that you want to add to this list.
     */
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        this.notifyListeners();
    }

    /**
     * Removes a vehicle from the list of all current vehicles in our model.
     * @param vehicle The specific vehicle that you want to remove.
     * @throws IllegalArgumentException If no such vehicle in the list.
     */
    public void removeVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (this.vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            this.notifyListeners();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Notifies all of our observers and calls for their update method.
     */
    private void notifyListeners() {
        for (VehicleListener listener : listeners) {
            listener.updateVehicles(this.vehicles);
        }
    }
}
