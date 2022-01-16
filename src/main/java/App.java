import javax.swing.Timer;

/**
 * Car Simulator Application
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public class App {

    public static void main(String[] args) {
        final int X = 800;
        final int Y = 800;
        VehicleFactory vehicleFactory = new VehicleFactory();
        Model model = new Model();
        CarController cc = new CarController();
        DrawPanel drawPanel = new DrawPanel(X, Y-240);

        model.addVehicle(vehicleFactory.create("Volvo240"));
        model.addVehicle(vehicleFactory.create("Saab95"));
        model.addVehicle(vehicleFactory.create("Scania"));
        // Start a new view and send a reference of the CarController and drawPanel.
        CarView frame = new CarView("CarSim 2.0", cc, drawPanel);
        DashboardPanel dashboard = new DashboardPanel();
        VehicleManger vehicleManger = new VehicleManger(vehicleFactory, model);

        frame.add(dashboard);
        frame.add(vehicleManger);

        model.addListener(cc);
        model.addListener(dashboard);
        model.addListener(drawPanel);

        int delay = 11;
        Timer timer = new Timer(delay, cc);
        timer.addActionListener(frame);
        timer.addActionListener(dashboard);

        // Start the timer
        timer.start();
    }
}
