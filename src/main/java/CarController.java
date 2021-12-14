import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public class CarController implements ActionListener, VehicleListener {

    private List<Vehicle> cars = new ArrayList<>(); // A list of cars, modify if needed

    /**
     * Updates the internal vehicle list.
     */
    public void updateVehicles(List<Vehicle> vehicles) {
        cars = vehicles;
    }

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

    /**
     * Stops the car turns it 180 degrees and then starts engine again.
     * @param car Takes in a Vehicle that it can turn around.
     */
    private void turnAround(Vehicle car) {
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }

    // Calls the gas method for each car once

    /**
     * Increaments the specific Vehicle by a given amount.
     * @param amount Amount of gas that you want to gas with.
     */
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once.

    /**
     * Slows down the specific vehicle.
     * @param amount Given amount that you want to slow down the car with.
     */
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    /**
     * Turns on and off the turbo for vehicles with turbo.
     * @param state true == On; false == Off;
     */
    void setTurbo(boolean state) {
        for (Vehicle car : cars) {
            if (car instanceof HasTurbo) {
                HasTurbo withTurbo = (HasTurbo) car;
                withTurbo.setTurbo(state);
            }
        }
    }

    /**
     * Adjusts the bed for vehicles with a bed.
     * @param state If true then the bed raises if false it lowers it.
     */
    void adjustBed(boolean state) {
        for (Vehicle car : cars) {
            if (car instanceof HasBed) {
                HasBed withBed = (HasBed) car;
                if (state) {
                    withBed.raiseBed(200);
                } else {
                    withBed.lowerBed(200);
                }
            }
        }
    }

    /**
     * Turns on the engine for all vehicles.
     */
    void startAllCars() {
        for (Vehicle car : cars) {
            car.gas(0.5);
        }
    }

    /**
     * Turns off the engine for all vehicles.
     */
    void stopAllCars() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}
