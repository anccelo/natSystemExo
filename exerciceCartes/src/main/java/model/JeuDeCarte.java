package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static model.Color.*;

@Getter
public class JeuDeCarte {

    private final Card[] paquet = new Card[52];

    private JeuDeCarte() {
        int i = 0;
        for (Color coleur : Color.values()) {
            for (Value valuer : Value.values()
            ) {
                paquet[i] = new Card(coleur, valuer);
                i++;
            }
        }
    }

    private static class JeuDeCarteHolder {
        private static final JeuDeCarte instance = new JeuDeCarte();
    }

    public static JeuDeCarte getInstance() {
        return JeuDeCarteHolder.instance;
    }

    public void printInColumns() {
        List<Card> trefles = new ArrayList<>();
        List<Card> carreaux = new ArrayList<>();
        List<Card> coeurs = new ArrayList<>();
        List<Card> piques = new ArrayList<>();
        for (Card card : paquet) {
            if (card.getColor() == CLUBS)
                trefles.add(card);
            if (card.getColor() == DIAMONDS)
                carreaux.add(card);
            if (card.getColor() == HEARTS)
                coeurs.add(card);
            if (card.getColor() == SPADES)
                piques.add(card);
        }
        for (int i = 0; i < 13; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s\n", trefles.get(i), carreaux.get(i), coeurs.get(i),
                    piques.get(i));
        }
        System.out.println();
    }

}
