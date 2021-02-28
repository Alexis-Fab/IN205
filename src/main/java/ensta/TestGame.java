package ensta;
import ensta.ships.*;
import java.util.*;

public class TestGame {
	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Board board1 = new Board("Board Of AI 1", 10);
		Board board2 = new Board("Board Of AI 2", 10);
		BattleShipsAI ai1 = new BattleShipsAI(board1, board1);
		BattleShipsAI ai2 = new BattleShipsAI(board2, board1);


		AbstractShip Nav1 = new Destroyer("Nav1", Orientation.EAST);
		AbstractShip Nav2 = new Battleship("Nav2", Orientation.EAST);
		AbstractShip Nav3 = new Submarine("Nav3", Orientation.EAST);
		AbstractShip Nav4 = new Submarine("Nav4", Orientation.EAST);
		AbstractShip Nav5 = new Carrier("Nav5", Orientation.EAST);

		AbstractShip[] shipsArray = {Nav1, Nav2, Nav3, Nav4, Nav5};

		ai1.putShips(shipsArray);
		ai1.printBoard();
		ai2.putShips(shipsArray);
//		ai2.printBoard();

		int destroyedCount = 0;

		while(destroyedCount < 5) {
			int[] coords = {0,0};
			Hit lastHit = ai1.sendHit(coords);
//			System.out.println(coords[0]);
//			System.out.println(coords[1]);
			ai1.printBoard();
			System.out.println(lastHit);
//			System.out.println(shipsArray[1].isSunk());
			if (lastHit.getValue() > 0) {
				destroyedCount++;
			}
			if (destroyedCount == 5)
				System.out.println("Every ship has been destroyed");
			else
				System.out.println("Not every ship has been destroyed, continue");
			System.out.println("destroyedCount : " + destroyedCount);
			sleep(800);
		}
		System.out.println("Fin de la partie test !");
	}
}