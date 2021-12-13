/**
 * An interface for using the Factory Method. Creating the vehicle from a given model name.
 */
public interface IVehicleFactory {
    Vehicle create(String modelName);
}
