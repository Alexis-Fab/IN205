package ensta.ships;


public class Destroyer extends AbstractShip
{
	public Destroyer(String myName, Orientation myOrientation)
	{
		super(myName, 'D', 2, myOrientation);
	}
}