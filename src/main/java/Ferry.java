import java.awt.*;

public class Ferry<T extends Loadable> extends CarTransport<T> {
    /**
     * Constructs the legendary ferry NightCruiser420 with 1000 hp. It can take up to 10 cars.
     */
    public Ferry() {
        nrDoors = 1;
        color = Color.black;
        enginePower = 1000;
        modelName = "NightCruiser420";
        stopEngine();
        position = new double[]{0, 0};
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