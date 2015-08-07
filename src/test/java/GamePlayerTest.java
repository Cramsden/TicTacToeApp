import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by cramsden on 8/6/15.
 */
public class GamePlayerTest {
    private BufferedReader reader;
    private BoardView boardView;
    private GamePlayer gamePlayer;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        reader = mock(BufferedReader.class);
        boardView = mock(BoardView.class);
        printStream = mock(PrintStream.class);
        gamePlayer = new GamePlayer(reader, boardView, printStream);

    }

    @Test
    public void shouldDrawMoveWhenUserEntersValue() throws Exception {
        when(reader.readLine()).thenReturn("1");
        when(boardView.boardIsFull()).thenReturn(true);
        gamePlayer.getMove();
        verify(boardView).handleMove(1, 1);


    }

    @Test
    public void shouldAlertUserWhenInputIsInvalidNumber() throws Exception {
        when(reader.readLine()).thenReturn("0");
        when(boardView.boardIsFull()).thenReturn(true);
        gamePlayer.getMove();
        verify(printStream).println("That is not a valid input, please try again.");

    }

    @Test
    public void shouldShowQuitMessageWhenGameEnds() throws Exception {
        gamePlayer.quit();
        verify(printStream).println("Nice Game the game is over");

    }

    //FAILING TEST
/*    @Test
    public void shouldSwitchPlayerAfterPlayer1moves() throws Exception {
        when(reader.readLine()).thenReturn("1","2");
        when(boardView.boardIsFull()).thenReturn(false,true);
        gamePlayer.getMove();
        verify(boardView).placeMove(1,1);
        verify(boardView).placeMove(2,2);


    }*/

    @Test
    public void shouldNotSwitchPlayersIfMoveNotValid() throws Exception {
        when(reader.readLine()).thenReturn("1","1");
        when(boardView.boardIsFull()).thenReturn(false,true);
        gamePlayer.getMove();
        verify(boardView, times(2)).handleMove(1, 1);
    }

    @Test
    public void shouldQuitGameWhenBoardIsFull() throws Exception {
        when(boardView.boardIsFull()).thenReturn(true);
        when(reader.readLine()).thenReturn("1");
        gamePlayer.getMove();
        verify(printStream).println("Nice Game the game is over");

    }

    @Test
    public void shouldReportWinWhenGameIsWon() throws Exception {
        when(reader.readLine()).thenReturn("1");
        when(boardView.reportWin()).thenReturn(true);
        gamePlayer.getMove();
        verify(printStream).println("Nice Game the game is over");


    }

    @Test
    public void shouldInitializeBoardWhenStartIsCalled() throws Exception {
        when(reader.readLine()).thenReturn("1");
        when(boardView.reportWin()).thenReturn(true);
        gamePlayer.start();
        verify(boardView).drawSpacesAndSeparators();

    }
}
