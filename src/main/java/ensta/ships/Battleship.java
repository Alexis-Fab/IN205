package ensta.ships;


public class Battleship extends AbstractShip
{
	public Battleship() {
		super("default", 'B', 4, Orientation.NORTH);
	}

	public Battleship(String myName, Orientation myOrientation)
	{
		super(myName, 'B', 4, myOrientation);
	}
}