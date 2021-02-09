package ensta;


public class Board {
	public String name;
	private int boardSize = 10;
	private int nbShips = 5;
	private char[][] ships = new char[boardSize][boardSize];
	private boolean[][] strikes = new boolean[boardSize][boardSize];

	public Board(String myName, int myBoardSize) {name = myName; boardSize = myBoardSize;}
	public Board(String myName) {name = myName;}

	public int getNbShips() { return(nbShips) ;}
	public void setNbShips(int nb) { nbShips = nb ;}
	public int getBoardSize() { return boardSize ;}
	public void setBoardSize(int size) { boardSize = size ;}

	private String printLine(int i)
	{
		String res = "";
		if (i<10)
			{ res = Integer.toString(i) + "  "; }
		else
			{ res = Integer.toString(i) + " "; }

		for (int j = 0; j < this.boardSize; j++)
		{ res = res + ". " ;}

		res = res + "    ";

		if (i<10)
			{ res = res + Integer.toString(i) + "  "; }
		else
			{ res = res + Integer.toString(i) + " "; }

		for (int j = 0; j < this.boardSize; j++)
		{ res = res + ". " ;}

		return(res);
	}
	public void print() {
		System.out.println("Navires :                  Frappes :");
		System.out.println("   A B C D E F G H I J        A B C D E F G H I J");
		System.out.println(printLine(1));
		System.out.println(printLine(2));
		System.out.println(printLine(3));
		System.out.println(printLine(4));
		System.out.println(printLine(5));
		System.out.println(printLine(6));
		System.out.println(printLine(7));
		System.out.println(printLine(8));
		System.out.println(printLine(9));
		System.out.println(printLine(10));
		
	}
}