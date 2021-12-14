import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private final Model model = new Model();
    Vehicle saab = new Saab95();
    Vehicle volvo = new Volvo240();

    @Test
    void addVehicle() {
        model.addVehicle(saab);
        model.addVehicle(volvo);
        assertEquals(2, model.getVehicles().size());
    }

    @Test
    void removeVehicle() {
        model.addVehicle(saab);
        model.addVehicle(volvo);
        model.removeVehicle(volvo);
        assertSame(saab, model.getVehicles().get(0));
    }
}