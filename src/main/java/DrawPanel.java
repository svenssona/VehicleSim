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

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel {

    Map<Vehicle, BufferedImage> carImages = new HashMap<>();

    public void addCar(Vehicle car) {
        try {
            BufferedImage carImage = getCarImage(car.getModelName());
            carImages.put(car, carImage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private BufferedImage getCarImage(String carName) throws IOException {
        // Print an error message in case file is not found with a try/catch block.
        try {
            return ImageIO.read(DrawPanel.class.getResourceAsStream(carName + ".jpg"));
        } catch (IOException e) {
            System.out.println("Error: (file not found). No such car with that carName.jpg in the resources folder.");
            return null;
        }
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
        for (Vehicle car : carImages.keySet())  {
            Point2D carPoint = car.getPosition();
            // see javadoc for more info on the parameters
            g.drawImage(carImages.get(car), (int) Math.round(carPoint.getX()), (int) Math.round(carPoint.getY()), null);
        }
    }
}
