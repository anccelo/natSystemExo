package game;

import lombok.Getter;
import model.Card;
import model.DeckOfCards;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
public class Game {

    public final DeckOfCards jeu = DeckOfCards.getInstance();
    private final Random random = new Random();

    public void start(List<Player> players){
        DeckOfCards.getInstance().printInColumns();
        Turn turn = new Turn(players);

        mixCards();
        distributionOfCards(players);

        while (players.get(0).getCards().size() != 0 &&
                players.get(1).getCards().size() != 0 &&
                players.get(2).getCards().size() != 0 &&
                players.get(3).getCards().size() != 0) {
            Map<Card, Player> pliEnCour = turn.play();
            Card cardLaPlusForte = turn.getWinningCard(pliEnCour);
            List<Player> jouersVainqueur = turn.getWinningPlayers(pliEnCour, cardLaPlusForte );

            addTrickCardsToTheWinnersHand(turn, jouersVainqueur);
        }

        System.out.println("The Winner is/are: " + joueursAvecPlusDeCartes(players));
    }
    public void distributionOfCards(List<Player> players) {
        int count = 1;
        for (Card card : jeu.getDeck()) {
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

    public void addTrickCardsToTheWinnersHand(final Turn turn, List<Player> winningPlayers) {
        if (winningPlayers.size() == 0) {
            System.err.println("if you are here, there are a problem...");//todo exceptions
        } else if (winningPlayers.size() == 1) {
            for (Card cardDuPLi : turn.recupererLesCartesDuPLi(turn.getHand())) {
                winningPlayers.get(0).assign(cardDuPLi);
            }
        } else {
            for (int i = 0; i < turn.recupererLesCartesDuPLi(turn.getHand()).size(); i++) {
                int joueurRandom = random.nextInt(winningPlayers.size() - 1);
                winningPlayers.get(joueurRandom).assign(turn.recupererLesCartesDuPLi(turn.getHand()).get(i));
            }
        }
    }

    public List<Player> joueursAvecPlusDeCartes(List<Player> players) {
        List<Player> lesJouersAvecPlusDeCartes = new ArrayList<Player>();
        int PlusDeCartes = players.get(0).getCards().size();
        for (Player player : players) {
            if (player.getCards().size() >= PlusDeCartes) {
                PlusDeCartes = player.getCards().size();
            }
        }
        for (Player player : players) {
            if (player.getCards().size() == PlusDeCartes) {
                lesJouersAvecPlusDeCartes.add(player);
            }
        }
        return lesJouersAvecPlusDeCartes;
    }

    //J'ai trouvé les méthodes melanger et echanger depuis une recherche sur Internet
    private void mixCards() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < jeu.getDeck().length; j++) {
                change(random.nextInt(jeu.getDeck().length), random.nextInt(jeu.getDeck().length));
            }
        }
    }

    //J'ai trouvé les méthodes melanger et echanger depuis une recherche sur Internet
    private void change(int i, int j) {
        Card temp;
        temp = jeu.getDeck()[i];
        jeu.getDeck()[i] = jeu.getDeck()[j];
        jeu.getDeck()[j] = temp;
    }



}
