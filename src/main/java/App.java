import javax.swing.Timer;

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
        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc, drawPanel);
        DashboardPanel dashboard = new DashboardPanel();
        VehicleManger vehicleManger = new VehicleManger(vehicleFactory, model);
        //  Adds a buffered image for each car to the panel and subscribes the view as listener to our model.
        frame.add(dashboard);
        frame.add(vehicleManger);

        model.addListener(cc);
        model.addListener(dashboard);
        model.addListener(drawPanel);

        int delay = 10;
        Timer timer = new Timer(delay, cc);
        timer.addActionListener(frame);
        timer.addActionListener(dashboard);

        // Start the timer
        timer.start();
    }
}
