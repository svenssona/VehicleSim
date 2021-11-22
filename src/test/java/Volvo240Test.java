import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the possible operations on Volvo240.
 */
class Volvo240Test {
    private Volvo240 bil;

    @BeforeEach
    void newBil() {
        bil = new Volvo240();
    }

    @Test
    void moveEastTest() {
        bil.gas(1);
        bil.turnRight();
        bil.move();
        assertEquals(1.25, bil.position[0]);
    }

    @Test
    void moveSouthTest() {
        bil.gas(1);
        bil.turnRight();
        bil.turnRight();
        bil.move();
        assertEquals(-1.25, bil.position[1]);
    }

    @Test
    void moveWestTest() {
        bil.gas(1);
        bil.turnLeft();
        bil.move();
        assertEquals(-1.25, bil.position[0]);
    }
    @Test
    void breakTest() {
        bil.gas(1);
        bil.brake(1);
        assertEquals(0, bil.currentSpeed);
    }

    @Test
    void brakeException() {
        Volvo240 bil = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bil.brake(10),
                "Expected break() to throw, but it didn't");
        assertEquals("Argument must be in the interval [0,1].", exception.getMessage());
    }

    @Test
    void gasException() {
        Volvo240 bil = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bil.gas(10),
                "Expected gas() to throw, but it didn't");
        assertEquals("Argument must be in the interval [0,1].", exception.getMessage());
    }

    @Test
    void turnLeftTest() {
        Volvo240 bil = new Volvo240();
        bil.turnLeft();
        bil.turnLeft();
        assertEquals(2, bil.direction);
    }

    @Test
    void turnRightTest() {
        Volvo240 bil = new Volvo240();
        bil.turnRight();
        assertEquals(3, bil.direction);
    }
}