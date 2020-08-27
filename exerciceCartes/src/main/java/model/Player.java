package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Player {

    private static final Random RANDOM = new Random();

    private final String name;
    private final List<Card> cards;

    public Player(final String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void assign(final Card card) {
        this.cards.add(card);
    }

    public Card play() {
        final Card playedCard;
        try {
            int carteRandom = RANDOM.nextInt(cards.size());
            playedCard = cards.get(carteRandom);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("pas de cards pour ce jouer");
            return null;
        }
        this.getCards().remove(playedCard);
        return playedCard;
    }

    @Override
    public String toString() {
        return name + " with " + cards.size() + " cards";
    }

    public boolean gotBeaten() {
        return this.getCards().isEmpty();
    }

    public int numberOfCards(){
        return this.getCards().size();
    }

}
