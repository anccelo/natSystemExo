package partie;

import lombok.Getter;
import model.Card;
import model.Player;

import java.util.*;

@Getter
public class Turn {

    private final List<Player> players;
    private final Map<Card, Player> trick;

    public Turn(final List<Player> players) {
        this.players = players;
        this.trick = new HashMap<>();
    }

    public Map<Card, Player> play() {
        for (Player player : this.players) {
            final Card playedCard = player.play();
            this.trick.put(playedCard, player);
        }
        return trick;
    }

    public Card getWinningCard(final Map<Card, Player> trick) {
        final List<Card> playedCards = new ArrayList<>(trick.keySet());
        final Card defaultHighestCard = playedCards.get(0);
        return playedCards.stream().max(Card::compareTo).orElse(defaultHighestCard);
    }

    public Player getWinner(final Map<Card, Player> trick, final Card winningCard) {
        return trick.get(winningCard);
    }

}
