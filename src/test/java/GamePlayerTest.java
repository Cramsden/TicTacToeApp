import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

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
        gamePlayer.getMove();
        verify(boardView).placeMove(1, 1);


    }

    @Test
    public void shouldAlertUserWhenInputIsInvalidNumber() throws Exception {
        when(reader.readLine()).thenReturn("0");
        gamePlayer.getMove();
        verify(printStream).println("That is not a valid input, please try again.");

    }

    @Test
    public void shouldShowQuitMessageWhenGameEnds() throws Exception {
        gamePlayer.quit();
        verify(printStream).println("Nice Game the game is over");

    }

    @Test
    public void shouldSwitchPlayerAfterPlayer1moves() throws Exception {
        

    }
}
