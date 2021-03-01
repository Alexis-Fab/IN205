package ensta;
import ensta.ships.*;
import static junit.framework.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlayerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
      public PlayerTest( String testName )
    {
        super( testName );
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testPlayer()
    {
      AbstractShip Nav1 = new Destroyer("Nav1", Orientation.EAST);
      AbstractShip Nav2 = new Battleship("Nav2", Orientation.EAST);
      AbstractShip Nav3 = new Submarine("Nav3", Orientation.EAST);
      AbstractShip Nav4 = new Submarine("Nav4", Orientation.EAST);
      AbstractShip Nav5 = new Carrier("Nav5", Orientation.EAST);
      AbstractShip[] shipsArray = {Nav1, Nav2, Nav3, Nav4, Nav5};

      Board board = new Board("Test");

//      Player player = new Player(board, board, shipsArray);
    }


}
