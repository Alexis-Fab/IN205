package ensta;
import ensta.ships.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
    
public class Game {

    /* ***
     * Constante
     */
    public static final File SAVE_FILE = new File("savegame.dat");

    /* ***
     * Attributs
     */
    private Player humanPlayer;
    private AIPlayer aiPlayer;
    private Scanner sin = new Scanner(System.in);
    private String playerName;

    /* ***
     * Constructeurs
     */
    public Game() {}

    public Game init() {
        if (!loadSave()) {
            // init attributes
            System.out.println("Entre ton nom : ");

            // TODO use a scanner to read player name
            playerName = sin.nextLine();

            System.out.println("Entre la taille de grille : ");
            int boardSize = sin.nextInt();

            // TODO init boards
            Board b1 = new Board("Board1", boardSize), b2 = new Board("Board2", boardSize);

            // TODO init this.player1 & this.player2
            humanPlayer = new Player(b1, b2, createDefaultShips());
            aiPlayer = new AIPlayer(b2, b1, createDefaultShips());

            b1.print();
            // place player ships
            humanPlayer.putShips();
            aiPlayer.putShips();
        }
        return this;
    }

    /* ***
     * Méthodes
     */
    public void run() {
        int[] coords = new int[2];
        Board b1 = humanPlayer.board;
        Hit hit;

        // main loop
        b1.print();
        boolean done;
        do {
            hit = humanPlayer.sendHit(coords);
            boolean strike = hit != Hit.MISS; // TODO player1 send a hit
//          b1.setHit(strike, coords[1], coords[0]); // TODO set this hit on his board (b1)
            // setHit already included in sendHit
            done = updateScore();
            b1.print();
            System.out.println(makeHitMessage(false /* outgoing hit */, coords, hit));

            save();

            if (!done && !strike) {
                do {
                    hit = aiPlayer.sendHit(coords); // TODO player2 send a hit.
                    strike = hit != Hit.MISS;
//                  b2.setHit(strike, coords[1], coords[0]);
                    // setHit is included in sendHit
                    if (strike) {
                        b1.print();
                    }
                    System.out.println(makeHitMessage(true /* incoming hit */, coords, hit));
                    done = updateScore();

                    if (!done) {
                        save();
                    }
                } while(strike && !done);
            }

        } while (!done);

        SAVE_FILE.delete();
        if (humanPlayer.lose)
            System.out.println("Vous avez perdu, mais peut-on vraiment rivaliser avec les machines ?");
        else
            System.out.println("Vous avez gagné ! Félicitations !");
//        System.out.println(String.format("joueur %d gagne", humanPlayer.lose ? 2 : 1));
        sin.close();
    }


    private void save() {
/*        try {
            // TODO bonus 2 : uncomment
            //  if (!SAVE_FILE.exists()) {
            //      SAVE_FILE.getAbsoluteFile().getParentFile().mkdirs();
            //  }

            // TODO bonus 2 : serialize players

        } catch (IOException e) {
            e.printStackTrace();
        }
*/    }

    private boolean loadSave() {
/*        if (SAVE_FILE.exists()) {
            try {
                // TODO bonus 2 : deserialize players

                return true;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } */
        return false;
    }

    private boolean updateScore() {
        for (Player player : new Player[]{humanPlayer, aiPlayer}) {
            int destroyed = 0;
            for (AbstractShip ship : player.getShips()) {
                if (ship.isSunk()) {
                    destroyed++;
                }
            }

            player.destroyedCount = destroyed;
            player.lose = destroyed == player.getShips().length;
            if (player.lose) {
                return true;
            }
        }
        return false;
    }

    private String makeHitMessage(boolean incoming, int[] coords, Hit hit) {
        String msg;
        Color color = Color.RESET;
        switch (hit) {
            case MISS:
                msg = hit.toString();
                break;
            case STRIKE:
                msg = hit.toString();
                color = Color.RED;
                break;
            default:
                msg = hit.toString();
                color = Color.RED;
        }
        msg = String.format("%s %s frappe en %c%d : %s", incoming ? "<=" : "=>",
                incoming ? "L'IA" : playerName,
                ((char) (65 + coords[1])),
                coords[0]+1, msg);
        return ColorUtil.colorize(msg, color);
    }

    private static List<AbstractShip> createDefaultShips() {
        return Arrays.asList(new AbstractShip[]{new Destroyer(), new Submarine(), new Submarine(), new Battleship(), new Carrier()});
    }

    public static void main(String args[]) {
        new Game().init().run();
    }
}
