import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Class for creating objects. Hiding abstraction from the user.
 */
public class VehicleFactory implements IVehicleFactory {

    private final List<String> availableModels = new LinkedList<>(List.of("Saab95", "Volvo240", "Scania",
            "NighCruiser420", "Transport6000", "Random"));

    public List<String> getAvailableModels() {
        return availableModels;
    }

    /**
     * Creates a vehicle object given an input argument string matching available models.
     * @param modelName Specific model name of your object that you want to create.
     * @return returns the super type Vehicle of the object.
     * @throws IllegalArgumentException no such model name in the factory.
     */
    public Vehicle create(String modelName) throws IllegalArgumentException {
        switch (modelName) {
            case "Saab95":
                return new Saab95();
            case "Volvo240":
                return new Volvo240();
            case "Scania":
                return new Scania<>();
            case "NightCruiser420":
                return new Ferry<>();
            case "Transporter6000":
                return new CarTransport<>(2, 555,  Color.black,"Transporter6000",
                        new Point2D.Double(0,0));
            case "Random":
                Random rand = new Random();
                int randomIndex = rand.nextInt(availableModels.size());
                return create(availableModels.get(randomIndex));
        }
        throw new IllegalArgumentException("No such model: '" + modelName + "' in Factory, " +
                "run getAvailableModels for all models available.");
    }
}
