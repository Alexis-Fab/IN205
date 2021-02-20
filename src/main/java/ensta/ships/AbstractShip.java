package ensta.ships;
import ensta.ships.Orientation;

public class AbstractShip
{
	private char label;
	private String name;
	private int size;
	
	private Orientation orientation;

	public char getLabel() {return label ;}
//	public void setLabel(char myLabel) {label = myLabel;}
	public String getName() {return name ;}
//	public void setName(String myName) {name = myName ;}
	public int getSize() {return size ;}
//	public void setSize(int mySize) {size = mySize ;}
	public Orientation getOrientation() {return orientation ;}
	public void setOrientation(Orientation myOrientation) {orientation = myOrientation ;}

	public AbstractShip(String myName, char myLabel, int mySize, Orientation myOrientation)
	{
		name = myName; label = myLabel; size = mySize; orientation = myOrientation;
	}
}
