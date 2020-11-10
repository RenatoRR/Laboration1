import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDecrementSpeedSaab95 {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }

    @Test
    public void testAddingAmountBelowZero(){
        while (saab.getCurrentSpeed() > 0) {
            saab.decrementSpeed(0.5);
        }
        saab.incrementSpeed(1);
        Assert.assertTrue(saab.getCurrentSpeed() >= 0);
    }

    @Test
    public void testUsingWithTurbo(){
        saab.setTurboOff();
        double preSpeedFactor = saab.speedFactor();
        saab.setTurboOn();
        double postSpeedFactor = saab.speedFactor();
        Assert.assertTrue(preSpeedFactor < postSpeedFactor);
    }

}
