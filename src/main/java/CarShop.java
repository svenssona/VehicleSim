import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarShop <T extends Car> {
    
    private List<T> carsInShop;
    private int capacity;

    public CarShop(int maxNumberCars) {
        carsInShop = new ArrayList<>(maxNumberCars);
        this.capacity = maxNumberCars;
    }

    public void intoService(T car) {
        if (carsInShop.size() < capacity) {
            this.carsInShop.add(car);
        }
    }

    public void outFromService(T car) throws NoSuchElementException {
        if (carsInShop.contains(car)) {
            carsInShop.remove(car);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void repair() {
        System.out.println("Clank, clonk, crunk. \"We're almost finished\"");
    }
}
