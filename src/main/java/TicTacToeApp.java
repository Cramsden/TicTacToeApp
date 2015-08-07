import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by cramsden on 8/6/15.
 */
public class TicTacToeApp {
    public static void main(String[] args) {
        BoardView boardView = new BoardView(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GamePlayer gamePlayer = new GamePlayer(reader, boardView, System.out);
        gamePlayer.start();
    }
}
