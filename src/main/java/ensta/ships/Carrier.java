package ensta.ships;


public class Carrier extends AbstractShip
{
	public Carrier(String myName, Orientation myOrientation)
	{
		super(myName, 'C', 5, myOrientation);
	}
}