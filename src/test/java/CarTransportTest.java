import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class for testing the possible operations on CarTransport.
 */
class CarTransportTest {
    private CarTransport<LoadableCar> carTransporter;
    private static final double dummyAngle = -1;

    @BeforeEach
    void newCar() {
        carTransporter = new CarTransport<>(2, 300, Color.red, "MegaLoader69",
            new Point2D.Double(0, 0));
    }

    @Test
    void raiseBedTest() {
        carTransporter.raiseBed(dummyAngle);
        assertEquals(90, carTransporter.getBedAngle());
    }

    @Test
    void lowerBedTest() {
        carTransporter.raiseBed(dummyAngle);
        carTransporter.lowerBed(dummyAngle);
        assertEquals(-20, carTransporter.getBedAngle());
    }

    @Test
    void raiseBedMaxTest() {
        carTransporter.raiseBed(dummyAngle);
        assertEquals(90, carTransporter.getBedAngle());
    }

    @Test
    void lowerBedMinTest() {
        carTransporter.lowerBed(dummyAngle);
        assertEquals(-20, carTransporter.getBedAngle());
    }

    @Test
    void loadDiffCars() {
        // Makes sure we get a static compile time error when loading a Scania and that we can load both a Volvo240 and
        // Saab95 at the same time.
        carTransporter.lowerBed(dummyAngle);
        carTransporter.loadCargo(new Volvo240());
        carTransporter.loadCargo(new Saab95());
        // carTransporter.loadCargo(new Scania());
    }

    @Test
    void carStaysOnTransport() {
        Volvo240 volvo = new Volvo240();

        carTransporter.lowerBed(dummyAngle);
        carTransporter.loadCargo(volvo);
        carTransporter.raiseBed(dummyAngle);

        double carPositionX = carTransporter.getPosition().getX();
        double carPositionY = carTransporter.getPosition().getY();

        volvo.turnLeft();
        volvo.gas(1.0);
        volvo.move();

        // Check if Volvo has the same position as CarTransport.
        assertEquals(carPositionX, volvo.getPosition().getX());
        assertEquals(carPositionY, volvo.getPosition().getY());

        // Make sure the CarTransport hasn't moved as a side effect of the Volvo moving.
        assertEquals(carPositionX, carTransporter.getPosition().getX());
        assertEquals(carPositionY, carTransporter.getPosition().getY());
    }

}
