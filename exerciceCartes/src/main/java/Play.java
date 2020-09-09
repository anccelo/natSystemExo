import model.Player;
import game.Game;

import java.util.List;

import static java.util.Arrays.asList;

public class Play {

    public static void main(String[] args) {

        final Player playerOne = new Player("Diego");
        final Player playerTwo = new Player("Armando");
        final Player playerThree = new Player("Mara");
        final Player playerFour = new Player("Dona");

        final List<Player> players = asList(playerOne, playerTwo, playerThree, playerFour);

        Game game = new Game();
        game.start(players);

    }


}
