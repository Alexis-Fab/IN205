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
     * Rigourous Test :-)
     */
    @Test
    public void testGetterSetter()
    {
        AbstractShip shipTest = new AbstractShip("ShipTest", 'D', 2, Orientation.WEST);
        assertEquals(2, shipTest.getLength());
        System.out.println("AbstractShip.getLength is operational");
        assertEquals(Orientation.WEST, shipTest.getOrientation());
        System.out.println("AbstractShip.getOrientation is operational");
        shipTest.setOrientation(Orientation.NORTH);
        assertEquals(Orientation.NORTH, shipTest.getOrientation());
        System.out.println("AbstractShip.setOrientation is operational");
    }

    @Test
    public void testShipsTypes() {
        AbstractShip ship = new Destroyer();
        assertEquals(ship.getLength(), 2);
        ship = new Submarine();
        assertEquals(ship.getLength(), 3);
        ship = new Battleship();
        assertEquals(ship.getLength(), 4);
        ship = new Carrier();
        assertEquals(ship.getLength(), 5);
        System.out.println("Ship types have their lengths well initialized");
    }
}
