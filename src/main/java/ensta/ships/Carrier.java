package ensta.ships;


public class Carrier extends AbstractShip
{
	public Carrier() {
		super("default", 'C', 5, Orientation.NORTH);
	}

	public Carrier(String myName, Orientation myOrientation)
	{
		super(myName, 'C', 5, myOrientation);
	}
}