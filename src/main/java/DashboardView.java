import java.util.Map;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

/** 
 * View that shows what vehicle is driving and shows the speed of the vehicle.
 */
public class DashboardView extends JFrame implements VehicleObserver{

    private final Map<Vehicle, JLabel> vehicleLables = new HashMap<>();
    private final JPanel panel = new JPanel();

    public void drawDisplay() {
        int nelems = vehicleLables.size();
        panel.setLayout(new GridLayout(nelems, 1));
        for (JLabel label : vehicleLables.values()) {
            panel.add(label);
        }
        this.add(panel);
    }

    public void addVehicles(Vehicle vehicle) {
        String vehicleName = vehicle.getModelName();
        double speed = vehicle.getCurrentSpeed();
        vehicleLables.put(vehicle, new JLabel(vehicleName + " : " + speed));
    }

    @Override
    public void vehicleUpdate() {
        for (Vehicle vehicle : vehicleLables.getKeys()) {
            String vehicleName = vehicle.getModelName();
            double speed = vehicle.getCurrentSpeed();
            vehicleLables.get(vehicle).setText(vehicleName + " : " + speed);
        }
        repaint();
    }
}
