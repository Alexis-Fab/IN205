package ensta;
import ensta.ships.*;

public class TestBoard
{
	public static void main(String[] args)
	{
		Board myBoard = new Board("Test1");
		AbstractShip Kamikaze = new AbstractShip("Kamikaze", 'D', 2, Orientation.NORTH);
		myBoard.putShip(Kamikaze, 4, 5);
		AbstractShip Kam2 = new Battleship("Kam2", Orientation.WEST);
		myBoard.putShip(Kam2, 6, 10);
		AbstractShip Kam3 = new Carrier("Kam3", Orientation.EAST);
		myBoard.putShip(Kam3, 8, 10);
		AbstractShip Kam4 = new Submarine("Kam4", Orientation.SOUTH);
		myBoard.putShip(Kam4, 3, 6);
		AbstractShip Kam5 = new Destroyer("Kam5", Orientation.EAST);
		myBoard.putShip(Kam5, 2, 1);
		myBoard.print();
	}
};