import model.JeuDeCarte;
import model.Player;
import partie.Game;

import java.util.List;

import static java.util.Arrays.asList;

public class Play {

    public static void main(String[] args) {

        JeuDeCarte.getInstance().printInColumns();

        final Player playerOne = new Player("Manuel");
        final Player playerTwo = new Player("Aurélien");
        final Player playerThree = new Player("Angelo");
        final Player playerFour = new Player("Lionel");
        final List<Player> players = asList(playerOne, playerTwo, playerThree, playerFour);

        final Game game = new Game(players);
        game.start();

    }


}
