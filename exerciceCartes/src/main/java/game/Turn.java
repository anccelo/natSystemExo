package game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Card;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Turn {

    private final List<Player> players;
    private final Map<Card, Player> hand;

    public Turn(final List<Player> players) {
        this.players = players;
        this.hand = new HashMap<>();
    }

    public Map<Card, Player> play() {
        hand.clear();
        for (Player player : this.players
        ) {
            Card playedCard = player.play();
            hand.put(playedCard, player);
        }
        return hand;
    }

    public Card getWinningCard(final Map< Card, Player> hand) {
        List<Card> playedCards = new ArrayList(hand.keySet());
        Card bigerCard = playedCards.get(0);
        for (Card card : playedCards) {
            int res = card.compareTo(bigerCard);
            if (res == 1)
                bigerCard = card;
        }
        return bigerCard;
    }

    public List<Player> getWinningPlayers(final Map<Card, Player > hand, final Card winningCard) {
        List<Player> winningPlayers = new ArrayList<>();
        for (Card card : hand.keySet()
        ) {
            if (card.getValue() == winningCard.getValue()) {
                winningPlayers.add(hand.get(card));
            }
        }
        return winningPlayers;
    }

    public List<Card> recupererLesCartesDuPLi(final Map<Card, Player> pliActuel) {
        return new ArrayList<>(pliActuel.keySet());
    }

}
