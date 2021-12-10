import javax.swing.*;

public class App {
    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania<>());
        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);
        //  Adds a buffered image for each car to the panel and subscribes the view as listener to our model.
        for (Vehicle car : cc.cars) {
            frame.drawPanel.addCar(car);
            car.addObserver(frame);
        }

        int delay = 10;
        Timer timer = new Timer(delay, cc);

        // Start the timer
        timer.start();
    }
}
