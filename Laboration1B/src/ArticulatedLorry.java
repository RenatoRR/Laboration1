import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ArticulatedLorry<T extends Vehicle> extends Vehicle { //Alternative is to inherit a truck class instead.


    private boolean truckRampDown; //True = down && False = up
    private int numberOfCarsAbleToLoad;
    private final int carLengthAverage = 5;
    private List<T> objectsLoaded = new ArrayList<>(0);

    public ArticulatedLorry(int numberOfCarsAbleToLoad){
        super(2,300, Color.white,"Lorry");
        this.numberOfCarsAbleToLoad = numberOfCarsAbleToLoad;
        this.truckRampDown = false;
        this.numberOfCarsAbleToLoad = numberOfCarsAbleToLoad;
    }


    public void switchTruckRampSetting(){
        if(this.currentSpeed == 0) {
            this.truckRampDown = !this.truckRampDown;
        }
    }

    public void loadObjects(List<T> objectsToLoad){ //This will only work if I make an interface with transportable.
        if(truckRampDown && objectsLoaded.size()<numberOfCarsAbleToLoad){
            for (T object : objectsToLoad) {
                if (Math.sqrt(Math.pow(object.getCurrentPoint().getX(),2)+Math.pow(object.getCurrentPoint().getY(),2)) <8) {
                    objectsLoaded.add(object);
                    object.getCurrentPoint().setLocation(this.getLocation());
                }
            }
        }
    }

    public void unloadObjects(List<T> objectsToUnload){ //Both methods (ToLoad) not fixed to not be able to load this.class
        if(truckRampDown){
            for (int i=-1; Math.abs(i)<= objectsToUnload.size();i--) {
                if (Math.sqrt(Math.pow(objectsToUnload.get(i).getCurrentPoint().getX(),2)+Math.pow(objectsToUnload.get(i).getCurrentPoint().getY(),2)) <8) {
                    objectsLoaded.remove(objectsToUnload.get(i));
                }
            }
        }
    }


    //temp. Might make an adjustment to remove code duplication.
    public double speedFactor(){
        return enginePower * 0.01;
    } //Can develop further later on.

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
        if (!truckRampDown){
            double dx = currentSpeed * (double) ((getCurrentDirection() % 2 * (alternatingStatesForDirection[getCurrentDirection() % 4])));
            double dy = currentSpeed * (double) (((1 + getCurrentDirection() % 2) * (alternatingStatesForDirection[getCurrentDirection() % 4])));
            currentPoint.translate(dx, dy);
            for (T object : objectsLoaded){
                object.getCurrentPoint().translate(dx,dy);
            }
        }
    }
}
