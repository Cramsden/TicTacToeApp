import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by cramsden on 8/6/15.
 */
public class GamePlayer {

    private BufferedReader reader;
    private BoardView boardView;
    private PrintStream printStream;
    private Boolean isGame;
    private Integer player;
    private Boolean isFull;
    private Boolean isWon;
    //private Map<Integer,Boolean> BoardModel;

    public GamePlayer(BufferedReader reader, BoardView boardView, PrintStream printStream) {
        this.reader = reader;
        this.boardView = boardView;
        this.printStream = printStream;
        isGame = true;
        player = 1;
    }


    public void getMove() {
        Boolean movePlaced = false;
        while (isGame) {
            isFull = boardView.boardIsFull();
            if (isFull) {
                quit();
                break;
            }
            isWon = boardView.reportWin();
            if (isWon){
                printStream.println("Player " + player + " won!!!");
                quit();
                break;
            }
            printStream.println("Please Enter a Square in Which to move (1-9):");
            String userInput = "";
            try {
                userInput = reader.readLine();
            } catch (IOException e) {
                printStream.println("Could not read user's input.");
            }
            Integer place = Integer.parseInt(userInput);
            if (place <= 9 && place > 0) {
                boardView.saveMove(place);
                movePlaced = boardView.placeMove(place, player);
                boardView.drawSpacesAndSeparators();
            } else {
                printStream.println("That is not a valid input, please try again.");
            }
            if (movePlaced == true) {
                switchPlayer();
                printStream.println(" Player " + player + " it is your turn!");
            }
        }

    }
    public void switchPlayer(){
        if (player ==1)
        {
            player=2;
        }
        else {
            player =1;
        }
    }

    public void quit() {
        isGame = false;
        printStream.println("Nice Game the game is over");
    }
}
