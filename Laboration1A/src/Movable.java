/** An Interface with Compass fields and methods that enable movement.*/

public interface Movable {

    /** Fields that represent directions of a movable object in a 2D system.*/
    int NORTH = 0;
    int WEST = 1;
    int SOUTH = 2;
    int EAST = 3;

    /** An array of integers made in order to make {@code move()} into a single line method.
     * Because south and north, west and east are opposites there is a need to multiply with a multiples in a specific order.*/
    int[] alternatingStatesForDirection = {1,0,-1,0};

    /** Makes the car move when implemented.*/
    void move();

    /** Makes the car turn right when implemented. */
    void turnLeft();

    /** Makes the car turn left when implemented. */
    void turnRight();
}
