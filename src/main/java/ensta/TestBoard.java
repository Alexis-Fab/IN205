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
			myBoard.putShip(Kam2, 5, 9);
//			System.out.println("succesful placement");
		}
		catch (Exception e) {System.out.println("placement failed");}
		AbstractShip Kam3 = new Carrier("Kam3", Orientation.EAST);
//		myBoard.putShip(Kam3, 8, 10);
		AbstractShip Kam4 = new Submarine("Kam4", Orientation.SOUTH);
//		myBoard.putShip(Kam4, 3, 6);
		AbstractShip Kam5 = new Destroyer("Kam5", Orientation.EAST);
//		myBoard.putShip(Kam5, 2, 1);
		myBoard.setHit(true, 4, 0);
		myBoard.setHit(false, 7, 5);
		myBoard.print();
		List<AbstractShip> ships = new ArrayList<>();
		ships.add(Kamikaze);
		ships.add(Kam2);
		ships.add(Kam3);
		ships.add(Kam4);
		ships.add(Kam5);
		AbstractShip[] shipsArray = {Kamikaze, Kam2, Kam3, Kam4, Kam5};

		Board emptyBoard = new Board("Empty", 10);
		Player user1 = new Player(emptyBoard, myBoard, ships);
		BattleShipsAI ai1 = new BattleShipsAI(emptyBoard, emptyBoard);
		ai1.printBoard();
//		ai1.opponent.print();

		ai1.putShips(shipsArray);

		ai1.printBoard();

		for (int i=0; i<5; i++) {
			System.out.println("tir n° " + i);
			user1.sendHit();
//			System.out.println(user1.opponentBoard.ships[5][6]);
			if (user1.opponentBoard.ships[4][5] != null) {
//				System.out.println(user1.opponentBoard.ships[5][6].isStruck());
				System.out.println(user1.opponentBoard.ships[4][5].isSunk());
			}
			System.out.println(user1.opponentBoard.hasShip(5,6));
		}


		user1.putShips();

	}
};