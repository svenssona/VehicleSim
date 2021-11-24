import java.awt.Color;
import java.awt.geom.Point2D;
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
    Point2D position; // Holds (x,y) position of the car.
    int direction; // Direction value of the car, North = 0, West = 1, South = 2, East = 3.
    private final int NORTH = 0;
    private final int WEST = 1;
    private final int SOUTH = 2;
    private final int EAST = 3;

    // Getters.
    /**
     * Returns the number of doors of the car.
     */
    public int getNrDoors() { return nrDoors; }

    /**
     * Returns the color of the car.
     */
    public Color getColor() { return color; }

    /**
     * Returns the engine power of the car.
     */
    public double getEnginePower() { return enginePower; }
    /**
     * Returns the current speed of the car.
     */
    public double getCurrentSpeed() { return currentSpeed; }

    /**
     * Returns the current position of the car.
     */
    public Point2D getPosition() { return position; }

    /**
     * Returns the current position of the car.
     */
    public int getDirection() { return direction; }

    // Setter.
    /**
     * Sets the color of the car.
     * @param color The color to set the car to.
     */
    public void setColor(Color color) { this.color = color; }

    /**
     * Sets the position of the car.
     * @param position The position to set the car to.
     */
    public void setPosition(Point2D position) { this.position = position; }

    // Car engine features.
    /**
     * Starts the engine and sets the current speed to 0.1.
     */
    public void startEngine() { currentSpeed = 0.1; }
    /**
     * Stops the engine and sets the current speed to 0.
     */
    public void stopEngine() { currentSpeed = 0; }

    // Car position features.
    /**
     * Moves the car by the value of speed according to the direction attribute.
     */
    public void move() {
        switch (this.direction) {
            case NORTH: this.position.setLocation(this.position.getX(),this.position.getY()+this.getCurrentSpeed());
                break;
            case WEST: this.position.setLocation(this.position.getX()-this.getCurrentSpeed(),this.position.getY());
                break;
            case SOUTH: this.position.setLocation(this.position.getX(),this.position.getY()-this.getCurrentSpeed());
                break;
            case EAST: this.position.setLocation(this.position.getX()+this.getCurrentSpeed(),this.position.getY());
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

    // Returns the distance between two points. 
    static double distance(Point2D pointA, Point2D pointB) {
        double squaredDistance = Math.pow(pointA.getX()-pointB.getX(),2)
                + Math.pow(pointA.getY()-pointB.getY(),2);
        return Math.sqrt(squaredDistance);
    }

    // Car speed features.
    /**
     * Speeds up the car.
     * @param amount Factor increasing the speed, must be in the interval [0,1].
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
