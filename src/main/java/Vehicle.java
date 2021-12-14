import java.awt.Color;
import java.awt.geom.Point2D;
import java.lang.IllegalArgumentException;

/**
 * This is an abstract class defining the basic functions of a vehicle.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 2.0.0
 */
public abstract class Vehicle implements Moveable {

    /**
     * Parameters defining the cars characterises and initial states.
     */
    private final int nrDoors; // Number of doors on the vehicle.
    private final double enginePower; // Engine power of the vehicle.
    private double currentSpeed; // The current speed of the vehicle.
    private Color color; // Color of the vehicle.
    private String modelName; // The vehicle model name.
    private Point2D position; // Holds (x,y) position of the vehicle.
    private Direction direction; // Direction value of the vehicle, North = 0, West = 1, South = 2, East = 3.
    
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, Point2D position) {
        this.nrDoors = nrDoors; 
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
        this.direction = Direction.NORTH;
        stopEngine();
    }

    // Getters.
    /**
     * Returns the number of doors on your specific vehicle.
     * @return Returns the number of doors on your specific vehicle.
     */
    public int getNrDoors() { return nrDoors; }

    /**
     * Returns the model name of your specific vehicle.
     * @return Returns the model name of your specific vehicle.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *  Returns the color of your specific vehicle.
     * @return Returns the color of your specific vehicle.
     */
    public Color getColor() { return color; }

    /**
     * Returns the engine power of the vehicle.
     * @return Returns the engine power of the vehicle.
     */
    public double getEnginePower() { return enginePower; }
    /**
     * Returns the current speed of the vehicle.
     * @return Returns the current speed of the vehicle.
     */
    public double getCurrentSpeed() { return currentSpeed; }

    /**
     *  Returns the current position of the vehicle.
     * @return Returns the current position of the vehicle.
     */
    public Point2D getPosition() { return position; }

    /**
     *  Returns the current position of the vehicle.
     * @return Returns the current position of the vehicle.
     */
    public Direction getDirection() { return direction; }

    // Setter.
    /**
     * Sets the color of the vehicle.
     * @param color The color to set the vehicle to.
     */
    public void setColor(Color color) { this.color = color; }

    /**
     * Sets the position of the vehicle.
     * @param position The position to set the vehicle to.
     */
    public void setPosition(Point2D position) { this.position = position; }

    // Vehicle engine features.
    /**
     * Starts the engine and sets the current speed to 1.
     */
    public void startEngine() { currentSpeed = 1; }
    /**
     * Stops the engine and sets the current speed to 0.
     */
    public void stopEngine() { currentSpeed = 0; }

    // Vehicle position features.
    /**
     * Moves the vehicle by the value of speed according to the direction attribute.
     */
    public void move() {
        switch (this.direction) {
            case NORTH: translate(this.position, 0, this.getCurrentSpeed());
                break;
            case WEST: translate(this.position, -this.getCurrentSpeed(), 0);
                break;
            case SOUTH: translate(this.position, 0, -this.getCurrentSpeed());
                break;
            case EAST: translate(this.position, this.getCurrentSpeed(), 0);
                break;
        }
    }

    // Moves the specified point by dx and dy in x and y direction respectivly.
    private void translate(Point2D position, double dx, double dy) {
        position.setLocation(position.getX() + dx, position.getY() + dy);
    }

    /**
     * Turns the vehicle one cardinal direction going counterclockwise.
     */
    public void turnLeft() {
        // Takes the index value in enum Direction increments it modulo 4
        // and then reconvert it from int to new Direction.
        int newIndex = Math.floorMod(this.direction.ordinal() + 1, 4);
        this.direction = Direction.values()[newIndex];
    }
    /**
     * Turns the vehicle one cardinal direction going clockwise.
     */
    public void turnRight() {
        // Takes the index value in enum Direction increments it modulo 4
        // and then reconvert it from int to new Direction.
        int newIndex = Math.floorMod(this.direction.ordinal() - 1, 4);
        this.direction = Direction.values()[newIndex];
    }

    // Vehicle speed features.
    /**
     * Speeds up the vehicle.
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
     * Slows down the vehicle.
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

    @Override
    public String toString() {
        return modelName;
    }

    // Abstract methods that needs to be implemented later.
    abstract double speedFactor();
}
