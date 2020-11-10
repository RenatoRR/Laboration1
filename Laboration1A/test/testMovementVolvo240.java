import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class testMovementVolvo240 {
    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testMovementForward(){
        DoublePoint preMovementPoint = volvo.getCurrentPoint().getLocation();
        volvo.startEngine();
        volvo.move();
        Assert.assertFalse(preMovementPoint.equals(volvo.getCurrentPoint()));
    }

    @Test
    public void testTurnRight(){
        volvo.setCurrentDirection(volvo.NORTH);
        for (int i = 3; i >=0; i--){
            volvo.turnRight();
            Assert.assertTrue(volvo.getCurrentDirection() == i);
        }
    }

    @Test
    public void testTurnLeft(){
        volvo.setCurrentDirection(volvo.NORTH);
        for (int i = 1; i >=3; i++){
            volvo.turnLeft();
            Assert.assertTrue(volvo.getCurrentDirection() == i);
        }
    }
}
