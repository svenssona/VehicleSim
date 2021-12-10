import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Creates a car ferry that can load cars onto it and then transport them.
 * @param <T> Can either load all loadable objects or a specific type of loadable objects.
 */
public class Ferry<T extends LoadableCar> extends CarTransport<T> {
    /**
     * Constructs the legendary ferry NightCruiser420 with 1000 hp.
     */
    public Ferry() {
        super(1, 1000, Color.black, "NightCruiser420",
                new Point2D.Double(0,0));
    }

    /**
     * Handles how the cargo get loaded off the ferry.
     * @return Returns the car in the FIFO sequence.
     * @throws IllegalStateException If the bed is not at the lower position then we can't unload.
     */
    @Override
    public T unloadCargo() throws IllegalStateException {
        return this.getBed().unloadCargo(getDirection(), false);
    }
}

