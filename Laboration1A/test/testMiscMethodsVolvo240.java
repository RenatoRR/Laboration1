import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class testMiscMethodsVolvo240 {
    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testSetColorAndGetColor(){
        Color beforeColor = volvo.getColor();
        volvo.setColor(Color.pink);
        Color afterColor = volvo.getColor();
        Assert.assertFalse(beforeColor.equals(afterColor));
    }

    @Test
    public void testGetNrDoors(){
        int nrDoors = volvo.getNrDoors();
        Assert.assertEquals(4, nrDoors);
    }

}
