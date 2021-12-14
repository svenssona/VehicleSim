import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/
public class CarView extends JFrame implements ActionListener {
    private static final int X = 800;
    private static final int Y = 800;
    private int gasAmount = 0;

    CarController carC;  // The controller member that we need to call when an action is performed.
    DrawPanel drawPanel = new DrawPanel(X, Y-240);
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");
    JSpinner gasSpinner;

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Turbo On");
    JButton turboOffButton = new JButton("Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public CarView(String frameName, CarController cc) {
        this.carC = cc;
        initComponents(frameName);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        this.add(controlPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        // This actionListener is for the gas button only
        gasButton.addActionListener(e -> carC.gas(gasAmount));
        // This is the actionListener for the brake button only
        brakeButton.addActionListener(e -> carC.brake(gasAmount));
        // This is the actionListener for the turbo on button only
        turboOnButton.addActionListener(e -> carC.setTurbo(true));
        // This is the actionListener for the turbo off button only
        turboOffButton.addActionListener(e -> carC.setTurbo(false));
        // This is the actionListener for the lift bed button only
        liftBedButton.addActionListener(e -> carC.adjustBed(true));
        // This is the actionListener for the lower bed button only
        lowerBedButton.addActionListener(e -> carC.adjustBed(false));
        // This is the actionListener for the start all cars button.
        startButton.addActionListener(e -> carC.startAllCars());
        // This is the actionListener for the stop all cars button.
        stopButton.addActionListener(e -> carC.stopAllCars());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Updates the observer if the publisher sends a signal and repaints the view.
     */
    @Override
    public void actionPreformed(ActionEvent e) {
        repaint();
    }
}
