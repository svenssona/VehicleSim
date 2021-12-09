import javax.swing.*;
import java.util.ArrayList;

public class App {
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

        // Start the timer

        cc.startTimer();
    }
}
