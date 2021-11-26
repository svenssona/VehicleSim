import java.awt.*;
import java.awt.geom.Point2D;

public class Ferry<T extends Loadable> extends CarTransport<T> {
    /**
     * Constructs the legendary ferry NightCruiser420 with 1000 hp.
     */
    public Ferry() {
        super(1, Color.black, 1000, "NightCruiser420", new Point2D.Double(0,0));
    }

    /**
     * Handles how the cargo get loaded off the ferry.
     *
     * @return Returns the car in the FIFO sequence.
     * @throws IllegalStateException If the bed is not at the lower position then we can't unload.
     */
    @Override
    public T unloadCargo() throws IllegalStateException {
        return this.bed.unloadFirstCargo(getDirection());
    }
}
