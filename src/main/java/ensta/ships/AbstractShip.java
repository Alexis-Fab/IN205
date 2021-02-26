package ensta.ships;
import ensta.ships.Orientation;

public class AbstractShip
{
	private char label;
	private String name;
	private int length;
	private int strikeCount = 0;
	
	private Orientation orientation;

	public int getStrikeCount() {return strikeCount ;}
	public char getLabel() {return label ;}
//	public void setLabel(char myLabel) {label = myLabel;}
	public String getName() {return name ;}
//	public void setName(String myName) {name = myName ;}
	public int getLength() {return length ;}
//	public void setSize(int mySize) {size = mySize ;}
	public Orientation getOrientation() {return orientation ;}
	public void setOrientation(Orientation myOrientation) {orientation = myOrientation ;}

	public void addStrike() {
		this.strikeCount++;
	}
	public boolean isSunk() {
		return(this.getStrikeCount() >= this.getLength());
	}

	public AbstractShip(String myName, char myLabel, int myLength, Orientation myOrientation)
	{
		name = myName; label = myLabel; length = myLength; orientation = myOrientation;
	}
}
