package ensta;
import ensta.ships.*;

class Board implements IBoard {
	public String name;
	private int boardSize = 10;
	private int nbShips = 5;
	private char[][] ships = new char[boardSize][boardSize];
	private boolean[][] strikes = new boolean[boardSize][boardSize];

	public Board(String myName, int myBoardSize) {name = myName; boardSize = myBoardSize;}
	public Board(String myName) {name = myName;}

	public int getNbShips() { return(nbShips) ;}
	public void setNbShips(int nb) { nbShips = nb ;}
	public int getSize() { return boardSize ;}
	public void setSize(int size) { boardSize = size ;}

	public void putShip(AbstractShip ship, int x, int y)
	{
		if (x<=0 || y<=0 || x>this.boardSize || y>this.boardSize)
			System.out.println("Votre navire ne peut pas être placé ici.\nVeuillez entrez des coordonnées comprises entre 1 et " + this.boardSize);
		else {
			boolean spaceAvailable = true;
			switch(ship.getOrientation()) {
				case NORTH:
					if (x-ship.getSize() <= 0)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par le haut, placez le plus bas.");
						System.out.println("Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getSize(); i++)
						{
							if (this.hasShip(x-i,y))
							{
								spaceAvailable = false;
								break;
							}
						}
					if (!spaceAvailable)
					{
						System.out.println("La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else
						for(int i=0; i < ship.getSize(); i++)
							this.ships[x-i-1][y-1] = ship.getLabel();
					break;
				case WEST:
					if (y-ship.getSize() <= 0)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par la gauche, placez le plus à droite.");
						System.out.println("Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getSize(); i++)
						{
							if (this.hasShip(x,y-i))
							{
								spaceAvailable = false;
								break;
							}
						}
					if (!spaceAvailable)
					{
						System.out.println("La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else
						for (int i=0; i < ship.getSize(); i++)
							this.ships[x-1][y-i-1] = ship.getLabel();
					break;
				case SOUTH:
					if (x+ship.getSize() > this.boardSize)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par le bas, placez le plus haut.");
						System.out.println("Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getSize(); i++)
						{
							if (this.hasShip(x+i,y))
							{
								spaceAvailable = false;
								break;
							}
						}
					if (!spaceAvailable)
					{
						System.out.println("La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else
						for (int i=0; i < ship.getSize(); i++)
							this.ships[x+i-1][y-1] = ship.getLabel();
					break;
				case EAST:
					if (y+ship.getSize() > this.boardSize)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par la droite, placez le plus à gauche.");
						System.out.println("Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getSize(); i++)
						{
							if (this.hasShip(x,y+i))
							{
								spaceAvailable = false;
								break;
							}
						}
					if (!spaceAvailable)
					{
						System.out.println("La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else
						for (int i=0; i < ship.getSize(); i++)
							this.ships[x-1][y+i-1] = ship.getLabel();
					break;
			}
		}
	}

	public boolean hasShip(int x, int y)
	{
		return (ships[x-1][y-1] != '\u0000');
	}

	public void setHit(boolean hit, int x, int y)
	{
			strikes[x-1][y-1] = hit;
	}

	public Boolean getHit(int x, int y)
	{
		return ( strikes[x-1][y-1]);
	}

	private String printLine(int x)
	{
		String res = "";
		if (x<10)
			{ res = Integer.toString(x) + "  "; }
		else
			{ res = Integer.toString(x) + " "; }

		for (int y = 0; y < this.boardSize; y++)
		{
			if (ships[x-1][y] == '\u0000')
				res = res + ". ";
			else
				res = res + ships[x-1][y] + " ";
		}

		res = res + "    ";

		if (x<10)
			{ res = res + Integer.toString(x) + "  "; }
		else
			{ res = res + Integer.toString(x) + " "; }

		for (int y = 0; y < this.boardSize; y++)
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