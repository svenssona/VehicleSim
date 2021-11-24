import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on Scania.
 */
class ScaniaTest {
    private Scania car;

    @BeforeEach
    void newCar() {
        car = new Scania();
    }

    @Test
    void raiseBedTest() {
        car.raiseBed(10);
        assertEquals(10, car.getBedAngle());
    }

    @Test
    void lowerBedTest() {
        car.raiseBed(20);
        car.lowerBed(10);
        assertEquals(10, car.getBedAngle());
    }

    @Test
    void raiseBedMaxTest() {
        car.raiseBed(80);
        assertEquals(70, car.getBedAngle());
    }

    @Test
    void lowerBedMinTest() {
        car.lowerBed(10);
        assertEquals(0, car.getBedAngle());
    }
}
