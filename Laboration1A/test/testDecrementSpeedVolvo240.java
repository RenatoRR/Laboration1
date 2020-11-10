import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDecrementSpeedVolvo240 {
    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testAddingAmountBelowZero(){
        while (volvo.getCurrentSpeed() > 0) {
            volvo.decrementSpeed(0.5);
        }
        volvo.incrementSpeed(1);
        Assert.assertTrue(volvo.getCurrentSpeed() >= 0);
    }

}
