import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testGasVolvo240 {
    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testNegativeAmountChangesSpeed(){
        double testSpeed = volvo.getCurrentSpeed();
        volvo.gas(-0.5);
        Assert.assertEquals(volvo.getCurrentSpeed(), testSpeed, 0.0);
    }

    @Test
    public void testAddingAmountAboveLimit(){
        double testSpeed = volvo.getCurrentSpeed();
        volvo.gas(3);
        Assert.assertEquals(volvo.getCurrentSpeed(), testSpeed, 0.0);
    }
}
