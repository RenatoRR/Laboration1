import java.awt.*;


/** This class creates a Saab95 object/car. It inherits the {@code Vehicle} class that contains common values needed. */
public class Volvo240 extends Vehicle{

    /** An final field used in calculating {@code speedFactor}*/
    public final static double trimFactor = 1.25;

    /** The constructor to initialize certain fields and methods.*/
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /** This methods calculates the speedfactor of the car using {@code trimFactor} */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /** This method increases the speed of the car with the minimum of current speed with an extra speed depending on @code amount}, or the {@code enginePower}.
     * {@code currentSpeed} can never be outside of the interval {@code [0,enginePower]} so
     * {@code acceptableInterval} is used in method.*/
    public void incrementSpeed(double amount){
        if(acceptableInterval(Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower),0,getEnginePower())) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }

    }

    /** This method decreases the speed of the car with the maximum of current speed subtracted by an amount depending on {@code amount}, or {@code enginePower}.
     * {@code currentSpeed} can never be outside of the interval {@code [0,enginePower]} so
     * {@code acceptableInterval} is used in method.*/
    public void decrementSpeed(double amount){
        if(acceptableInterval(Math.max(getCurrentSpeed() - speedFactor() * amount,0),0,getEnginePower())) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }

    }

    /** This method enters an amount as an argument in {@code incrementSpeed} if the amount is between [0,1] (0% to 100%)*/
    public void gas(double amount) {
        if (acceptableInterval(amount,0,1)) {
            incrementSpeed(amount);
        }
    }

    /** This method enters an amount as an argument in {@code decrementSpeed} if the amount is between [0,1] (0% to 100%)*/
    public void brake(double amount){
        if(acceptableInterval(amount,0,1)) {
            decrementSpeed(amount);
        }
    }
}
