import java.io.PrintStream;
import java.lang.reflect.Array;
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


    public Boolean reportWin() {
        if (boardModel.get(1)==true && boardArray[0].equals(boardArray[1]) && boardArray[1].equals(boardArray[2]))
        {
            return true;
        }
        else if (boardModel.get(4)==true  && boardArray[3].equals(boardArray[4]) && boardArray[4].equals(boardArray[5]))
        {
            return true;
        }
        else if  (boardModel.get(7)==true  && boardArray[6].equals(boardArray[7]) && boardArray[7].equals(boardArray[8]))
        {
            return true;
        }
        else if  (boardModel.get(1)==true  && boardArray[0].equals(boardArray[3]) && boardArray[3].equals(boardArray[6]))
        {
            return true;
        }
        else if  (boardModel.get(2)==true &&  boardArray[1].equals(boardArray[4]) && boardArray[4].equals(boardArray[7]))
        {
            return true;
        }
        else if  (boardModel.get(3)==true  && boardArray[2].equals(boardArray[5]) && boardArray[5].equals(boardArray[8]))
        {
            return true;
        }
        else if  (boardModel.get(1)==true && boardArray[0].equals(boardArray[4]) && boardArray[4].equals(boardArray[8]))
        {
            return true;
        }
        else if (boardModel.get(3)==true  && boardArray[2].equals(boardArray[4]) && boardArray[4].equals(boardArray[6]))
        {
            return true;
        }
        return false;
    }
}
