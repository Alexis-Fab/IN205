package ensta;
import ensta.ships.*;
import java.io.Serializable;
import java.util.List;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getLength());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            // TODO set ship orientation
            switch (res.orientation)
            {
                case("n"): {
                    s.setOrientation(Orientation.NORTH);
                    break;
                }
                case("s"): {
                    s.setOrientation(Orientation.SOUTH);
                    break;
                }
                case("e"): {
                    s.setOrientation(Orientation.EAST);
                    break;
                }
                case("w"): {
                    s.setOrientation(Orientation.WEST);
                    break;
                }
            }
            // TODO put ship at given position
            try {
                board.putShip(s, res.x, res.y);
                ++i;
            }
            catch (Exception e) {
                System.out.println("Veuillez de nouveau " + msg);
            }

            done = i == this.board.getNbShips(); // I should adapt it to meet ship number

            board.print();
        } while (!done);
    }

    /**
    * @param coords save the coordonates of the hit
    * @return the value of the hit. Useful to know whether it was succesful and to print the result 
    */
    public Hit sendHit(int[] coords) {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("Où frapper ?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            if (hitInput.x >= 0 && hitInput.x < this.board.getSize() && hitInput.y >= 0 && hitInput.y < this.board.getSize()) {

                if (this.board.getHit(hitInput.x, hitInput.y) == null) {

                    hit = this.opponentBoard.sendHit(hitInput.x, hitInput.y);
                    if (hit != Hit.MISS) {
                        this.board.setHit(true, hitInput.x, hitInput.y);
                        done = true;
                    }
                    else {
                        this.board.setHit(false, hitInput.x, hitInput.y);
                        done = true;
                    }
                    coords[0] = hitInput.x;
                    coords[1] = hitInput.y;
                }
                else {
                    System.out.println("Vous avez déjà tiré ici !");
                }
            }
                else 
                    System.out.println("Veuillez frapper dans la grille");

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);

//        this.board.print();
//        System.out.println(hit);
        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
