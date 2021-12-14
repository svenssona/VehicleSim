import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * View that shows what vehicle is driving and shows the speed of the vehicle.
 */
public class DashboardPanel extends JPanel implements VehicleObserver, VehicleListener {

    private Map<Vehicle, JLabel> vehicleLabels = new HashMap<>();

    public void addVehicles(Vehicle vehicle) {
        String vehicleName = vehicle.getModelName();
        double speed = vehicle.getCurrentSpeed();
        JLabel newLabel = new JLabel(vehicleName + " : " + speed);
        vehicleLabels.put(vehicle, newLabel);
        this.add(newLabel);
        this.setLayout(new GridLayout(vehicleLabels.size(), 1));
        this.setBackground(Color.yellow);
    }

    @Override
    public void vehicleUpdate() {
        for (Vehicle vehicle : vehicleLabels.keySet()) {
            String vehicleName = vehicle.getModelName();
            double speed = vehicle.getCurrentSpeed();
            vehicleLabels.get(vehicle).setText(vehicleName + " : " + speed);
        }
    }

    @Override
    public void vehicleUpdate(List<Vehicle> vehicles) {
        vehicleLabels = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            addVehicles(vehicle);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleUpdate();
    }
}
