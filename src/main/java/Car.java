import java.awt.Color;
import java.lang.IllegalArgumentException;

/**
 * This is an abstract class defining the basic functions of a car.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
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

    // Getters.
    /**
     * Returns the number of doors of the car.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the engine power of the car.
     */
    public double getEnginePower() {
        return enginePower;
    }
    /**
     * Returns the current speed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    // Setter.
    /**
     * Sets the color of the car.
     * @param color The color to set the car to.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    // Car engine features.
    /**
     * Starts the engine and sets the current speed to 0.1.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }
    /**
     * Stops the engine and sets the current speed to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    // Car position features.
    /**
     * Moves the car by the value of speed according to the direction attribute.
     */
    public void move(){
	switch (this.direction) {
	    case 0: this.yPos += this.getCurrentSpeed(); // North
		    break;
	    case 1: this.xPos -= this.getCurrentSpeed(); // West
		    break;
	    case 2: this.yPos -= this.getCurrentSpeed(); // South
		    break;
	    case 3: this.xPos += this.getCurrentSpeed(); // East
		    break;
	}
    }
    /**
     * Turns the car one cardinal direction going counterclockwise.
     */
    public void turnLeft() {
        this.direction = Math.floorMod(this.direction + 1, 4);
    }
    /**
     * Turns the car one cardinal direction going clockwise.
     */
    public void turnRight() {
        this.direction = Math.floorMod(this.direction - 1, 4);
    }

    // Car speed features.

    /**
     * Speeds up the car.
     * @param amount Factor increasing the speed, must be interval [0,1].
     * @throws IllegalArgumentException Thrown when amount is outside the interval [0,1].
     */
    public void gas(double amount) {
	    if(0 <= amount && amount <= 1) {
	    incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Argument must be in the interval [0,1].");
        }
    }

    /**
     * Slows down the car.
     * @param amount Factor decreasing the speed, must be in the interval [0,1].
     * @throws IllegalArgumentException Thrown when amount is outside the interval [0,1].
     */
    public void brake(double amount) {
        if(0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Argument must be in the interval [0,1].");
        }
    }

    /**
     * @param amount by which the speed increases.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(enginePower, getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * @param amount by which the speed decreases.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
    }

    // Abstract methods that needs to be implemented later.
    abstract double speedFactor();

}
