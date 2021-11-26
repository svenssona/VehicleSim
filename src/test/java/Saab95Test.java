import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class for testing the possible operations on Saab95.
 */
class Saab95Test {
    private Saab95 car;

    @BeforeEach
    void newCar() {
        car = new Saab95();
    }

    @Test
    void moveTest() {
        car.gas(1);
        car.move();
        assertEquals(1.25, car.getPosition().getY());
    }

    @Test
    void breakTest() {
        car.gas(1);
        car.brake(0);
        assertEquals(1.25, car.getCurrentSpeed());
    }

    @Test
    void doorTest() {
        assertEquals(2, car.getNrDoors());
    }
    @Test
    void colorTest() {
        car.setColor(Color.BLACK);
        assertEquals(Color.BLACK, car.getColor());
    }
    @Test
    void startEngineTest() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }
    @Test
    void enginePowerTest() {
        assertEquals(125, car.getEnginePower());
    }
    @Test
    void turnLeftTest() {
        car.turnLeft();
        assertEquals(1, car.getDirection());
    }

    @Test
    void turnRightTest() {
        car.turnRight();
        assertEquals(3, car.getDirection());
    }

    @Test
    void setPositionTest() {
        car.setPosition(new Point2D.Double(47, 47));
        assertEquals(new Point2D.Double(47,47), car.getPosition());
    }

    @Test
    void testTurbo() {
        car.setTurbo(true);
        car.gas(1);
        assertEquals(1.625, car.getCurrentSpeed());
    }
}
