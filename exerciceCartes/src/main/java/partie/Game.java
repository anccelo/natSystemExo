package partie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Card;
import model.JeuDeCarte;
import model.Player;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor
public class Game {

    private static final Random RANDOM = new Random();
    private static final Predicate<Player> IS_A_LOOSER = Player::gotBeaten;

    static JeuDeCarte jeu = JeuDeCarte.getInstance();

    private final List<Player> players;

    public void start() {

        mixCards();
        distributionCartes();

        while (thereIsNoLooserYet()) {

            final Turn turn = new Turn(this.players);
            final Map<Card, Player> trick = turn.play();
            final Card winningCard = turn.getWinningCard(trick);
            final Player turnWinner = turn.getWinner(trick, winningCard);

            addTrickCardsToTheWinnerHand(turn, turnWinner);
        }

        System.out.println("The Winner is/are: " + getGameWinner());

    }

    private boolean thereIsNoLooserYet() {
        return this.players.stream().noneMatch(IS_A_LOOSER);
    }


    private void distributionCartes() {
        int count = 1;
        for (Card card : jeu.getPaquet()) {

            switch (count % 4) {
                case 1:
                    players.get(0).assign(card);
                    break;
                case 2:
                    players.get(1).assign(card);
                    break;
                case 3:
                    players.get(2).assign(card);
                    break;
                case 0:
                    players.get(3).assign(card);
                    break;
            }
            count++;
        }
    }

    /**
     * J'ai trouvé les méthodes melanger et echanger depuis une recherche sur Internet.
     */
    private void mixCards() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < jeu.getPaquet().length; j++) {
                echanger(RANDOM.nextInt(jeu.getPaquet().length), RANDOM.nextInt(jeu.getPaquet().length));
            }
        }
    }

    private void addTrickCardsToTheWinnerHand(final Turn turn, final Player turnWinner) {
        turn.getTrick().keySet().forEach(turnWinner::assign);
    }

    private List<Player> getGameWinner() {

        final Integer numberOfCardsToWinTheGame = this.players.stream()
                .map(Player::numberOfCards)
                .max(Integer::compareTo)
                .get();

        return this.players.stream()
                .filter(player -> player.numberOfCards() == numberOfCardsToWinTheGame)
                .collect(toList());

    }

    /**
     * J'ai trouvé les méthodes melanger et echanger depuis une recherche sur Internet.
     */
    private void echanger(int i, int j) {
        Card temp;
        temp = jeu.getPaquet()[i];
        jeu.getPaquet()[i] = jeu.getPaquet()[j];
        jeu.getPaquet()[j] = temp;
    }

}
