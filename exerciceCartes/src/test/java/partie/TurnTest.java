package partie;

import model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class TurnTest {

    final Player playerOne = new Player("Manuel");
    final Player playerTwo = new Player("Aurélien");
    final Player playerThree = new Player("Angelo");
    final Player playerFour = new Player("Lionel");
    final List<Player> players = asList(playerOne, playerTwo, playerThree, playerFour);

    Turn turn = new Turn(players);

    @Test
    void should_return_an_as_when_into_a_pli_there_are_a_only_one_as(){


        //turn.determinerLaCartePLusForteDuPli();

    }
}
