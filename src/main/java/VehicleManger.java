import javax.swing.*;
import java.awt.*;

/**
 * This is a view that lets us add and remove vehicles through buttons in our GUI.
 */
public class VehicleManger extends JPanel implements VehicleListener {

    private final VehicleFactory vehicleFactory;
    private List<Vehicle> currentVehicles;
    private Model model;
    private JSpinner removeSpinner;

    public VehicleManger(VehicleFactory vehicleFactory, Model model)  {
        this.vehicleFactory = vehicleFactory;
        this.model = model;
        // A spinner with all available models that we can create in the vehicle factory.
        SpinnerModel availableVehicles = new SpinnerListModel(vehicleFactory.getAvailableModels());
        // availableVehicles.addChangeListener();
        JSpinner addSpinner = new JSpinner(availableVehicles);
        // A spinner with all the current Vehicles initialized.
        SpinnerModel currentSpinner = new SpinnerListModel(model.getVehicles());
        // currentSpinner.addChangeListener();
        removeSpinner = new JSpinner(currentSpinner);

        this.setLayout(new GridBagLayout());
        // This is the visual representation of adding the vehicles.
        JButton addButton = new JButton("Add vehicle");
        this.add(addButton);
        JLabel addLabel = new JLabel("Choose vehicle to add");
        this.add(addLabel);
        this.add(addSpinner);
        // This is the visual representation for removing the vehicles.
        JButton removeButton = new JButton("Remove vehicle");
        this.add(removeButton);
        JLabel removeLabel = new JLabel("Choose vehicle to remove");
        this.add(removeLabel);
        this.add(removeSpinner);

        // This actionListener is for the add button only
        addButton.addActionListener(e -> addVehicle("Saab95"));
        // This actionListener is for the remove button only
        removeButton.addActionListener(e -> removeVehicle("TODO"));
    }

    public void addVehicle(String modelName) {
        Vehicle newVehicle = vehicleFactory.create(modelName);
        model.addVehicle(newVehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        model.removeVehicle(vehicle);
    }

    @Override
    public void updateVehicles(List<Vehicle> vehicles) {
        SpinnerModel currentSpinner = new SpinnerListModel(model.getVehicles());
        removeSpinner = new JSpinner(currentSpinner);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
