import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testMovementSaab95 {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }

    @Test
    public void testMovementForward(){
        DoublePoint preMovementPoint = saab.getCurrentPoint().getLocation();
        saab.startEngine();
        saab.move();
        Assert.assertFalse(preMovementPoint.equals(saab.getCurrentPoint()));
    }

    @Test
    public void testTurnRight(){
        saab.setCurrentDirection(saab.NORTH);
        for (int i = 3; i >=0; i--){
            saab.turnRight();
            Assert.assertTrue(saab.getCurrentDirection() == i);
        }
    }

    @Test
    public void testTurnLeft(){
        saab.setCurrentDirection(saab.NORTH);
        for (int i = 1; i >=3; i++){
            saab.turnLeft();
            Assert.assertTrue(saab.getCurrentDirection() == i);
        }
    }
}

