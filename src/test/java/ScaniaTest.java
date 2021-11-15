import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on Scania.
 */
class ScaniaTest {
    @Test
    void raiseBedTest() {
        Scania bil = new Scania();
        bil.raiseBed(10);
        assertEquals(10, bil.bedAngle);
    }

    @Test
    void lowerBedTest() {
        Scania bil = new Scania();
        bil.raiseBed(20);
        bil.lowerBed(10);
        assertEquals(10, bil.bedAngle);
    }

    @Test
    void raiseBedMaxTest() {
        Scania bil = new Scania();
        bil.raiseBed(80);
        assertEquals(70, bil.bedAngle);
    }

    @Test
    void lowerBedMinTest() {
        Scania bil = new Scania();
        bil.lowerBed(10);
        assertEquals(0, bil.bedAngle);
    }
}
