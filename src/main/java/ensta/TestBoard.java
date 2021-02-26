package ensta;
import ensta.ships.*;
import java.util.*;

public class TestBoard
{
	public static void main(String[] args)
	{
		Board myBoard = new Board("Test1", 10);
		AbstractShip Kamikaze = new AbstractShip("Kamikaze", 'D', 2, Orientation.NORTH);
//		myBoard.putShip(Kamikaze, 4, 5);
		AbstractShip Kam2 = new Battleship("Kam2", Orientation.WEST);
		try {
			myBoard.putShip(Kam2, 6, 10);
//			System.out.println("succesful placement");
		}
		catch (Exception e) {System.out.println("placement failed");}
		AbstractShip Kam3 = new Carrier("Kam3", Orientation.EAST);
//		myBoard.putShip(Kam3, 8, 10);
		AbstractShip Kam4 = new Submarine("Kam4", Orientation.SOUTH);
//		myBoard.putShip(Kam4, 3, 6);
		AbstractShip Kam5 = new Destroyer("Kam5", Orientation.EAST);
//		myBoard.putShip(Kam5, 2, 1);
		myBoard.setHit(true, 5, 1);
		myBoard.setHit(false, 8, 6);
//		myBoard.print();
		List<AbstractShip> ships = new ArrayList<>();
		ships.add(Kamikaze);
		ships.add(Kam2);
		ships.add(Kam3);
		ships.add(Kam4);
		ships.add(Kam5);

		Board emptyBoard = new Board("Empty", 10);
		Player user1 = new Player(emptyBoard, myBoard, ships);


		user1.putShips();

	}
};