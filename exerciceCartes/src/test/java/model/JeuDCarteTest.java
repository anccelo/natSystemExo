package model;

import org.junit.jupiter.api.Test;

import static model.Couleur.trefle;
import static model.Valeur.deux;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JeuDCarteTest {

    JeuDeCarte jeuDeCarte = JeuDeCarte.getInstance();

    @Test
    void should_return_the_two_of_trefle_when_asked_first_card_of_paquet_of_jeuDeCarte() {
        Carte actual = jeuDeCarte.getPaquet()[0];
        Couleur expectedCouleur = trefle;
        Valeur expectedValeur = deux;
        assertEquals(expectedValeur, actual.getValeur());
        assertEquals(expectedCouleur, actual.getCouleur());
    }

    @Test
    void should_retun_fifty_two_when_count_card_into_paquets_of_jeuDeCarte() {

        int actual = jeuDeCarte.getPaquet().length;
        int expected = 52;

        assertEquals(expected, actual);

    }
}
