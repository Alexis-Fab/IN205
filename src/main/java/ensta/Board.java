package ensta;
import ensta.ships.*;

class Board implements IBoard {
	private String name;
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
	public String getName() { return name ;}
	public void setName(String myName) { name = myName ;}

	/**
	* Print a message on the console
	* @param isForHuman permits to do not print when the ai use the method putShip
	* @param msg
	*/
	private void printHelp(boolean isForHuman, String msg) {
		if (isForHuman)
			System.out.println(msg);
	}
	public void putShip(AbstractShip ship, int x, int y) throws Exception {
		putShip(ship, x, y, true);
	}
	
	public void putShip(AbstractShip ship, int x, int y, boolean isForHuman) throws Exception
	{
		boolean worked = false;
		if (x<0 || y<0 || x>=this.boardSize || y>=this.boardSize)
			printHelp(isForHuman, "Votre navire ne peut pas être placé ici.\nVeuillez entrez des coordonnées comprises entre 1 et " + this.boardSize);
		else {
			boolean spaceAvailable = true;
			switch(ship.getOrientation()) {
				case NORTH:
					if (x-ship.getLength()+1 < 0)
					{
						printHelp(isForHuman, "Votre navire " + ship.getName() + " dépasse de la grille par le haut, placez le plus bas.");
						printHelp(isForHuman, "Pour rappel, la grille est de hauteur " + this.boardSize + " cases.");
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
						printHelp(isForHuman, "La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else {
						for(int i=0; i < ship.getLength(); i++) {
							(this.ships[x-i][y]) = new ShipState(ship);
						}
						worked = true;
					}
					break;
				case WEST:
					if (y-ship.getLength()+1 < 0)
					{
						printHelp(isForHuman, "Votre navire " + ship.getName() + " dépasse de la grille par la gauche, placez le plus à droite.");
						printHelp(isForHuman, "Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
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
						printHelp(isForHuman, "La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else {
						for (int i=0; i < ship.getLength(); i++)
							this.ships[x][y-i] = new ShipState(ship);
						worked = true;
					}
					break;
				case SOUTH:
					if (x+ship.getLength()-1 >= this.boardSize)
					{
						printHelp(isForHuman, "Votre navire " + ship.getName() + " dépasse de la grille par le bas, placez le plus haut.");
						printHelp(isForHuman, "Pour rappel, la grille est de hauteur " + this.boardSize + " cases.");
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
						printHelp(isForHuman, "La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else {
						for (int i=0; i < ship.getLength(); i++)
							this.ships[x+i][y] = new ShipState(ship);
						worked = true;
					}
					break;
				case EAST:
					if (y+ship.getLength()-1 >= this.boardSize)
					{
						printHelp(isForHuman, "Votre navire " + ship.getName() + " dépasse de la grille par la droite, placez le plus à gauche.");
						printHelp(isForHuman, "Pour rappel, la grille est de largeur " + this.boardSize + " cases.");
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
						printHelp(isForHuman, "La place n'est pas libre pour " + ship.getName() + ", placez votre navire ailleurs.");
						break;
					}
					else {
						for (int i=0; i < ship.getLength(); i++)
							this.ships[x][y+i] = new ShipState(ship);
						worked = true;
					}
					break;
			}
		}
		if (!worked) {
			printHelp(isForHuman, "Placement failed");
			throw new Exception("Ship couldn't be placed");
		}
	}

	public boolean hasShip(int x, int y)
	{
		return (ships[x][y] != null && !ships[x][y].isSunk());
	}

	public void setHit(boolean hit, int x, int y)
	{
			strikes[x][y] = hit;
	}

	public Boolean getHit(int x, int y)
	{
		return ( strikes[x][y]);
	}

	public Hit sendHit(int x, int y) {
		if (this.ships[x][y] == null)
			return(Hit.MISS);
		else {
			this.ships[x][y].addStrike();
			if (this.ships[x][y].isSunk())
				switch(this.ships[x][y].getShip().getLabel()) {
					case('D'):
						return Hit.DESTROYER;
					case('S'):
						return Hit.SUBMARINE;
					case('B'):
						return Hit.BATTLESHIP;
					case('C'):
						return Hit.CARRIER;
				}
			return(Hit.STRIKE);
		}
	}


    /** Auxiliary function that prints a single line
    *@param i the numbre of the line
    * @return a string that contains the whole line for both own board and opponent board 
    */

	private String printLine(int i)
	{
		String res = "";
		if (i<10)
			{ res = Integer.toString(i) + "  "; }
		else
			{ res = Integer.toString(i) + " "; }

		for (int y = 0; y < this.boardSize; y++)
		{
			if (ships[i-1][y] == null)
				res = res + ". ";
			else
				res = res + ships[i-1][y] + " ";
		}

		res = res + "    ";

		if (i<10)
			{ res = res + Integer.toString(i) + "  " ;}
		else
			{ res = res + Integer.toString(i) + " " ;}

		for (int y = 0; y < this.boardSize; y++) {
				if (this.strikes[i-1][y] == null)
					res = res + ". " ;
				else if (this.strikes[i-1][y])
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