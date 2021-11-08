import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    @Test
    void moveTest() {
        Volvo240 bil = new Volvo240();
        bil.gas(1);
        bil.move();
        assertEquals(1.25, bil.yPos);
    }

    @Test
    void turnLeftTest() {
        Volvo240 bil = new Volvo240();
        bil.turnLeft();
        assertEquals(1, bil.direction);
    }

    @Test
    void turnRightTest() {
        Volvo240 bil = new Volvo240();
        bil.turnRight();
        assertEquals(3, bil.direction);
    }
}