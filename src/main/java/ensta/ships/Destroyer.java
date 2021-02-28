package ensta.ships;


public class Destroyer extends AbstractShip
{
	public Destroyer() {
		super("default", 'D', 2, Orientation.NORTH);
	}

	public Destroyer(String myName, Orientation myOrientation)
	{
		super(myName, 'D', 2, myOrientation);
	}
}