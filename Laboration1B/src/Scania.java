import java.awt.*;

public class Scania extends Vehicle { //Alternative is to inherit a truck class instead.

    private int truckBedX;
    private int truckBedY = 0;
    private int truckBedAngle;

    public Scania(int bedlengthX){
        super(2,250,Color.black,"ScaniaTruck");
        this.truckBedX = bedlengthX;
    }

    public int getTruckBedX(){
        return truckBedX;
    }

    public int getTruckBedY(){
        return truckBedY;
    }

    public int getTruckBedAngle(){
        return truckBedAngle;
    }

    public double speedFactor(){
        return enginePower * 0.01;
    } //Can develop further later on.



    public void raiseBed(double degrees){
        if (currentSpeed == 0 && (truckBedAngle+degrees > 0 && truckBedAngle+degrees <70)){
            truckBedAngle += degrees;
        }
    }

    public void lowerBed(double degrees){
        if (currentSpeed == 0 && (truckBedAngle-degrees > 0 && truckBedAngle-degrees <70)){
            truckBedAngle -= degrees;
        }
    }

    @Override
    protected void incrementSpeed(double amount) {
        if (acceptableInterval((getCurrentSpeed() + speedFactor() * amount),0,getEnginePower()) ) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }

    }
    @Override
    protected void decrementSpeed(double amount) {
        if (acceptableInterval((getCurrentSpeed() - speedFactor() * amount),0,getEnginePower()) ) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
    }

    @Override
    public void move(){
        if (truckBedAngle == 0){
            double dx = currentSpeed * (double) ((getCurrentDirection() % 2 * (alternatingStatesForDirection[getCurrentDirection() % 4])));
            double dy = currentSpeed * (double) (((1 + getCurrentDirection() % 2) * (alternatingStatesForDirection[getCurrentDirection() % 4])));
            currentPoint.translate(dx, dy);
        }
    }

}
