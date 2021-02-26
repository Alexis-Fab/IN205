package ensta;
import ensta.ships.*;

class Board implements IBoard {
	public String name;
	private int boardSize = 10;
	private int nbShips = 5;
	private ShipState[][] ships = new ShipState[boardSize][boardSize];
	private Boolean[][] strikes = new Boolean[boardSize][boardSize];

	public Board(String myName, int myBoardSize) {name = myName; this.boardSize = myBoardSize;
		ships = new ShipState[boardSize][boardSize]; strikes = new Boolean[boardSize][boardSize];}
	public Board(String myName) {name = myName;}

	public int getNbShips() { return(nbShips) ;}
	public void setNbShips(int nb) { nbShips = nb ;}
	public int getSize() { return boardSize ;}
	public void setSize(int size) { boardSize = size ;}

	public void putShip(AbstractShip ship, int x, int y) throws Exception
	{
		boolean worked = false;
		if (x<=0 || y<=0 || x>this.boardSize || y>this.boardSize)
			System.out.println("Votre navire ne peut pas être placé ici.\nVeuillez entrez des coordonnées comprises entre 1 et " + this.boardSize);
		else {
			boolean spaceAvailable = true;
			switch(ship.getOrientation()) {
				case NORTH:
					if (x-ship.getLength() < 0)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par le haut, placez le plus bas.");
						System.out.println("Pour rappel, la grille est de hauteur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getLength(); i++)
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
					else {
						for(int i=0; i < ship.getLength(); i++) {
							(this.ships[x-i-1][y-1]) = new ShipState(ship);
						}
						worked = true;
					}
					break;
				case WEST:
					if (y-ship.getLength() < 0)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par la gauche, placez le plus à droite.");
						System.out.println("Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getLength(); i++)
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
					else {
						for (int i=0; i < ship.getLength(); i++)
							this.ships[x-1][y-i-1] = new ShipState(ship);
						worked = true;
					}
					break;
				case SOUTH:
					if (x+ship.getLength()-1 > this.boardSize)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par le bas, placez le plus haut.");
						System.out.println("Pour rappel, la grille est de hauteur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getLength(); i++)
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
					else {
						for (int i=0; i < ship.getLength(); i++)
							this.ships[x+i-1][y-1] = new ShipState(ship);
						worked = true;
					}
					break;
				case EAST:
					if (y+ship.getLength()-1 > this.boardSize)
					{
						System.out.println("Votre navire " + ship.getName() + " dépasse de la grille par la droite, placez le plus à gauche.");
						System.out.println("Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
						break;
					}
					for (int i=0; i < ship.getLength(); i++)
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
					else {
						for (int i=0; i < ship.getLength(); i++)
							this.ships[x-1][y+i-1] = new ShipState(ship);
						worked = true;
					}
					break;
			}
		}
		if (!worked) {
			System.out.println("Placement failed");
			throw new Exception("Ship couldn't be placed");
		}
	}

	public boolean hasShip(int x, int y)
	{
		return (ships[x-1][y-1] != null);
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

		for (int y = 1; y <= this.boardSize; y++)
		{
//			System.out.println(ships[x-1][y-1]);
			if (ships[x-1][y-1] == null)
				res = res + ". ";
			else
				res = res + ships[x-1][y-1] + " ";
		}

		res = res + "    ";

		if (x<10)
			{ res = res + Integer.toString(x) + "  " ;}
		else
			{ res = res + Integer.toString(x) + " " ;}

		for (int y = 1; y <= this.boardSize; y++) {
				if (this.strikes[x-1][y-1] == null)
					res = res + ". " ;
				else if (this.strikes[x-1][y-1])
					res = res + ColorUtil.colorize("X ", Color.RED) ;
				else
					res = res + "X " ;
			}

		return(res);
	}
	public void print() {
		System.out.println("Navires :  " + "  ".repeat(this.getSize()-2) + "Frappes :");
		String abscisse = "   ";
		for (int i=0; i < this.getSize(); i++)
		{
			char c = (char) (65 + i);
			abscisse += c + " ";	
		}
		abscisse = abscisse + "    " + abscisse;
		System.out.println(abscisse);
		for (int i = 1; i <= this.getSize(); i++)
			System.out.println(printLine(i));
	}
}