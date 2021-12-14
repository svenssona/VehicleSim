import java.util.List;
import java.util.ArrayList;

public class Model {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<VehicleListener> listeners = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public void addListener(VehicleListener listener) {
        this.listeners.add(listener);
        listener.updateVehicles(this.vehicles);
    }
    
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        this.notifyListeners();
    }

    public void removeVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (this.vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
            this.notifyListeners();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void notifyListeners() {
        for (VehicleListener listener : listeners) {
            listener.updateVehicles(this.vehicles);
        }
    }
}
