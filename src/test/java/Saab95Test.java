import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class for testing the possible operations on Saab95.
 */
class Saab95Test {
    private Saab95 bil;

    @BeforeEach
    void newBil() {
        bil = new Saab95();
    }

    @Test
    void moveTest() {
        bil.gas(1);
        bil.move();
        assertEquals(1.25, bil.yPos);
    }

    @Test
    void breakTest() {
        bil.gas(1);
        bil.brake(0);
        assertEquals(1.25, bil.getCurrentSpeed());
    }

    @Test
    void doorTest() {
        assertEquals(2, bil.getNrDoors());
    }
    @Test
    void colorTest() {
        bil.setColor(Color.BLACK);
        assertEquals(Color.BLACK, bil.getColor());
    }
    @Test
    void startEngineTest() {
        bil.startEngine();
        assertEquals(0.1, bil.getCurrentSpeed());
    }
    @Test
    void enginePowerTest() {
        assertEquals(125, bil.getEnginePower());
    }
    @Test
    void turnLeftTest() {
        bil.turnLeft();
        assertEquals(1, bil.direction);
    }

    @Test
    void turnRightTest() {
        bil.turnRight();
        assertEquals(3, bil.direction);
    }
}