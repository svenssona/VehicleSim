import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarShopTest {

    @Test
    void genericCarShopTest() {
        // Tests that we can have two different brands of Cars in our shop.
        CarShop<Car> carShop = new CarShop<>(2);
        carShop.intoService(new Volvo240());
        carShop.intoService(new Saab95());
        assertEquals(2, carShop.getCarsInShop().size());
    }

    @Test
    void compileErrorTest() {
        CarShop<Volvo240> volvo240CarShop = new CarShop<>(2);
        volvo240CarShop.intoService(new Volvo240());
        // volvo240CarShop.intoService(new Saab95());
    }

    @Test
    void outFromServiceTest() {
        CarShop<Volvo240> volvo240CarShop = new CarShop<>(2);
        Volvo240 victorsVolvo240 = new Volvo240();
        volvo240CarShop.intoService(victorsVolvo240);
        volvo240CarShop.outFromService(victorsVolvo240);
        // volvo240CarShop.outFromService(new Saab95());
    }

}