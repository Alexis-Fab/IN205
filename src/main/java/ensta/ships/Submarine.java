package ensta.ships;


public class Submarine extends AbstractShip
{
	public Submarine() {
		super("default", 'S', 3, Orientation.NORTH);
	}
	public Submarine(String myName, Orientation myOrientation)
	{
		super(myName, 'S', 3, myOrientation);
	}
}