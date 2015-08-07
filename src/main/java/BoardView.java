import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cramsden on 8/6/15.
 */
public class BoardView {
    private PrintStream printStream;
    private String board;
    private Map<Integer, Boolean> boardModel;
    private String[] boardArray = new String[9];


    public BoardView(PrintStream printStream) {

        this.printStream = printStream;
        boardModel = new HashMap<>();
        board = "";
        for (int i = 1; i <= 9; i++) {
            boardModel.put(i, false);
        }
        for(int i=0; i <9; i++){
            boardArray[i] = " ";
        }

    }

    public void drawSpacesAndSeparators() {
        board = "";
        for(int i=1; i <=9; i++){
            board += boardArray[i-1];
            if (i%3!=0){
                board += " | ";
            }
            else if(i != 0){
                board += " \n";
                if(i != 9){
                    board += "-----------\n";
                }

            }
        }
        printStream.print(board);

    }

    public void saveMove(Integer place) {
        boardModel.put(place, true);
    }

    public Map<Integer, Boolean> currentBoard() {
        return boardModel;
    }
    public boolean placeMove(Integer place, Integer player){
        if(boardArray[place-1] == " ") {
            if (player == 1) {
                boardArray[place - 1] = "X";
                return true;
            } else {
                boardArray[place - 1] = "0";
                return true;
            }
        }
        else {
            return false;
        }

    }
    public Boolean boardIsFull()
    {
        boolean isFull = true;
        for (Boolean value: boardModel.values())
        {
            if (value == false) {
                isFull = false;
                break;
            }
        }
        return  isFull;
    }



}
