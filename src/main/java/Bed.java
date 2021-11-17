/**
 * Object class for constructing a loading bed with its specific features.
 * @author Richard Svensson
 * @author Victor Salomonsson
 * @author Leo Ånestrand
 * @version 1.0.0
 */
class Bed {

    private double bedAngle = 0;
    private double maxAngle;
    private double minAngle;

    /**
     * Creates a bed with specified max angle in the interval [0, maxAngle].
     * @param maxAngle
     */
    public Bed(double maxAngle) {
        this.maxAngle = maxAngle;
        this.minAngle = 0;
    }

    public Bed(double maxAngle, double minAngle) {
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
    }

    /**
     * Raises the trucks loading bed a desired amount caps out at maxAngle degrees.
     * @param deltaAngle
     */
    public void raiseBed(double deltaAngle) {
        double newAngle = this.bedAngle + deltaAngle;
        this.bedAngle = newAngle < this.maxAngle ? newAngle : this.maxAngle;
    }

    /**
     * Lowers the trucks loading bed a desired amount.
     * @param deltaAngle
     */
    public void lowerBed(double deltaAngle) {
        double newAngle = this.bedAngle - deltaAngle;
        this.bedAngle = newAngle > this.minAngle ? newAngle : this.minAngle;
    }

    /**
     * Returns the bed angle.
     */
    public double getBedAngle() {
        return bedAngle;
    }
}
