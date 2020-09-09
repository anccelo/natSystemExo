package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Player {

    private final String name;
    private final List<Card> cards = new ArrayList<>();

    private final static Random random = new Random();

    public Player(final String name) {
        this.name = name;
    }

    public void assign(final Card card) {
        this.cards.add(card);
    }

    public Card play() {
        final Card playedCard;
        try {
            int randomCard = random.nextInt(cards.size());
            playedCard = cards.get(randomCard);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("pas de cartes pour ce jouer");
            return null;
        }
        this.getCards().remove(playedCard);
        return playedCard;
    }

    @Override
    public String toString() {
        return this.getName() + " avec " + this.cards.size() + " cartes";
    }
}
