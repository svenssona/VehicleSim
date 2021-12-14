import javax.swing.*;
import java.awt.*;

/**
 * This is a view that lets us add and remove vehicles through buttons in our GUI.
 */
public class VehicleManger extends JPanel {

    private final VehicleFactory vehicleFactory;
    private final Model model;
    private Vehicle selectedCar;
    JSpinner removeSpinner;
    SpinnerListModel currentSpinner;

    public VehicleManger(VehicleFactory vehicleFactory, Model model)  {
        this.vehicleFactory = vehicleFactory;
        this.model = model;
        this.setLayout(new GridBagLayout());
        // A spinner with all available models that we can create in the vehicle factory.
        SpinnerModel availableVehicles = new SpinnerListModel(vehicleFactory.getAvailableModels());
        JSpinner addSpinner = new JSpinner(availableVehicles);
        // A spinner with all the current Vehicles initialized.
        currentSpinner = new SpinnerListModel(model.getVehicles());
        removeSpinner = new JSpinner(currentSpinner);
        removeSpinner.addChangeListener(e -> selectedCar = (Vehicle) ((JSpinner) e.getSource()).getValue());
        // This is the visual representation of adding the vehicles.
        JButton addButton = new JButton("Add vehicle ");
        this.add(addButton);
        this.add(addSpinner);
        // This is the visual representation for removing the vehicles.
        JButton removeButton = new JButton("Remove vehicle ");
        this.add(removeButton);
        this.add(removeSpinner);

        // This actionListener is for the add button only
        addButton.addActionListener(e -> addVehicle((String) addSpinner.getValue()));
        // This actionListener is for the remove button only
        removeButton.addActionListener(e -> removeVehicle(selectedCar));
    }

    public void addVehicle(String modelName) {
        Vehicle newVehicle = vehicleFactory.create(modelName);
        model.addVehicle(newVehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        model.removeVehicle(vehicle);
        currentSpinner.setList(model.getVehicles());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
