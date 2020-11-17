import java.awt.*;


/** The {@code Vehicle} is an abstract class for all type of classes related to cars. It is used
 * to get common values that cars need in order to function and move in proper directions.
 *
 * @version 06 Nov 2020
 * @author Renato Roos Radevski
 * */
public abstract class Vehicle extends DoublePoint implements Movable{

    /** A variable showing how many doors a vehicle have. */
    protected int nrDoors;

    /** The engine power of the vehicle. */
    protected double enginePower;

    /** The current speed of the vehicle. Is always in interval of [0,enginePower]*/
    protected double currentSpeed;

    /** The color of the vehicle. */
    protected Color color;

    /** The model name of the vehicle. */
    protected String modelName;

    /** The current position of the vehicle in the form of a point with a x and a y coordinate.*/
    protected DoublePoint currentPoint;

    /** The current direction of the vehicle. Default value of field is {@code NORTH} that is represented as the integer value 0 */
    protected int currentDirection = NORTH;

    public Vehicle(int nrDoors, double enginePower, Color colour, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = colour;
        this.modelName = modelName;
        this.currentPoint = new DoublePoint();
        stopEngine();
    }

    /** A method to access and fetch {@code nrDoors} outside of class hierarchy.*/
    public int getNrDoors(){ return nrDoors; }

    /** A method to access and fetch {@code enginePower} outside of class hierarchy.*/
    public double getEnginePower(){return enginePower;}

    /** A method to access and fetch {@code currentSpeed} outside of class hierarchy.*/
    public double getCurrentSpeed(){ return currentSpeed; }

    /** A method to access and fetch {@code currentDirection} outside of class hierarchy.*/
    public int getCurrentDirection(){ return currentDirection;}

    /** A method to access and fetch {@code currentPoint} outside of class hierarchy.*/
    public DoublePoint getCurrentPoint(){ return currentPoint;} // OBSOLETE?

    /** A method to access and change {@code currentDirection} in order to give it a new direction.*/
    protected int setCurrentDirection(int newDirection) { return currentDirection = newDirection;}

    /** A method to access and fetch {@code color} outside of class hierarchy.*/
    public Color getColor(){ return color;}

    /** A method to access and set {@code color} of the vehicle.*/
    protected void setColor(Color clr){ color = clr; }

    /** This method "starts" the engine by setting the field {@code currentSpeed=0.1)*/
    public void startEngine(){ currentSpeed = 0.1; }

    /** This method "stops" the engine by setting the field {@code currentSpeed=0)*/
    public void stopEngine(){ currentSpeed = 0; }

    /** This method makes the vehicle move by adding dx and dy to the current position point in the coordinate system.
     * dx and dy is calculated by multiplying {@code currentSpeed} with either 1,0 or -1 to make the vehicle to forwards, backwards or no movement in that axis of the 2D Coordinate system.
     * Example would be south where the vehicle goes -1 in dy and 0 in dx.
     * The direction to move in is calculated by doing modulo of 2 to the Compass integers in Interface Movable,then multiply with element of {@code alternatingStatesForDirection}
     * The index of alternatingStatesForDirection is the modulo of 4 to ensure that it forever goes between 0 to 3.
     *
     * */
    public void move() {
        double dx = currentSpeed * (double) ((getCurrentDirection() % 2 * (alternatingStatesForDirection[getCurrentDirection() % 4])));
        double dy = currentSpeed * (double) (((1 + getCurrentDirection() % 2) * (alternatingStatesForDirection[getCurrentDirection() % 4])));
        currentPoint.translate(dx, dy);
    }

    /** This method makes the vehicle turn right by changing the direction to the left by adding 1 to the direction integer and then to keep it within 0 to 3 Modulo of 4 is used.*/
    public void turnLeft(){
        setCurrentDirection((currentDirection+1)%4);
    }

    /** This method makes the vehicle turn right by changing the direction to the left by subtracting 1 to the direction integer and then to keep it within 0 to 3 Modulo of 4 is used.*/
    public void turnRight(){
        setCurrentDirection(((currentDirection-1)+4)%4);
    }


    /** This is to see if a value is in a interval of doubles.*/
    protected boolean acceptableInterval(double value, double lowerValue, double upperValue){
        return value >= lowerValue && value <= upperValue;
    }

    /**
     * Abstract method to enable overriding in subclasses of this particular method
     * @param amount used as an multiplier
     */
    protected abstract void incrementSpeed(double amount);

    /**
     * Abstract method to enable overriding in subclasses of this particular method
     * @param amount used as an multiplier
     */
    protected abstract void decrementSpeed(double amount);

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
