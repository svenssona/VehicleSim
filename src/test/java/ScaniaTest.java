import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on Scania.
 */
class ScaniaTest {
    private Scania bil;

    @BeforeEach
    void newBil() {
        bil = new Scania();
    }

    @Test
    void raiseBedTest() {
        bil.raiseBed(10);
        assertEquals(10, bil.getBedAngle());
    }

    @Test
    void lowerBedTest() {
        bil.raiseBed(20);
        bil.lowerBed(10);
        assertEquals(10, bil.getBedAngle());
    }

    @Test
    void raiseBedMaxTest() {
        bil.raiseBed(80);
        assertEquals(70, bil.getBedAngle());
    }

    @Test
    void lowerBedMinTest() {
        bil.lowerBed(10);
        assertEquals(0, bil.getBedAngle());
    }
}
