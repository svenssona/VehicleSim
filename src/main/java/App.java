import javax.swing.Timer;

public class App {

    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();
        Model model = new Model();
        CarController cc = new CarController();

        model.addVehicle(vehicleFactory.create("Volvo240"));
        model.addVehicle(vehicleFactory.create("Saab95"));
        model.addVehicle(vehicleFactory.create("Scania"));
        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);
        DashboardPanel dashboard = new DashboardPanel();
        VehicleManger vehicleManger = new VehicleManger(vehicleFactory, cc, frame, dashboard);
        //  Adds a buffered image for each car to the panel and subscribes the view as listener to our model.
        frame.add(dashboard);
        frame.add(vehicleManger);

        int delay = 10;
        Timer timer = new Timer(delay, cc);
        timer.addActionListner(frame);

        // Start the timer
        timer.start();
    }
}
