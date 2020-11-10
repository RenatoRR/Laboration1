import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testIncrementSpeedSaab95 {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }


    @Test
    public void testAddingAmountAboveEnginePower(){
        while (saab.getCurrentSpeed() < saab.getEnginePower()) {
            saab.incrementSpeed(0.5);
        }
        saab.incrementSpeed(1);
        Assert.assertTrue(saab.getCurrentSpeed() <= saab.getEnginePower());
    }

    @Test
    public void testUsingWithTurboOn(){
        saab.setTurboOff();
        double preSpeedFactor = saab.speedFactor();
        saab.setTurboOn();
        double postSpeedFactor = saab.speedFactor();
        Assert.assertTrue(preSpeedFactor < postSpeedFactor);
    }



}
