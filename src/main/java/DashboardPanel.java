import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * View that shows what vehicle is driving and shows the speed of the vehicle.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public class DashboardPanel extends JPanel implements ActionListener, VehicleListener {

    private Map<Vehicle, JLabel> vehicleLabels = new HashMap<>();

    /**
     * Adds a vehicle to our dashboard panel.
     * @param vehicle The new vehicle that we want to show.
     */
    public void addVehicles(Vehicle vehicle) {
        String vehicleName = vehicle.getModelName();
        double speed = vehicle.getCurrentSpeed();
        JLabel newLabel = new JLabel(vehicleName + " : " + speed);
        vehicleLabels.put(vehicle, newLabel);
        this.add(newLabel);
        this.setLayout(new GridLayout(vehicleLabels.size(), 1));
        this.setBackground(Color.yellow);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("0.00");
        for (Vehicle vehicle : vehicleLabels.keySet()) {
            String vehicleName = vehicle.getModelName();
            double speed = vehicle.getCurrentSpeed();
            vehicleLabels.get(vehicle).setText(vehicleName + " : " + df.format(speed));
        }
    }

    /**
     * Creates a new Map when it gets called from the Model which it is subscribed to.
     * @param vehicles The new list of vehicles that exist in our model.
     */
    @Override
    public void updateVehicles(List<Vehicle> vehicles) {
        vehicleLabels = new HashMap<>();
        this.removeAll();
        for (Vehicle vehicle : vehicles) {
            addVehicles(vehicle);
        }
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself.
     * @param g Graphical component on which we draw.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
