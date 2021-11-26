import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on CarTransport.
 */
class CarTransportTest {
    private CarTransport<Loadable> car;

    @BeforeEach
    void newCar() {
        car = new CarTransport<>(2, 300, Color.red, "Scania Super",
            new Point2D.Double(0, 0));
    }

    @Test
    void raiseBedTest() {
        car.raiseBed();
        assertEquals(90, car.getBedAngle());
    }

    @Test
    void lowerBedTest() {
        car.raiseBed();
        car.lowerBed();
        assertEquals(-20, car.getBedAngle());
    }

    @Test
    void raiseBedMaxTest() {
        car.raiseBed();
        assertEquals(90, car.getBedAngle());
    }

    @Test
    void lowerBedMinTest() {
        car.lowerBed();
        assertEquals(-20, car.getBedAngle());
    }

    @Test
    void loadDiffCars() {
        // Makes sure we get a static compile time error when loading a Scania and that we can load both a Volvo240 and
        // Saab95 at the same time.
        car.loadCargo(new Volvo240());
        car.loadCargo(new Saab95());
        // car.loadCargo(new Scania());
    }
}
