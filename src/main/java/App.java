import javax.swing.*;

public class App {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania<>());
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        //  Adds a buffered image for each car to the panel.
        for (Vehicle car : cc.cars) {
            cc.frame.drawPanel.addCar(car);
        }

        int delay = 50;
        Timer timer = new Timer(delay, cc);

        // Start the timer
        timer.start();
    }
}
