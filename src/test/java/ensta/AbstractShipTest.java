package ensta;
import ensta.ships.*;
import static junit.framework.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
*/
/**
 * Unit test for simple App.
 */
public class AbstractShipTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
      public AbstractShipTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
/*    public static Test suite()
    {
        return new TestSuite( AbstractShipTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        AbstractShip ShipTest = new AbstractShip("ShipTest", 'D', 2, Orientation.WEST);
        assertEquals(2, ShipTest.getLength());
        System.out.println("AbstractShip.getLength is operational");
        assertEquals(Orientation.WEST, ShipTest.getOrientation());
        System.out.println("AbstractShip.getOrientation is operational");
        ShipTest.setOrientation(Orientation.NORTH);
        assertEquals(Orientation.NORTH, ShipTest.getOrientation());
        System.out.println("AbstractShip.setOrientation is operational");
    }
}
