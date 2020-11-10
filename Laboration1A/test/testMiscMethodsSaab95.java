import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class testMiscMethodsSaab95 {
    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
    }

    @Test
    public void testSetColorAndGetColor(){
        Color beforeColor = saab.getColor();
        saab.setColor(Color.magenta);
        Color afterColor = saab.getColor();
        Assert.assertFalse(beforeColor.equals(afterColor));
    }

    @Test
    public void testGetNrDoors(){
        int nrDoors = saab.getNrDoors();
        Assert.assertEquals(2, nrDoors);
    }

}
