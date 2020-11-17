import java.awt.*;

public class Truck extends Vehicle {

    public Truck(int nrDoors, double enginePower, Color colour, String modelName) {
        super(nrDoors, enginePower, colour, modelName);
    }

    @Override
    protected void incrementSpeed(double amount) {

    }
    @Override
    protected void decrementSpeed(double amount) {

    }
}
