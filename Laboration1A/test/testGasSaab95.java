import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testGasSaab95 {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }

    @Test
    public void testNegativeAmountChangesSpeed(){
        double testSpeed = saab.getCurrentSpeed();
        saab.gas(-0.5);
        Assert.assertEquals(saab.getCurrentSpeed(), testSpeed, 0.0);
    }

    @Test
    public void testAddingAmountAboveLimit(){ //may not be needed for this test but Gas/brake test instead.
        double testSpeed = saab.getCurrentSpeed();
        saab.gas(3);
        Assert.assertEquals(saab.getCurrentSpeed(), testSpeed, 0.0);
    }
}
