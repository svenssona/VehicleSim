import java.awt.geom.Point2D;

/**
 * Marks implementing class as loadable object.
 */
public interface Loadable {

    /**
     * Sets if the object is loaded or not.
     * @param loadState Sets if the object to a loaded or offloaded state. (true/false)
     */
    void setLoadState(boolean loadState);

    /**
     * Returns whether the object is loaded.
     * @return Returns whether the object is loaded.
     */
    boolean getLoadState();

    /**
     * Sets the position of the loadable object.
     * @param position Sets the position of the current loadable object.
     */
    void setPosition(Point2D position);

    /**
     * Returns the current position of the loadable object.
     * @return Returns the current position of the loadable object.
     */
    Point2D getPosition();


}
