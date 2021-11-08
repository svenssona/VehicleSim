import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

class Saab95Test {

    Saab95 bil = new Saab95();

    @BeforeEach
    public void setUp() {
        Saab95 bil = new Saab95();
    }

    @Test
    void move() {
        bil.gas(1);
        bil.move();
        assertEquals(1.25, bil.yPos);
    }

    @Test
    void turnLeft() {
        bil.turnLeft();
        assertEquals(1, bil.direction);
    }

    @Test
    void turnRight() {
        bil.turnRight();
        assertEquals(3, bil.direction);
    }
}