import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel implements VehicleListener {

    private Map<Vehicle, BufferedImage> carImages = new HashMap<>();

    /**
     * Initializes the panel.
     * @param x Horizontal dimension for your panel.
     * @param y Vertical dimension for your panel.
     */
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    /**
     * Adds a given vehicle to the map of all images.
     * @param car The new vehicle image that you want to add.
     */
    public void addCarImage(Vehicle car) {
        // Prints a stack tree message in case file is not found in the try block.
        try {
            BufferedImage carImage = getCarImage(car.getModelName());
            carImages.put(car, carImage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // Helper method for when adding a car to the map, handles reading and loading.
    private BufferedImage getCarImage(String carName) throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream(carName + ".jpg"));
    }

    public void updateVehicles(List<Vehicle> vehicles) {
        carImages = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            addCarImage(vehicle);
        }
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself.
     * @param g Graphical component on which we draw.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car : carImages.keySet())  {
            Point2D carPoint = car.getPosition();
            // See javadoc for more info on the parameters.
            g.drawImage(carImages.get(car), (int) Math.round(carPoint.getX()),
                    (int) Math.round(carPoint.getY()), null);
        }
    }
}
