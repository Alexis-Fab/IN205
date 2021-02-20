package ensta.ships;


public class Battleship extends AbstractShip
{
	public Battleship(String myName, Orientation myOrientation)
	{
		super(myName, 'B', 4, myOrientation);
	}
}