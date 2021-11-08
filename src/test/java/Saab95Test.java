import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

/**
 * Class for testing the possible operations on Saab95.
 */
class Saab95Test {

    @Test
    void moveTest() {
        Saab95 bil = new Saab95();
        bil.gas(1);
        bil.move();
        assertEquals(1.25, bil.yPos);
    }

    @Test
    void turnLeftTest() {
        Saab95 bil = new Saab95();
        bil.turnLeft();
        assertEquals(1, bil.direction);
    }

    @Test
    void turnRightTest() {
        Saab95 bil = new Saab95();
        bil.turnRight();
        assertEquals(3, bil.direction);
    }
}