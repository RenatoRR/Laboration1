import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testIncrementSpeedVolvo240 {
    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testAddingAmountAboveEnginePower(){
        while (volvo.getCurrentSpeed() < volvo.getEnginePower()) {
            volvo.incrementSpeed(0.5);
        }
        volvo.incrementSpeed(1);
        Assert.assertTrue(volvo.getCurrentSpeed() <= volvo.getEnginePower());
    }
}
