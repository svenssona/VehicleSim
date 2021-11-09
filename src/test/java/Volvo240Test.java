import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    @Test
    void moveTest() {
        Volvo240 bil = new Volvo240();
        bil.gas(1);
        bil.turnRight();
        bil.move();
        assertEquals(1.25, bil.xPos);
    }

    @Test
    void brakeException() {
        Volvo240 bil = new Volvo240();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bil.brake(10),
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