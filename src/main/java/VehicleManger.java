import javax.swing.*;
import java.awt.*;

/**
 * This is a view that lets us add and remove vehicles through buttons in our GUI.
 */
public class VehicleManger extends JPanel {
    private final CarController carC;
    private final VehicleFactory vehicleFactory;

    public VehicleManger(VehicleFactory vehicleFactory, CarController carC) {
        this.carC = carC;
        this.vehicleFactory = vehicleFactory;
        // A spinner with all available models that we can create in the vehicle factory.
        SpinnerModel availableVehicles = new SpinnerListModel(vehicleFactory.getAvailableModels());
        // availableVehicles.addChangeListener();
        JSpinner addSpinner = new JSpinner(availableVehicles);
        // A spinner with all the current Vehicles initialized.
        SpinnerModel currentSpinner = new SpinnerListModel(carC.getCars());
        // currentSpinner.addChangeListener();
        JSpinner removeSpinner = new JSpinner(currentSpinner);

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
        removeButton.addActionListener(e -> removeVehicles());
    }

    public void addVehicle(String modelName) {
        carC.getCars().add(vehicleFactory.create(modelName));
    }

    public void removeVehicles() {
        carC.getCars().remove(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
