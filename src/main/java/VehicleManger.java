import java.awt.GridBagLayout;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JButton;
import javax.swing.SpinnerListModel;

/**
 * This is a view that lets us add and remove vehicles through buttons in our GUI.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public class VehicleManger extends JPanel {

    private final VehicleFactory vehicleFactory;
    private final Model model;
    private Vehicle selectedCar;
    private final SpinnerListModel currentSpinner;

    public VehicleManger(VehicleFactory vehicleFactory, Model model)  {
        this.vehicleFactory = vehicleFactory;
        this.model = model;
        this.setLayout(new GridBagLayout());
        selectedCar = model.getVehicles().get(0);
        // A spinner with all available models that we can create in the vehicle factory.
        SpinnerModel availableVehicles = new SpinnerListModel(vehicleFactory.getAvailableModels());
        JSpinner addSpinner = new JSpinner(availableVehicles);
        // A spinner with all the current Vehicles initialized.
        currentSpinner = new SpinnerListModel(model.getVehicles());
        JSpinner removeSpinner = new JSpinner(currentSpinner);
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

    /**
     * Creates a new vehicle according to user input, and adds it to the model + updates the spinner.
     * @param modelName The model name of the vehicle that you want to add.
     */
    public void addVehicle(String modelName) {
        Vehicle newVehicle = vehicleFactory.create(modelName);
        model.addVehicle(newVehicle);
        currentSpinner.setList(model.getVehicles());
    }

    /**
     * Removes a specific vehicle according to user input and updates the spinner.
     * @param vehicle The specific vehicle that you want to remove.
     */
    public void removeVehicle(Vehicle vehicle) {
        model.removeVehicle(vehicle);
        currentSpinner.setList(model.getVehicles());
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself.
     * @param g Graphical component on which we draw.
     */
    @Override
    protected void paintComponent(Graphics g) { super.paintComponent(g); }
}
