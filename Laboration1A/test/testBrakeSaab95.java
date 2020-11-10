import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBrakeSaab95 {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }
    @Test
    public void testNegativeAmountChangesSpeed(){
        double testSpeed = saab.getCurrentSpeed();
        saab.brake(-0.5);
        Assert.assertEquals(testSpeed,saab.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testAddingAmountAboveLimit(){
        double testSpeed = saab.getCurrentSpeed();
        saab.brake(2);
        Assert.assertEquals(testSpeed,saab.getCurrentSpeed(), 0.0);
    }
}
