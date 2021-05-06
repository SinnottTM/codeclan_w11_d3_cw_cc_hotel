import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Guest guest1;
    private Guest guest2;

    @Before
    public void before(){
        guest1 = new Guest("Tim");
        guest2 = new Guest("Piotr");
    }

    @Test
    public void hasName(){
        assertEquals("Tim", guest1.getName());
    }

    @Test
    public void canSetName(){
        guest1.setName("Timothy Sinnott");
        assertEquals("Timothy Sinnott", guest1.getName());
    }
}
