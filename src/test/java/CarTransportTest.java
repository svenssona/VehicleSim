import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on CarTransport.
 */
class CarTransportTest {
    private CarTransport<Loadable> bil;

    @BeforeEach
    void newBil() { bil = new CarTransport<>(); }

    @Test
    void raiseBedTest() {
        bil.raiseBed();
        assertEquals(90, bil.getBedAngle());
    }

    @Test
    void lowerBedTest() {
        bil.raiseBed();
        bil.lowerBed();
        assertEquals(-20, bil.getBedAngle());
    }

    @Test
    void raiseBedMaxTest() {
        bil.raiseBed();
        assertEquals(90, bil.getBedAngle());
    }

    @Test
    void lowerBedMinTest() {
        bil.lowerBed();
        assertEquals(-20, bil.getBedAngle());
    }

    @Test
    void loadDiffCars() {
        // Makes sure we get a static compile time error when loading a Scania and that we can load both a Volvo240 and
        // Saab95 at the same time.
        bil.loadCargo(new Volvo240());
        bil.loadCargo(new Saab95());
        // bil.loadCargo(new Scania());
    }
}
