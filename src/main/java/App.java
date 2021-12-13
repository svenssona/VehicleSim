import javax.swing.Timer;

public class App {

    public static void main(String[] args) {
        CarController cc = new CarController();
        VehicleFactory vehicleFactory = new VehicleFactory();
        cc.getCars().add(vehicleFactory.create("Volvo240"));
        cc.getCars().add(vehicleFactory.create("Saab95"));
        cc.getCars().add(vehicleFactory.create("Scania"));
        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);
        DashboardPanel dashboard = new DashboardPanel();
        VehicleManger vehicleManger = new VehicleManger(vehicleFactory, cc);
        //  Adds a buffered image for each car to the panel and subscribes the view as listener to our model.
        for (Vehicle car : cc.getCars()) {
            frame.drawPanel.addCarImage(car);
            car.addObserver(frame);
            dashboard.addVehicles(car);
        }

        frame.add(dashboard);
        frame.add(vehicleManger);

        int delay = 10;
        Timer timer = new Timer(delay, cc);

        // Start the timer
        timer.start();
    }
}
