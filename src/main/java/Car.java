import java.awt.Color;
import java.lang.IllegalArgumentException;

/**
 * This is an abstract class defining the basic functions of a car.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 */
abstract class Car implements Moveable {

    /**
     * Parameters defining the cars characterises and initial states.
     */
    int nrDoors; // Number of doors on the car.
    double enginePower; // Engine power of the car.
    double currentSpeed; // The current speed of the car.
    Color color; // Color of the car.
    String modelName; // The car model name.
    double xPos; // X position in 2D space of the car.
    double yPos; // Y position in 2D space of the car.
    int direction; // Direction value of the car, North = 0, West = 1, South = 2, East = 3.

    // Car features.
    int getNrDoors() {
        return nrDoors;
    }
    Color getColor() {
        return color;
    }
    void setColor(Color color) {
        this.color = color;
    }

    // Car engine features.
    void startEngine() {
        currentSpeed = 0.1;
    }
    void stopEngine() {
        currentSpeed = 0;
    }
    double getEnginePower() {
        return enginePower;
    }

    // Car position features.
    /**
     * Moves the car by the value of speed according to the direction attribute.
     */
    public void move(){
	switch (this.direction) {
	    // North
	    case 0: this.yPos += this.getCurrentSpeed();
		    break;
	    // West
	    case 1: this.xPos -= this.getCurrentSpeed();
		    break;
	    // South
	    case 2: this.yPos -= this.getCurrentSpeed();
		    break;
	    // East
	    case 3: this.xPos += this.getCurrentSpeed();
		    break;
	}
    }
    /**
     * Turns the car one cardinal direction going counterclockwise.
     */
    public void turnLeft() {
        this.direction = Math.floorMod(this.direction + 1);
    }
    /**
     * Turns the car one cardinal direction going clockwise.
     */
    public void turnRight() {
        this.direction = Math.floorMod(this.direction - 1);
    }

    // Car speed features.
    void gas(double amount) {
	    if(0 <= amount && amount <= 1) {
	    incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Argument must be in the interval [0,1].");
        }
    }
    void brake(double amount) {
        if(0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else {
                throw new IllegalArgumentException("Argument must be in the interval [0,1].");
        }
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }
    // Abstract methods that needs to be implemented later.
    abstract double speedFactor();
    abstract void incrementSpeed(double amount);
    abstract void decrementSpeed(double amount);
}
