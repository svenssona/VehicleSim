import java.util.List;
import java.util.ArrayList;

public class Model {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<VehicleListener> listeners = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addListener(VehicleListener vehicle) {
        this.listeners.add(vehicle);
    }
    
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        this.notifyListeners();
    }

    public void removeVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (this.vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void notifyListeners(){
        for (VehicleListener listener : listeners) {
            listener.updateVehicles(this.vehicles);
        }
    }
}
