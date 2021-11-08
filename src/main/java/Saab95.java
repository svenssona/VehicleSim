import java.awt.Color;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
        xPos = 0.0;
        yPos = 0.0;
    }


    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    void incrementSpeed(double amount){
        currentSpeed = Math.min(enginePower, getCurrentSpeed() + speedFactor() * amount);
    }

    void decrementSpeed(double amount){
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
    }

    public static class main{
        public static void main(String[] arg) {
        Volvo240 bil = new Volvo240();
        System.out.println(bil.getCurrentSpeed());
        }
    }
}
