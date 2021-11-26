import java.awt.geom.Point2D;

/**
 * Marks implementing class as loadable object.
 */
public interface Loadable {
    /**
     * Sets the position of the loadable object.
     * @param position
     */
    void setPosition(Point2D position);

    /**
     * @return Returns the current position of the loadable object.
     */
    Point2D getPosition();
}
