import java.awt.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * View that shows what vehicle is driving and shows the speed of the vehicle.
 */
public class DashboardPanel extends JPanel implements VehicleObserver{

    private final Map<Vehicle, JLabel> vehicleLables = new HashMap<>();

    public DashboardPanel() {
        this.setLayout(new GridLayout(3, 1));
    }

    public void addVehicles(Vehicle vehicle) {
        String vehicleName = vehicle.getModelName();
        double speed = vehicle.getCurrentSpeed();
        JLabel newLabel = new JLabel(vehicleName + " : " + speed);
        vehicleLables.put(vehicle, newLabel);
        this.add(newLabel);
    }

    @Override
    public void vehicleUpdate() {
        for (Vehicle vehicle : vehicleLables.keySet()) {
            String vehicleName = vehicle.getModelName();
            double speed = vehicle.getCurrentSpeed();
            vehicleLables.get(vehicle).setText(vehicleName + " : " + speed);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleUpdate();
    }
}
