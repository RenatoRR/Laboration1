import java.awt.*;

/** This class creates a Saab95 object/car. It inherits the {@code Vehicle} class that contains common values needed. */

public class Saab95 extends Vehicle{
    /** A boolean variable to see if turbo is on or off. */
    private boolean turboOn;

    /** The constructor to initialize certain fields and methods.*/
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }


    /** Turns the turbo on by setting {@code turboOn = true}*/
    public void setTurboOn(){
	    turboOn = true;
    }
    /** Turns the turbo off by setting {@code turboOn = false}*/
    public void setTurboOff(){
	    turboOn = false;
    }

    /** This methods calculates the speedfactor of the car. Different values if {@code turboOn} is true or false.*/
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /** This method increases the current speed of the car by a percentage of {@code speedFactor}.
     * {@code currentSpeed} can never be outside of the interval {@code [0,enginePower]} so
     * {@code acceptableInterval} is used in method.*/
    public void incrementSpeed(double amount){
        if (acceptableInterval((getCurrentSpeed() + speedFactor() * amount),0,getEnginePower()) ) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }
    }

    /** This method decreases the current speed of the car by a percentage of {@code speedFactor}.
     * {@code currentSpeed} can never be outside of the interval {@code [0,enginePower]} so
     * {@code acceptableInterval} is used in method.*/
    public void decrementSpeed(double amount){
        if (acceptableInterval((getCurrentSpeed() - speedFactor() * amount),0,getEnginePower()) ) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }

    }


    // TODO fix this method according to lab pm
    /** This method enters an amount as an argument in {@code incrementSpeed} if the amount is between [0,1] (0% to 100%)*/
    public void gas(double amount){
        if(acceptableInterval(amount, 0,1)) {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    /** This method enters an amount as an argument in {@code decrementSpeed} if the amount is between [0,1] (0% to 100%)*/
    public void brake(double amount){
        if(acceptableInterval(amount,0,1)) {
            decrementSpeed(amount);
        }
    }
}

