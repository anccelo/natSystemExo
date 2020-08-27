package model;

import org.junit.jupiter.api.Test;

import static model.Color.CLUBS;
import static model.Value.TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JeuDCardTest {

    JeuDeCarte jeuDeCarte = JeuDeCarte.getInstance();

    @Test
    void should_return_the_two_of_trefle_when_asked_first_card_of_paquet_of_jeuDeCarte() {
        Card actual = jeuDeCarte.getPaquet()[0];
        Color expectedColor = CLUBS;
        Value expectedValue = TWO;
        assertEquals(expectedValue, actual.getValue());
        assertEquals(expectedColor, actual.getColor());
    }

    @Test
    void should_retun_fifty_two_when_count_card_into_paquets_of_jeuDeCarte() {

        int actual = jeuDeCarte.getPaquet().length;
        int expected = 52;

        assertEquals(expected, actual);

    }
}
