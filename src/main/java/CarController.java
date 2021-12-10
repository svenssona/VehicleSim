import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements ActionListener {

    ArrayList<Vehicle> cars = new ArrayList<>(); // A list of cars, modify if needed

    /**
     * Each time the CarController gets a signal from CarView it performs the action.
     * @param e Action event from someone pressing a button on our controller.
     */
    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : cars) {
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
        }
    }

    private void turnAround(Vehicle car) {
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once.
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    void setTurbo(boolean state) {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                Saab95 saab = (Saab95) car;
                saab.setTurbo(state);
            }
        }
    }

    void adjustBed(boolean state) {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                Scania scania = (Scania) car;
                if (state) {
                    scania.raiseBed(200);
                } else {
                    scania.lowerBed(200);
                }
            }
        }
    }

    void startAllCars() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}
