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
    //private Map<Integer,Boolean> BoardModel;

    public GamePlayer(BufferedReader reader, BoardView boardView, PrintStream printStream) {
        this.reader = reader;
        this.boardView = boardView;
        this.printStream = printStream;
        isGame = true;
    }


    public void getMove() {
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
                boardView.placeMove(place, 1);
                boardView.drawSpacesAndSeparators();
            } else {
                printStream.println("That is not a valid input, please try again.");
            }




    }

    public void quit() {
        isGame = false;
        printStream.println("Nice Game the game is over");
    }
}
