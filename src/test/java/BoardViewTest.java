import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by cramsden on 8/6/15.
 */
public class BoardViewTest {
    private PrintStream printStream;
    private BoardView boardView;
    private HashMap<Integer, Boolean> boardModel;
    private GamePlayer gamePlayer;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        gamePlayer = mock(GamePlayer.class);
        boardView = new BoardView(printStream);
        boardModel = new HashMap<>();
        for (int i=1; i<=9; i++) {
            boardModel.put(i,false);
        }

    }

    @Test
    public void shouldPrintBoardWhenGameStarts() throws Exception {
        boardView.drawSpacesAndSeparators();
        verify(printStream).print("  |   |   \n" + "-----------\n" + "  |   |   \n" + "-----------\n" + "  |   |   \n");
    }

    @Test
    public void shouldStoreMoveWhenSaveMove() throws Exception {
        boardView.saveMove(1);
        boardModel.put(1, true);
        assertEquals(boardView.currentBoard(), boardModel);

    }

    @Test
    public void shouldPrintBoardWithMoveWhenDrawMove() throws Exception {
        boardView.saveMove(3);
        boardView.placeMove(3, 1);
        boardView.drawSpacesAndSeparators();
        //assertThat(lineChanged, is("   |   | X \n"));
        verify(printStream).print("  |   | X \n" + "-----------\n" + "  |   |   \n" + "-----------\n" + "  |   |   \n");


    }

    @Test
    public void shouldPrintBoardWithTwoMoveWhenDrawTwoMove() throws Exception {
        boardView.saveMove(2);
        boardView.saveMove(3);
        boardView.placeMove(2, 1);
        boardView.placeMove(3, 1);
        boardView.drawSpacesAndSeparators();
        verify(printStream).print("  | X | X \n" + "-----------\n" + "  |   |   \n" + "-----------\n" + "  |   |   \n");


    }

    @Test
    public void shouldMakeOWhenPlayer2Moves() throws Exception {
        boardView.placeMove(1, 1);

    }

    @Test
    public void shouldReportWinWhen3InARow() throws Exception {
        boardView.saveMove(7);
        boardView.saveMove(8);
        boardView.saveMove(9);
        boardView.placeMove(7,1);
        boardView.placeMove(8,1);
        boardView.placeMove(9,1);
        assertEquals(boardView.reportWin(),true);

    }
}
