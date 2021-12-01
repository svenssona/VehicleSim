import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania<>());
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        //  Adds a buffered image for each car to the panel.
        for (Car car : cc.cars) {
            cc.frame.drawPanel.addCar(car);
        }

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                // Specification of end of the frame this is where we want the car to turn around with respect to the
                // current car speed.
                double minX = 0;
                double maxX = 700;
                double minY = 0;
                double maxY = 500;
                // Below we have the current position of the car.
                double origX = car.getPosition().getX();
                double origY = car.getPosition().getY();
                if (origX < minX ) {
                    turnAround(car);
                    car.setPosition(new Point((int) minX, (int) origY));
                } else if (origX > maxX) {
                    turnAround(car);
                    car.setPosition(new Point((int) maxX, (int) origY));
                } else if (origY < minY) {
                    turnAround(car);
                    car.setPosition(new Point((int) origX, (int) minY));
                } else if (origY > maxY) {
                    turnAround(car);
                    car.setPosition(new Point((int) origX, (int) maxY));
                }
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(x, y, car);
                }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    private void turnAround(Car car) {
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once.
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
}
