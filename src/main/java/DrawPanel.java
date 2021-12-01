import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel {

    HashMap<Car, Point2D> carPoints = new HashMap<>();
    HashMap<Car, BufferedImage> carImages = new HashMap<>();

    void moveit(int x, int y, Car car) {
        carPoints.get(car).setLocation(x, y);
    }

    public void addCar(Car car) {
        try {
            BufferedImage carImage = getCarImage(car.getModelName());
            carImages.put(car, carImage);
            carPoints.put(car, car.getPosition());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private BufferedImage getCarImage(String carName) throws IOException {
        // Print an error message in case file is not found with a try/catch block
        return ImageIO.read(DrawPanel.class.getResourceAsStream(carName + ".jpg"));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : carImages.keySet())  {
            Point2D carPoint = carPoints.get(car);
            g.drawImage(carImages.get(car), (int) carPoint.getX(), (int) carPoint.getY(), null); // see javadoc for more info on the parameters
        }
    }
}
