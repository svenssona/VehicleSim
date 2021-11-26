import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class handles all the repairs of a broken car.
 * @param <T> The car shop can either take all different brands of cars or a specific brand.
 */
public class CarShop <T extends Car> {
    
    private List<T> carsInShop;
    private int capacity;

    /**
     * Constuct a car shop that can service maxNumberCars of cars at once.
     * @param maxNumberCars Max number of cars that can be serviced at once.
     */
    public CarShop(int maxNumberCars) {
        carsInShop = new ArrayList<>(maxNumberCars);
        this.capacity = maxNumberCars;
    }

    /**
     * Puts a car into the car shop for service.
     * @param car Car to put into the shop.
     */
    public void intoService(T car) {
        if (carsInShop.size() < capacity) {
            this.carsInShop.add(car);
        }
    }

    /**
     * Takes a car out from the car shop.
     * @param car Car to take out from the shop.
     */
    public void outFromService(T car) throws NoSuchElementException {
        if (carsInShop.contains(car)) {
            carsInShop.remove(car);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * @return Returns a list with all the cars in the shop.
     */
    public List<T> getCarsInShop() {
        return carsInShop;
    }

    /**
     * Repair cars.
     */
    public void repair() {
        System.out.println("Clank, clonk, crunk. \"We're almost finished\"");
    }
}
