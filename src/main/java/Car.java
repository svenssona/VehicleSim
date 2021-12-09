import java.awt.geom.Point2D;

/**
 * An interface that marks the implementor as a car.
 */
public interface Car {
    /**
     * Starts the engine and sets the current speed.
     */
    void startEngine();

    /**
     * Method that will set the current speed to 0.
     */
    void stopEngine();

    // Some necessary getters for our program.
    /**
     * Returns the model name of your specific vehicle.
     * @return Returns the model name of your specific vehicle.
     */
    String getModelName();

    /**
     *  Returns the current position of the vehicle.
     * @return Returns the current position of the vehicle.
     */
    Direction getDirection();

    /**
     * Sets the position of the vehicle.
     * @param position The position to set the vehicle to.
     */
    public void setPosition(Point2D position);

    // Vehicle position features.
    /**
     * Moves the vehicle.
     */
    void move();

    /**
     * Turns the vehicle one cardinal direction going counterclockwise.
     */
    void turnLeft();

    /**
     * Turns the vehicle one cardinal direction going clockwise.
     */
    void turnRight();

    /**
     * Speeds up the vehicle.
     * @param amount Factor increasing the speed, must be in the interval [0,1].
     * @throws IllegalArgumentException Thrown when amount is outside the interval [0,1].
     */
    void gas(double amount);

    /**
     * Slows down the vehicle.
     * @param amount Factor decreasing the speed, must be in the interval [0,1].
     * @throws IllegalArgumentException Thrown when amount is outside the interval [0,1].
     */
    void brake(double amount);
}

