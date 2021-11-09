import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


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
    void breakTest() {
        Saab95 bil = new Saab95();
        bil.gas(1);
        bil.brake(0);
        assertEquals(1.25, bil.getCurrentSpeed());
    }

    @Test
    void doorTest() {
        Saab95 bil = new Saab95();
        assertEquals(2, bil.getNrDoors());
    }
    @Test
    void colorTest() {
        Saab95 bil = new Saab95();
        bil.setColor(Color.BLACK);
        assertEquals(Color.BLACK, bil.getColor());
    }
    @Test
    void startEngineTest() {
        Saab95 bil = new Saab95();
        bil.startEngine();
        assertEquals(0.1, bil.getCurrentSpeed());
    }
    @Test
    void enginePowerTest() {
        Saab95 bil = new Saab95();
        assertEquals(125, bil.getEnginePower());
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