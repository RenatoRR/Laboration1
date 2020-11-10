/** A Point with type double values across a 2D-coordinate system.
 *
 * {@Version 10 11 2020}
 * {@Author} Renato Roos Radevski*/
public class DoublePoint {
    /** Field for the x- and y-axis as double type. */
    private double x;
    private double y;

    /** Constructor with no arguments which creates a point at origin. */
    public DoublePoint(){
        this.x = 0;
        this.y = 0;
    }

    /** Constructor that takes x and y as arguments to create a point at (x,y) in a 2D-Coordinate system. */
    public DoublePoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    /** Retrieves the value x from the point. */
    public double getX() {
        return x;
    }

    /** Retrieves the value y from the point. */
    public double getY() {
        return y;
    }

    /** Sets the values x and y to new values */
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    /** Moves the point coordinates with the change dx and dy. */
    public void translate(double dx, double dy){
        this.x += dx;
        this.y +=dy;
    }

    /** Retrieve the location of the point as a new point. */
    public DoublePoint getLocation(){
        return new DoublePoint(this.x, this.y);
    }

}
